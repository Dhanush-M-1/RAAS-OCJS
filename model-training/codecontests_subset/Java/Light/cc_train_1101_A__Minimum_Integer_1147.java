var q = +readline();

var i = 0;
var arr = [];
while(i < q) {
	arr[i] = readline().split(' ');
	i++;
}
i = 0;

while(i < q) {
    arr[i][0] = +arr[i][0];
    arr[i][1] = +arr[i][1];
    arr[i][2] = +arr[i][2];

	if((arr[i][2] >= arr[i][0] && arr[i][2] <= arr[i][1]) && (arr[i][2] >= arr[i][0] || arr[i][2] <= arr[i][0])) {
		print(+(+arr[i][1] + (+arr[i][2] - +arr[i][1]%+arr[i][2])));
    } else {
		print(arr[i][2]);
    }

    i++;
}