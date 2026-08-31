#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, arr[100006], arr1[100006], arr2[100006], i;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> arr[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> arr1[i];
  }
  for (i = 0; i < n - 2; i++) {
    cin >> arr2[i];
  }
  sort(arr, arr + n);
  sort(arr1, arr1 + n - 1);
  sort(arr2, arr2 + n - 2);
  long long int j = 0;
  for (i = 0; i < n - 1; i++) {
    if (arr[i] != arr1[i]) {
      cout << arr[i] << endl;
      break;
    }
  }
  if (i == n - 1) cout << arr[n - 1] << endl;
  for (i = 0; i < n - 2; i++) {
    if (arr1[i] != arr2[i]) {
      cout << arr1[i] << endl;
      break;
    }
  }
  if (i == n - 2) cout << arr1[n - 2] << endl;
  return 0;
}
