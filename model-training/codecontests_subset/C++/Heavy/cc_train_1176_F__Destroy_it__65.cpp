#include <bits/stdc++.h>
using namespace std;
double const EPS = 1e-12, PI = acos(-1);
const int N = 2e5 + 9, M = 1e7 + 9, OO = 1e9 + 7, MOD = 1e9 + 7,
          MOD2 = 998244353;
const long long inf = 1e18;
vector<long long> v[N][4];
long long mem[N][11];
int n;
long long solve(int idx, int cards) {
  if (idx > n) return 0ll;
  long long& ret = mem[idx][cards];
  if (~ret) return ret;
  ret = 0;
  ret = solve(idx + 1, cards);
  long long c1 = 0, c2 = 0, c3 = 0, c4 = 0;
  if (!v[idx][3].empty()) {
    c1 += v[idx][3][0];
    if (cards + 1 >= 10) c1 += v[idx][3][0];
    c1 += solve(idx + 1, (cards + 1) % 10);
  }
  if (!v[idx][2].empty()) {
    c2 += v[idx][2][0];
    if (cards + 1 >= 10) c2 += v[idx][2][0];
    c2 += solve(idx + 1, (cards + 1) % 10);
  }
  if (!v[idx][2].empty() && !v[idx][1].empty()) {
    c3 += v[idx][2][0] + v[idx][1][0];
    if (cards + 2 >= 10) c3 += max(v[idx][2][0], v[idx][1][0]);
    c3 += solve(idx + 1, (cards + 2) % 10);
  }
  long long total = 0;
  for (int i = 0, done = 0; i < (int)v[idx][1].size(); ++i) {
    if (cards + i + 1 >= 10 && !done) {
      total += v[idx][1][0];
      done = 1;
    }
    total += v[idx][1][i];
    c4 = max(c4, total + solve(idx + 1, (cards + i + 1) % 10));
  }
  ret = max({ret, c1, c2, c3, c4});
  return ret;
}
int main() {
  cout << fixed << setprecision(12), ios::sync_with_stdio(false),
      cin.tie(nullptr), cout.tie(nullptr);
  int c, d;
  cin >> n;
  for (int i = 1, k; i <= n; ++i) {
    vector<long long> vv[4];
    cin >> k;
    for (int j = 0; j < k; ++j) {
      cin >> c >> d;
      vv[c].push_back(d);
    }
    for (int j = 0; j < 4; ++j)
      sort(((vv[j]).begin()), ((vv[j]).end()), greater<long long>());
    for (int j = 0; j < (int)vv[1].size() && j < 3; ++j)
      v[i][1].push_back(vv[1][j]);
    for (int j = 0; j < (int)vv[2].size() && j < 1; ++j)
      v[i][2].push_back(vv[2][j]);
    for (int j = 0; j < (int)vv[3].size() && j < 1; ++j)
      v[i][3].push_back(vv[3][j]);
  }
  memset(mem, -1, sizeof mem);
  cout << solve(1, 0);
  return 0;
}
