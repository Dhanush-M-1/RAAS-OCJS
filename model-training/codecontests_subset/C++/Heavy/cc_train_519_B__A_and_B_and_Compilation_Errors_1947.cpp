#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int ar[n], arr[n - 1], arrr[n - 2];
  for (int i = 0; i < n; i++) cin >> ar[i];
  for (int i = 0; i < n - 1; i++) cin >> arr[i];
  for (int i = 0; i < n - 2; i++) cin >> arrr[i];
  sort(ar, ar + n);
  sort(arr, arr + n - 1);
  sort(arrr, arrr + n - 2);
  for (int i = 0; i < n; i++) {
    if (i == n - 1) {
      cout << ar[i] << endl;
      break;
    }
    if (ar[i] != arr[i]) {
      cout << ar[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (i == n - 2) {
      cout << arr[i] << endl;
      return 0;
    }
    if (arr[i] != arrr[i]) {
      cout << arr[i] << endl;
      return 0;
    }
  }
  return 0;
}
