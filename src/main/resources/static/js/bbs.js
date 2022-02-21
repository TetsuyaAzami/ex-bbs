// "use strict";
// $(function () {
//   $("#likePlusButton").on("click", function () {
//     //   let likeCount = $("#");
//     let hostUrl = "http://localhost:8081/like/count";
//     $.ajax({
//       url: hostUrl,
//       type: "post",
//       dataType: "json",
//       data: {
//         likeCount: likeCount,
//       },
//       async: true,
//     })
//       .done(function (data) {
//         console.log(data);
//         console.dir(JSON.stringify(data));
//         $("#likeCount").text(data.likeCount);
//         likeCount = data.likeCount;
//       })
//       .fail(function (XMLHttpRequest, textStatus, errorThrown) {
//         alert("エラーが発生しました");
//         console.log("XMLHttpRequest: " + XMLHttpRequest.status);
//         console.log("textStatus: " + textStatus);
//         console.log("errorThrown: " + errorThrown.message);
//       });
//   });
// });
