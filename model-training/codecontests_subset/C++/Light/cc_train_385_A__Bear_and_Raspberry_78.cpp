#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  while (cin >> n >> k) {
    int arr[n];
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
    }
    int mx = 0;
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] - arr[i + 1] - k > mx) {
        mx = arr[i] - arr[i + 1] - k;
      }
    }
    cout << mx << endl;
  }
  return 0;
}
