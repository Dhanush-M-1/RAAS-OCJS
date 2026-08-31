#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a = 0, b = 0, c = 0;
  int arr[100000], arr1[100000], arr2[100000], arr3[100000], arr4[100000];
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> arr1[i];
  }
  sort(arr1, arr1 + t);
  for (int i = 0; i < t - 1; i++) {
    cin >> arr2[i];
  }
  sort(arr2, arr2 + (t - 1));
  for (int i = 0; i < t - 2; i++) {
    cin >> arr3[i];
  }
  sort(arr3, arr3 + (t - 2));
  for (int i = 0; i < t; i++) {
    if (arr1[i] != arr2[i]) {
      cout << arr1[i] << endl;
      break;
    }
  }
  for (int i = 0; i < t - 1; i++) {
    if (arr2[i] != arr3[i]) {
      cout << arr2[i] << endl;
      break;
    }
  }
  return 0;
}
