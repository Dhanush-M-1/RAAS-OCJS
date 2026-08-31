#include <bits/stdc++.h>
using namespace std;
int arr[100000], arr2[100000], arr3[100000];
int main() {
  int n;
  string s;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> arr[i];
  sort(arr, arr + n);
  for (int i = 0; i < n - 1; i++) cin >> arr2[i];
  sort(arr2, arr2 + (n - 1));
  for (int i = 0; i < n - 2; i++) cin >> arr3[i];
  sort(arr3, arr3 + (n - 2));
  for (int i = 0; i < n; i++) {
    if (arr[i] != arr2[i]) {
      cout << arr[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (arr2[i] != arr3[i]) {
      cout << arr2[i];
      break;
    }
  }
  return 0;
}
