#include <bits/stdc++.h>
using namespace std;
const int maxn = 100001;
const int inf = 0x7f7f7f7f;
const int mod = (int)(1e9 + 7);
const long long INF = 1LL << 50;
const double eps = 1e-8;
const double pi = acos(-1.0);
const int mask = 65535;
vector<int> W[maxn];
bool ok(int x, int y) {
  if (x >= maxn || y >= maxn) return 0;
  return binary_search(W[x].begin(), W[x].end(), y);
}
int main() {
  ios::sync_with_stdio(false);
  int n, i, j, k, u, x, y;
  cin >> n;
  for (i = 0; i < n; ++i) {
    cin >> x >> y;
    W[x].push_back(y);
  }
  for (i = 0; i < maxn; ++i) {
    sort(W[i].begin(), W[i].end());
  }
  int block = (int)sqrt(n + 0.0);
  vector<int>::iterator it, jt;
  int ans = 0, d;
  for (i = 0; i < maxn; ++i) {
    int sz = W[i].size();
    if (sz <= block) {
      for (j = 0; j < sz; ++j) {
        for (k = j + 1; k < sz; ++k) {
          d = W[i][k] - W[i][j];
          y = W[i][j];
          x = i;
          ans += ok(x + d, y) && ok(x + d, y + d);
        }
      }
    } else {
      for (j = i + 1; j < maxn; ++j) {
        int sz = W[j].size();
        d = j - i;
        for (k = 0; k < sz; ++k) {
          x = j;
          y = W[j][k];
          ans += ok(j, y + d) && ok(i, y) && ok(i, y + d);
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
