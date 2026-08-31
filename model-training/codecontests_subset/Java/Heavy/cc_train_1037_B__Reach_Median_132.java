
var n_target = readline();
// var n_target = '7 20';
var n = +(n_target.split(' ')[0]);
var target = +(n_target.split(' ')[1]);
var nums = readline();
// var nums = '21 15 12 11 20 19 12';
nums = nums.split(' ').map(function (ele) {
    return +ele;
});

var k = Math.floor(n / 2);

// function part(start, end) {
//     var p = nums[start];
//     while (start < end) {
//         while (start < end && nums[end] > p) {
//             end--;
//         }
//         nums[start] = nums[end];
//         while (start < end && nums[start] <= p) {
//             start++;
//         }
//         nums[end] = nums[start];
//     }
//     nums[start] = p;
//     return start;
// }
// function quickSort(k, start, end) {
//     if (start < end) {
//         var p = part(start, end);
//         if (p === k) return;
//         if (p > k) quickSort(k, start, p - 1);
//         if (p < k) quickSort(k - p - 1, p + 1, end);
//     }
// }

// quickSort(k, 0, n - 1);
nums.sort(function (a, b) {
    return a - b;
})
var rst = 0;
if (nums[k]<= target) {
    for (var i = k; i < n; i++) {
        rst += Math.max(target - nums[i], 0);
    }
} else {
    for (var i = 0; i <= k; i++) {
        rst += Math.max(nums[i] - target, 0);
    }
}

print(rst)
// console.log(rst)



