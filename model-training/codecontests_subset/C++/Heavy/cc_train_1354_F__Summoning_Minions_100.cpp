#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool cmax(T &x, T y) {
  return x < y ? x = y, 1 : 0;
}
template <typename T>
inline bool cmin(T &x, T y) {
  return y < x ? x = y, 1 : 0;
}
const int _ = 105;
struct node {
  int a, b, i;
  bool operator<(const node &t) const { return b < t.b; }
} w[_];
int T, N, K;
int f[_][_], s1[_], s2[_], n, m;
void work(int i, int j) {
  if (i == 0) return;
  if (f[i][j] == f[i - 1][j] + (K - 1) * w[i].b)
    s2[++m] = w[i].i, work(i - 1, j);
  else
    s1[++n] = w[i].i, work(i - 1, j - 1);
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> T;
  while (T--) {
    cin >> N >> K;
    for (int i(1), I(N); i <= I; ++i) cin >> w[i].a >> w[i].b, w[i].i = i;
    sort(w + 1, w + N + 1);
    memset(f, 0xf7, sizeof f), f[0][0] = 0;
    for (int i(1), I(N); i <= I; ++i)
      for (int j(0), I(min(i, K)); j <= I; ++j)
        f[i][j] = max(j ? f[i - 1][j - 1] + w[i].a + (j - 1) * w[i].b : -1,
                      f[i - 1][j] + (K - 1) * w[i].b);
    n = m = 0, work(N, K), reverse(s1 + 1, s1 + n + 1);
    cout << (n + (m << 1)) << endl;
    for (int i(1), I(n - 1); i <= I; ++i) cout << s1[i] << " ";
    for (int i(1), I(m); i <= I; ++i) cout << s2[i] << " " << -s2[i] << " ";
    cout << s1[n] << endl;
  }
  return 0;
}
