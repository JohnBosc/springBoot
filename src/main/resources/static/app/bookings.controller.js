
(function(){
    'use strict';

    angular
        .module('app')
        .controller('BookingsController', BookingsController);

    BookingsController.$inject = ['$http'];

    function BookingsController($http){
        var vm = this;

        vm.bookingList = [];
        vm.getAll = getAll;
        vm.getAffordable = getAffordable;
        vm.deleteBooking = deleteBooking;

        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/bookings/all";
            var  bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookingList = response.data;
            });
        }

        function getAffordable(){
            var url = "/bookings/affordable/" + 100;
            var  bookingsPromise = $http.get(url);
            bookingsPromise.then(function(response){
                vm.bookingList = response.data;});
        }

        function deleteBooking(id){
            var url = "/bookings/delete/" + id;
            $http.post(url).then(function(response){
               vm.bookingList = response.data;
            });
        }
    }
})();