#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a;
  cin >> n >> a;
  int arr[n];
  int final = 1;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  sort(arr, arr + n);
  for (int i = n - 1; i >= 0; i--) {
    if (a % arr[i] == 0) {
      final = a / arr[i];
      break;
    }
  }
  cout << final;
}
