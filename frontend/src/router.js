
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CustomerCutomerManager from "./components/listers/CustomerCutomerCards"
import CustomerCutomerDetail from "./components/listers/CustomerCutomerDetail"

import MoveMoveManager from "./components/listers/MoveMoveCards"
import MoveMoveDetail from "./components/listers/MoveMoveDetail"

import FamilyFamilyManager from "./components/listers/FamilyFamilyCards"
import FamilyFamilyDetail from "./components/listers/FamilyFamilyDetail"
import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"


import LocationLocationManager from "./components/listers/LocationLocationCards"
import LocationLocationDetail from "./components/listers/LocationLocationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/customers/cutomers',
                name: 'CustomerCutomerManager',
                component: CustomerCutomerManager
            },
            {
                path: '/customers/cutomers/:id',
                name: 'CustomerCutomerDetail',
                component: CustomerCutomerDetail
            },

            {
                path: '/moves/moves',
                name: 'MoveMoveManager',
                component: MoveMoveManager
            },
            {
                path: '/moves/moves/:id',
                name: 'MoveMoveDetail',
                component: MoveMoveDetail
            },

            {
                path: '/families/families',
                name: 'FamilyFamilyManager',
                component: FamilyFamilyManager
            },
            {
                path: '/families/families/:id',
                name: 'FamilyFamilyDetail',
                component: FamilyFamilyDetail
            },
            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },


            {
                path: '/locations/locations',
                name: 'LocationLocationManager',
                component: LocationLocationManager
            },
            {
                path: '/locations/locations/:id',
                name: 'LocationLocationDetail',
                component: LocationLocationDetail
            },



    ]
})
