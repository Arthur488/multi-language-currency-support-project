function changeLanguage(lang) {
    // Отправляем выбранный язык на сервер
    $.post("/Shop/changeLanguage", {language: lang}, function () {
        // Перезагружаем страницу для применения выбранного языка
        location.reload();
    });
}

function changeCurrency(currency) {
    $.post("/Shop/api/changeCurrency", {currency: currency})
        .done(function () {
            console.log("Currency changed successfully.")
            location.reload();
        }).fail(function () {
        console.log("An error occurred while changing currency.")
    });
}