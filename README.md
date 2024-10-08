# 가족 도착 알리미
---

# Table of contents
---
- [서비스 시나리오](#서비스-시나리오)
    - [기능적요구사항](#기능적-요구사항)
    - [비기능적요구사항](#비기능적-요구사항)
    - [분석설계](#분석-설계)
    - [이벤트스토밍 결과](#event-storming-결과)
- [구현]
- [운영]

## 서비스 시나리오

---

### 기능적 요구사항

1. 고객 가족구성원을 등록/삭제/조회한다.
2. 원격지에서 가족구성원이 이동을 시작하면 웹으로 전달된다.
3. 가족구성원이 원격지에서 출발한다.
4. 가족구성원이 이동을 취소할 수 있다.
5. 고객이 이동상태를 중간중간 조회한다.
6. 경유지가 바뀌거나/도착 10분전 마다 웹으로 알림을 보낸다.

### 비기능적 요구사항

1. 트랜잭션
    - 이동을 취소한 가족구성원은 출발하지 않아야 한다. (Sync 호출)
2. 장애격리
    - 이동 시스템이 과중되면 이동 좌표를 잠시동안 받지 않고 잠시 후에 받도록 유도한다.
        
        Circuit breaker, fallback
        
3. 성능
    - 모든 가족 구성원에 대한 위치 정보 및 이동 상태 등을 한번에 확인할 수 있어야한다. (CQRS)
    - 도착 상태가 바뀔 때마다 웹 알림을 줄 수 있어야 한다. (Event driven)

## 분석 설계

---

![스크린샷 2024-10-07 오후 2.05.42.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-10-07_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.05.42.png)

![스크린샷 2024-10-07 오후 2.05.23.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA_2024-10-07_%25E1%2584%258B%25E1%2585%25A9%25E1%2584%2592%25E1%2585%25AE_2.05.23.png)

## Event Storming 결과

---

### 이벤트 도출

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image.png)

### 추가 이벤트 도출

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%201.png)

이동이 종료되었을 때 Event를 생성할 필요가 있음

### 액터, 커맨드 연결

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%202.png)

### 어그리게잇 묶기 및 바운디드 컨텍스트 매핑

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%203.png)

### 모델 수정 및 비기능 요구사항 검증

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%204.png)

### 가족구성원 승인여부 및 위치 등록 요구사항 수정

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%205.png)

### 목적지 위치 등록에 따른 move Policy 변경

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%206.png)

### 최종 (불필요한 Policy 제거, customer/family 로직 분기)

![image.png](AICT%20Cloud%20Project%20b2a5de0cd0f54fa1bbb1cbd870b78442/image%207.png)

사용자와 가족단위를 함께 승인 및 거절 처리하는 것은 어렵다고 판단하여, 컨텍스트를 분리.

회원가입 시 가족을 등록하면 가족 구성원이 승인 및 거절 판별 후에 승인 시 가족이 되는 식으로 변경.

