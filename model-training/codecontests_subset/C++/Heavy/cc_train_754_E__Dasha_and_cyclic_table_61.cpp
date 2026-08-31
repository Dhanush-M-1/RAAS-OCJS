#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9 + 10;
const int mod = (int)1e9 + 7;
const int N = (int)1e6 + 10;
const long long LLINF = (long long)1e18 + 10;
const long double pi = acos(-1.0);
const long double eps = (long double)1e-5;
template <typename T1, typename T2>
bool umin(T1 &x, const T2 &y) {
  if (x > y) return x = y, true;
  return false;
}
template <typename T1, typename T2>
bool umax(T1 &x, const T2 &y) {
  if (x < y) return x = y, true;
  return false;
}
template <typename T>
T getint() {
  char c = getchar();
  T p = 1, x = 0;
  while (c == ' ' || c == '\n') c = getchar();
  if (c == '-') p = -1, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * p;
}
int z[1500];
char a[410][410], b[410][410];
int n, m, r, c;
bitset<410> can[410][410];
bitset<410> ans[410][410];
char str[1500];
int eq(char a, char b) { return b == '?' || a == b; }
void zed(bitset<410> &res) {
  char *s = str;
  for (int i = 0; i < c + c + m; ++i) z[i] = 0;
  int l = 0, r = -1;
  for (int i = 1; i < c + c + m; ++i) {
    if (i <= r) z[i] = min(r - i + 1, z[i - l]);
    while (i + z[i] < c + c + m && eq(s[i + z[i]], s[z[i]])) ++z[i];
    if (i + z[i] - 1 > r) {
      l = i;
      r = i + z[i] - 1;
    }
  }
  for (int i = 0; i < m; ++i) {
    res[i] = (z[c + i] >= c);
  }
}
void make_str(int x, int y) {
  int j = 1;
  for (int i = 1; i <= c; ++i) {
    str[i - 1] = b[y][i];
  }
  for (int i = 1; i <= c + m; ++i) {
    str[c + i - 1] = a[x][j++];
    if (j == m + 1) j = 1;
  }
}
int main() {
  srand(time(NULL));
  ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      cin >> a[i][j];
    }
  }
  cin >> r >> c;
  for (int i = 1; i <= r; ++i) {
    for (int j = 1; j <= c; ++j) {
      cin >> b[i][j];
    }
  }
  for (int k = 1; k <= r; ++k) {
    for (int i = 1; i <= n; ++i) {
      make_str(i, k);
      zed(can[k][i]);
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j <= m; ++j) {
      ans[r + 1][i][j] = true;
    }
  }
  for (int k = r; k >= 1; --k) {
    for (int i = 1; i <= n; ++i) {
      ans[k][i] = ans[k + 1][(i == n ? 1 : i + 1)] & can[k][i];
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= m; ++j) {
      cout << ans[1][i][j - 1];
    }
    cout << '\n';
  }
  return 0;
}
