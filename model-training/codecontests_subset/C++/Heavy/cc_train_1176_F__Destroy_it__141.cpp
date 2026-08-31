#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f, mod = 1000000007;
const long long INF = 0x3f3f3f3f3f3f3f3fLL;
const double pi = acosl(-1.), eps = 1e-9;
inline int power(int a, int b, int m = mod, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % m)
    if (b & 1) ans = 1LL * ans * a % m;
  return ans;
}
const int NN = 202020;
long long dp[NN][12];
template <typename U, typename V>
inline void smax(U& a, V b) {
  if (a < b) a = b;
}
void update(vector<long long>& a, int i) {
  for (int j = 0; j < 10; j++)
    if (~dp[i - 1][j]) {
      long long mx = 0, sum = 0;
      for (auto r : a) mx = max(mx, r), sum += r;
      for (int r = a.size(); r; r--) {
        if ((j + r) % 10 == 0) {
          sum += mx;
          break;
        }
      }
      smax(dp[i][(j + a.size()) % 10], dp[i - 1][j] + sum);
    }
}
int main() {
  memset(dp, -1, sizeof dp);
  int n;
  scanf("%d", &n);
  dp[0][0] = 0;
  vector<vector<long long> > tmp;
  vector<long long> v[10];
  for (int i = 1, j, k, m; i <= n; i++) {
    scanf("%d", &m);
    for (j = 1; j <= 3; j++) v[j].clear();
    tmp.clear();
    while (m--) {
      scanf("%d%d", &j, &k);
      v[j].push_back(k);
    }
    for (int j = 1; j <= 3; j++) {
      sort(v[j].begin(), v[j].end(),
           [](long long a, long long b) { return a > b; });
    }
    if (v[1].size() >= 3) {
      v[1].resize(3);
      tmp.push_back(v[1]);
    }
    if (v[2].size() >= 1 && v[1].size() >= 1) {
      tmp.push_back(vector<long long>{v[1][0], v[2][0]});
    }
    if (v[3].size() >= 1) {
      v[3].resize(1);
      tmp.push_back(v[3]);
    }
    if (v[2].size() >= 1) {
      v[2].resize(1);
      tmp.push_back(v[2]);
    }
    if (v[1].size() >= 2) {
      v[1].resize(2);
      tmp.push_back(v[1]);
    }
    if (v[1].size() >= 1) {
      v[1].resize(1);
      tmp.push_back(v[1]);
    }
    for (auto r : tmp) update(r, i);
    for (int j = 0; j < 10; j++) {
      smax(dp[i][j], dp[i - 1][j]);
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i++) {
    ans = max(dp[n][i], ans);
  }
  printf("%I64d\n", ans);
  return 0;
}
