function pageLoad() {
    addTable();
    deleteRow();
}

function addTable(){
    $.ajax({
        url: '/track/list',
        type: 'GET',
        success: trackList => {
            let trackHTML = `<form>` +
                `<input type="button" class="add-row" value="Add track">`+
                `<input type="text" id="artist" placeholder="Artist name/band">`+
                `<input type="text" id="title" placeholder="Track Title">`+
                `<input type="text" id="year" placeholder="Year">`+
                `</form>` +
                `<table class="table-striped table-bordered table-hover">` +
                `<tr>` +
                `<th scope="col-1">Select</th>` +
                `<th scope="col-2">Track No</th>` +
                `<th scope="col-3">Year</th>` +
                `<th scope="col-3">Artist</th>` +
                `<th scope="col-3">Track Title</th>` +
                `</tr>`;
            for (let track of trackList) {trackHTML += `<tr>` +
                `<td><input id="remove" type="checkbox">` +
                `<td>${track.trackId}</td>` +
                `<td>${track.year}</td>` +
                `<td>${track.artist}</td>` +
                `<td>${track.title}</td>` +
                `</tr>`
                ;}
            trackHTML+=`</table>`;
            $('#trackList').html(trackHTML);
        }

    });
}

function deleteRow(btn){
    var row = btn.parentNode.parentNode;
    row.parentNode.removeChild(row);
}