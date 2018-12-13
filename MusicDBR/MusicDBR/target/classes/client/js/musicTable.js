function pageLoad() {
    addTable();
    deleteRow();
}

function addTable(){
    $.ajax({
        url: '/track/list',
        type: 'GET',
        success: trackList => {

            let trackHTML = `<table class="table-striped table-bordered table-hover">` +
                `<tr>` +
                `<th scope="col-1"></th>` +
                `<th scope="col-2">Track No</th>` +
                `<th scope="col-3">Year</th>` +
                `<th scope="col-3">Artist</th>` +
                `<th scope="col-3">Track Title</th>` +
                `</tr>`;
            for (let track of trackList) {trackHTML += `<tr>` +
                `<td><input id="removebutton" type="button" value="Remove">` +
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