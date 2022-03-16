//Upercase
mainApp.directive('uppercased', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, modelCtrl) {
            modelCtrl.$parsers.push(function (input) {
                return input ? input.toUpperCase() : "";
            });
            element.css("text-transform", "uppercase");
        }
    };
});

//Disable cut, copy and past
mainApp.directive('stopccp', function () {
    return {
        scope: {},
        link: function (scope, element) {
            //element.on('cut copy paste', function (event) {
            element.on('paste', function (event) {
                event.preventDefault();
            });
        }
    };
});

var compareTo = function () {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function (scope, element, attributes, ngModel) {

            ngModel.$validators.compareTo = function (modelValue) {
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function () {
                ngModel.$validate();
            });
        }
    };
};

mainApp.directive("compareTo", compareTo);
