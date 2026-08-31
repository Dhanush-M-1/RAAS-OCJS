#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e18;
const int mod = 1e9 + 7;
const int maxn = 1e6 + 10;
int n;
long long c[maxn], d[maxn];
long long f[22], p[22], mx[5], b[5];
long long ans = 0;
void dp() {
  for (int i = 0; i <= 9; i++) {
    for (int j = 1; j <= 3; j++) {
      if (i + j < 10)
        f[i + j] = max(f[i + j], p[i] + mx[j]);
      else
        f[i + j - 10] = max(f[i + j - 10], p[i] + mx[j] + b[j]);
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= 9; i++) f[i] = -inf;
  for (int i = 1, m; i <= n; i++) {
    cin >> m;
    for (int i = 1; i <= 3; i++) mx[i] = -inf;
    memset(b, 0, sizeof(b));
    memcpy(p, f, sizeof(p));
    for (int j = 1; j <= m; j++) {
      cin >> c[j] >> d[j];
      mx[1] = max(d[j], mx[1]);
      b[1] = max(d[j], b[1]);
    }
    dp();
    long long mx1 = -inf, mx2 = -inf, mx3 = -inf;
    for (int j = 1; j <= m; j++) {
      if (c[j] == 1) {
        if (d[j] > mx1) {
          mx2 = mx1;
          mx1 = d[j];
        } else if (d[j] > mx2) {
          mx2 = d[j];
        }
      } else if (c[j] == 2) {
        mx3 = max(mx3, d[j]);
      }
    }
    if (mx1 != -inf && mx2 != -inf) {
      mx[2] = mx1 + mx2;
      b[2] = mx1;
      dp();
    }
    if (mx1 != -inf && mx3 != -inf) {
      mx[2] = mx1 + mx3;
      b[2] = max(mx1, mx3);
      dp();
    }
    mx1 = mx2 = mx3 = -inf;
    for (int j = 1; j <= m; j++) {
      if (c[j] == 1) {
        if (d[j] > mx1) {
          mx3 = mx2;
          mx2 = mx1;
          mx1 = d[j];
        } else if (d[j] > mx2) {
          mx3 = mx2;
          mx2 = d[j];
        } else if (d[j] > mx3) {
          mx3 = d[j];
        }
      }
    }
    if (mx1 != -inf && mx2 != -inf && mx3 != -inf) {
      mx[3] = mx1 + mx2 + mx3;
      b[3] = mx1;
      dp();
    }
  }
  for (int i = 0; i <= 9; i++) {
    ans = max(ans, f[i]);
  }
  cout << ans << endl;
  return 0;
}
