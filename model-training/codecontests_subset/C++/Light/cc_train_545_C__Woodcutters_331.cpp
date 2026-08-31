#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x[n], h[n], i;
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  int cnt = 1;
  int l = x[0];
  for (i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > l) {
      l = x[i];
      cnt++;
    } else if (x[i] + h[i] < x[i + 1]) {
      cnt++;
      l = x[i] + h[i];
    } else {
      l = x[i];
    }
  }
  if (n > 1) cnt++;
  cout << cnt;
  return 0;
}
