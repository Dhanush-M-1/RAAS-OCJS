#include <bits/stdc++.h>
using namespace std;
long long search(int *arr, int cost, long long n) {
  for (int i = n - 1; i > -1; i--) {
    if (cost >= arr[i]) {
      return i + 1;
    }
  }
  return 0;
}
int main() {
  long long n;
  cin >> n;
  unordered_map<int, int> amp;
  int *arr = new int[n];
  for (int i = 0; i < n; i++) {
    int x = 0;
    cin >> arr[i];
  }
  sort(arr, arr + n);
  int *arr1 = new int[n - 1];
  for (int i = 0; i < n - 1; ++i) {
    cin >> arr1[i];
  }
  sort(arr1, arr1 + n - 1);
  for (int i = 0; i < n; ++i) {
    if (arr[i] != arr1[i] && i < n - 1) {
      cout << arr[i] << endl;
      break;
    }
    if (i == n - 1) {
      cout << arr[i] << endl;
    }
  }
  int *arr2 = new int[n - 2];
  for (int i = 0; i < n - 2; ++i) {
    cin >> arr2[i];
  }
  sort(arr2, arr2 + n - 2);
  for (int i = 0; i < n - 1; ++i) {
    if (arr1[i] != arr2[i] && i < n - 2) {
      cout << arr1[i] << endl;
      break;
    }
    if (i == n - 2) {
      cout << arr1[i] << endl;
    }
  }
}
