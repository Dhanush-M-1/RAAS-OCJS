#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:64000000")
const int infi = 1e9 + 7;
const long long infl = 1e18 + 7;
int z[2010];
int eq(char a, char b) { return b == '?' || a == b; }
void calc_z(char *s, int len) {
  int l = 0, r = -1;
  memset(z, 0, sizeof(z));
  for (int i = 1; i < len; ++i) {
    if (i <= r) {
      z[i] = min(z[i - l], r - i + 1);
    }
    for (; i + z[i] < len && eq(s[i + z[i]], s[z[i]]); ++z[i])
      ;
    if (i + z[i] - 1 > r) {
      l = i;
      r = i + z[i] - 1;
    }
  }
}
char ar[401][401];
char shab[401][401];
bitset<401> can[401][401];
char tmp[2010];
int main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < (n); ++i)
    for (int j = 0; j < (m); ++j) cin >> ar[i][j];
  int q, w;
  cin >> q >> w;
  for (int i = 0; i < (q); ++i)
    for (int j = 0; j < (w); ++j) cin >> shab[i][j];
  for (int k = 0; k < (q); ++k) {
    for (int i = 0; i < (w); ++i) tmp[i] = shab[k][i];
    for (int i = 0; i < (n); ++i) {
      for (int j = 0; j < (m); ++j) tmp[w + j] = ar[i][j];
      int sum = 1;
      int cnt = 1;
      while (sum < w) {
        for (int j = 0; j < (m); ++j) tmp[w + m * cnt + j] = ar[i][j];
        ++cnt;
        sum += m;
      }
      calc_z(tmp, w + m * cnt);
      for (int j = 0; j < (m); ++j) {
        if (z[j + w] >= w) {
          can[i][j][k] = 1;
        }
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      int cur = i;
      int flag = 1;
      for (int k = 0; k < q && flag; ++k) {
        if (!can[cur][j][k]) {
          flag = 0;
        } else {
          ++cur;
          if (cur == n) cur = 0;
        }
      }
      cout << flag;
    }
    cout << '\n';
  }
  return 0;
}
