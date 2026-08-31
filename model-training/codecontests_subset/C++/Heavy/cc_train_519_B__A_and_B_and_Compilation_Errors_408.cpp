#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y, cnt1 = 0, cnt2 = 0;
  cin >> n;
  int arr[n];
  int arr1[n - 1];
  int arr2[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> arr1[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> arr2[i];
  }
  sort(arr, arr + n);
  sort(arr1, arr1 + n - 1);
  sort(arr2, arr2 + n - 2);
  for (int i = 0; i < n - 1; i++) {
    if (arr1[i] != arr[i]) {
      x = arr[i];
      cnt1++;
      break;
    }
  }
  if (cnt1 == 0) x = arr[n - 1];
  for (int i = 0; i < n - 2; i++) {
    if (arr1[i] != arr2[i]) {
      y = arr1[i];
      cnt2++;
      break;
    }
  }
  if (cnt2 == 0) y = arr1[n - 2];
  cout << x << endl << y;
  return 0;
}
