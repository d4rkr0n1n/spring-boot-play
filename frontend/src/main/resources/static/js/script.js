function updateDiv(contents) {
  alert("Note added successfully!");
  $.ajax({
    url: "/createNote",
    type: "POST",
    data: { contents: contents },
    success: function (response) {
      $("#notes").replaceWith(response);
      $('#newNoteInput').val('');
    }
  });
}
function delDiv(noteId) {
  alert("Note deleted successfully!");
  $.ajax({
    url: "/deleteNote",
    type: "DELETE",
    data: { id: noteId },
    success: function (response) {
      $("#notes").replaceWith(response);
    }
  });
}
function updDiv(noteId, contents) {
  alert("Note updated successfully!");
  $.ajax({
    url: "/updateNote",
    type: "PUT",
    data: { id: noteId, contents: contents },
    success: function (response) {
      $("#notes").replaceWith(response);
    }
  });
}