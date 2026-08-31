#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, arr[150];
  int i, max = -10000000;
  cin >> n >> c;
  for (i = 0; i < n; i++) cin >> arr[i];
  for (i = 0; i < n - 1; i++) {
    if (arr[i] - arr[i + 1] - c > max) {
      max = arr[i] - arr[i + 1] - c;
    }
  }
  if (max <= 0)
    cout << 0 << endl;
  else
    cout << max << endl;
  return 0;
}
