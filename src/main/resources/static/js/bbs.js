"use strict";
$(function () {
  $(".likeCountButton").on("click", function () {
    let articleId = $(this).prop("id");
    let likeCount = $("#likeCount" + articleId).text();
    let hostUrl = "http://localhost:8081/like/count";
    $.ajax({
      url: hostUrl,
      type: "post",
      dataType: "json",
      data: {
        articleId: articleId,
        likeCount: likeCount,
      },
      async: true,
    })
      .done(function (data) {
        $("#likeCount" + articleId).text(data.likeCount);
      })
      .fail(function (XMLHttpRequest, textStatus, errorThrown) {
        console.log("XMLHttpRequest: " + XMLHttpRequest.status);
        console.log("textStatus: " + textStatus);
        console.log("errorThrown: " + errorThrown.message);
      });
  });
});
