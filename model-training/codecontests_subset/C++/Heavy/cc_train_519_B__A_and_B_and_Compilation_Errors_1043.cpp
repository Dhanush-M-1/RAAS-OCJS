#include <bits/stdc++.h>
using namespace std;
int binarySearch(int arr[], int p, int r, int num) {
  if (p <= r) {
    int mid = (p + r) / 2;
    if (arr[mid] == num) return mid;
    if (arr[mid] > num) return binarySearch(arr, p, mid - 1, num);
    if (arr[mid] < num) return binarySearch(arr, mid + 1, r, num);
  }
  return -1;
}
int main() {
  int n;
  cin >> n;
  vector<int> arr(n);
  vector<int> arr2(n - 1);
  vector<int> arr3(n - 2);
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> arr2[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> arr3[i];
  }
  int ind = -1;
  sort(arr.begin(), arr.end());
  sort(arr2.begin(), arr2.end());
  sort(arr3.begin(), arr3.end());
  for (int i = 0; i < n - 1; i++) {
    if (arr[i] != arr2[i]) {
      ind = i;
      break;
    }
  }
  if (ind > -1)
    cout << arr[ind] << "\n";
  else
    cout << arr[n - 1] << "\n";
  ind = -1;
  for (int i = 0; i < n - 2; i++) {
    if (arr2[i] != arr3[i]) {
      ind = i;
      break;
    }
  }
  if (ind > -1)
    cout << arr2[ind] << "\n";
  else
    cout << arr2[n - 2] << "\n";
}
