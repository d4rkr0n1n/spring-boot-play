function updateDiv(contents) {
  alert("Note added successfully!");
  $.ajax({
    url: "/refresh1",
    type: "GET",
    data: { contents: contents },
    success: function (response) {
      $("#myDiv").replaceWith(response);
      $('#newNoteInput').val('');
    }
  });
}
function delDiv(noteId) {
  alert("Note deleted successfully!");
  $.ajax({
    url: "/refreshdel",
    type: "DELETE",
    data: { id: noteId },
    success: function (response) {
      $("#myDiv").replaceWith(response);
    }
  });
}
function updDiv(noteId, contents) {
  alert("Note updated successfully!");
  $.ajax({
    url: "/refreshupd",
    type: "PUT",
    data: { id: noteId, contents: contents },
    success: function (response) {
      $("#myDiv").replaceWith(response);
    }
  });
}