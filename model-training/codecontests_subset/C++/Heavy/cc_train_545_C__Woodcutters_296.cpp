#include <bits/stdc++.h>
using namespace std;
int n;
int x[100010], h[100010];
int main() {
  while (cin >> n) {
    int ans = 0;
    int pre = 0;
    for (int i = 0; i < n; ++i) {
      cin >> x[i] >> h[i];
    }
    for (int i = 0; i < n; ++i) {
      if (i == 0)
        ans++;
      else {
        if (pre) {
          if (h[i] + h[i - 1] + 1 <= x[i] - x[i - 1]) {
            ans++;
            pre = 0;
          } else {
            if (i == n - 1 || h[i] + 1 <= x[i + 1] - x[i]) {
              ans++;
              pre = 1;
            } else {
              pre = 0;
            }
          }
        } else {
          if (h[i] + 1 <= x[i] - x[i - 1]) {
            ans++;
          } else {
            if (i == n - 1 || h[i] + 1 <= x[i + 1] - x[i]) {
              ans++;
              pre = 1;
            } else {
              pre = 0;
            }
          }
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
