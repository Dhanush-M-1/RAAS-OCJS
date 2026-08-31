#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, diff, max;
  cin >> n >> c;
  int arr[n];
  for (int i = 0; i < n; i++) cin >> arr[i];
  for (int i = 0; i < n - 1; i++) {
    if (i == 0) {
      diff = max = arr[i] - arr[i + 1];
    } else {
      diff = arr[i] - arr[i + 1];
      if (diff > max) max = diff;
    }
  }
  if (max - c >= 0)
    cout << max - c;
  else
    cout << 0;
  return 0;
}
