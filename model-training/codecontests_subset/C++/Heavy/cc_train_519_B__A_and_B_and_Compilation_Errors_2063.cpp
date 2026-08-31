#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, *arr, *arr1, *arr2, ans1, ans2;
  cin >> n;
  arr = (int *)malloc(n * sizeof(int));
  arr1 = (int *)malloc((n - 1) * sizeof(int));
  arr2 = (int *)malloc((n - 2) * sizeof(int));
  for (int x = 0; x < n; x++) {
    cin >> arr[x];
  }
  sort(arr, arr + n);
  for (int x = 0; x < n - 1; x++) {
    cin >> arr1[x];
  }
  sort(arr1, arr1 + n - 1);
  for (int x = 0; x < n - 2; x++) {
    cin >> arr2[x];
  }
  sort(arr2, arr2 + n - 2);
  for (int x = 0; x < n; x++) {
    if (arr[x] != arr1[x]) {
      ans1 = arr[x];
      break;
    }
  }
  for (int x = 0; x < n - 1; x++) {
    if (arr1[x] != arr2[x]) {
      ans2 = arr1[x];
      break;
    }
  }
  cout << ans1 << "\n" << ans2;
}
