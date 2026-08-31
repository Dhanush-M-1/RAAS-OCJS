#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int arr[n];
  int arr2[n];
  int arr3[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> arr2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> arr3[i];
  }
  sort(arr, arr + n);
  sort(arr2, arr2 + n - 1);
  sort(arr3, arr3 + n - 2);
  int count1 = 0;
  int count2 = 0;
  for (int i = 0; i < n - 1; i++) {
    if (arr[i] != arr2[i]) {
      cout << arr[i] << endl;
      count1 = 1;
      break;
    }
  }
  if (count1 == 0) {
    cout << arr[n - 1] << endl;
  }
  for (int i = 0; i < n - 2; i++) {
    if (arr2[i] != arr3[i]) {
      cout << arr2[i];
      count2 = 1;
      break;
    }
  }
  if (count2 == 0) {
    cout << arr2[n - 2];
  }
  return 0;
}
