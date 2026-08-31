#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  const int size = n;
  int arr[size], arr1[size], arr2[size];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  for (int i = 0; i < n - 1; i++) {
    cin >> arr1[i];
  }
  sort(arr1, arr1 + (n - 1));
  for (int i = 0; i < n - 2; i++) {
    cin >> arr2[i];
  }
  sort(arr2, arr2 + (n - 2));
  for (int i = 0; i < n; i++) {
    if (arr[i] != arr1[i]) {
      cout << arr[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (arr1[i] != arr2[i]) {
      cout << arr1[i] << endl;
      break;
    }
  }
  return 0;
}
