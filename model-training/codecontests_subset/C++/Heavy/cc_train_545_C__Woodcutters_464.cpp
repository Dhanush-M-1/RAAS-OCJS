#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, x[N], h[N], second[N], r[N], l[N];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
    if (i) {
      second[i] = second[i - 1];
      r[i] = r[i - 1];
      l[i] = l[i - 1];
      if (x[i] > x[i - 1] + h[i - 1]) {
        second[i] = max(second[i], r[i - 1]);
        r[i] = max(r[i], r[i - 1] + 1);
        if (x[i] - h[i] > x[i - 1] + h[i - 1]) l[i] = max(l[i], r[i - 1] + 1);
      }
      if (x[i] > x[i - 1]) {
        int y = max(second[i - 1], l[i - 1]) + 1;
        second[i] = max(second[i], y - 1);
        r[i] = max(r[i], y);
        if (x[i] - h[i] > x[i - 1]) l[i] = max(l[i], y);
      }
    } else {
      second[0] = 1;
      r[0] = 1;
      l[0] = 1;
    }
  }
  int ans = max(second[n - 1], r[n - 1]);
  cout << max(ans, l[n - 1]) << '\n';
  return 0;
}
