#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void ckmx(T &a, T b) {
  if (b > a) a = b;
}
const int N = 200010;
const int Mod = 998244353;
int n, a[N];
long long b[N];
long long A[N][4][4];
long long g[N][4][4][2];
long long MX[N][4][4];
long long f[N][10];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long ans = 0;
  int T;
  cin >> T;
  for (int ti = (1); ti <= (T); ++ti) {
    cin >> n;
    for (int i = (1); i <= (n); ++i) cin >> a[i] >> b[i];
    auto cal = [&](long long A[4][4]) {
      for (int i = (0); i <= (3); ++i)
        for (int j = (0); j <= (3); ++j) A[i][j] = -1;
      A[0][0] = 0;
      for (int i = (1); i <= (n); ++i)
        for (int j = (3); j >= (1); --j)
          for (int k = (3); k >= (a[i]); --k)
            if (A[j - 1][k - a[i]] != -1) {
              ckmx(A[j][k], A[j - 1][k - a[i]] + b[i]);
            }
    };
    cal(A[ti]);
    auto cal2 = [&](long long A[4][4]) {
      for (int i = (0); i <= (3); ++i)
        for (int j = (0); j <= (3); ++j) A[i][j] = -1;
      for (int i = (0); i <= (n); ++i)
        for (int j = (0); j <= (3); ++j)
          for (int k = (0); k <= (3); ++k) g[i][j][k][0] = g[i][j][k][1] = -1;
      g[0][0][0][1] = 0;
      g[0][0][0][0] = 0;
      for (int i = (1); i <= (n); ++i) {
        for (int j = (0); j <= (3); ++j)
          for (int k = (0); k <= (3); ++k) {
            g[i][j][k][0] = g[i - 1][j][k][0];
            g[i][j][k][1] = g[i - 1][j][k][1];
            if (j >= 1 && k >= a[i]) {
              if (g[i - 1][j - 1][k - a[i]][0] != -1)
                ckmx(g[i][j][k][0], g[i - 1][j - 1][k - a[i]][0] + b[i]);
              if (g[i - 1][j - 1][k - a[i]][1] != -1)
                ckmx(g[i][j][k][1], g[i - 1][j - 1][k - a[i]][1] + b[i]);
              if (g[i - 1][j - 1][k - a[i]][0] != -1)
                ckmx(g[i][j][k][1], g[i - 1][j - 1][k - a[i]][0] + b[i] + b[i]);
            }
          }
      }
      for (int i = (0); i <= (3); ++i)
        for (int j = (0); j <= (3); ++j) A[i][j] = g[n][i][j][1];
    };
    cal2(MX[ti]);
  }
  function<int(int, int)> thz = [&](int st, int ed) -> int {
    int f = 0;
    for (int i = (1); i <= (10); ++i) {
      if ((st + i) % 10 == 0) f = 1;
      if ((st + i) % 10 == ed) {
        if (f) return 1;
      }
    }
    return 0;
  };
  for (int i = (0); i <= (n); ++i)
    for (int j = (0); j <= (9); ++j) f[i][j] = -1;
  f[0][0] = 0;
  for (int i = (1); i <= (T); ++i)
    for (int z = (0); z <= (9); ++z) {
      f[i][z] = f[i - 1][z];
      for (int j = (1); j <= (3); ++j)
        for (int k = (1); k <= (3); ++k) {
          if (f[i - 1][(z - j + 10) % 10] == -1) continue;
          if (A[i][j][k] != -1 && !thz((z - j + 10) % 10, z))
            ckmx(f[i][z], f[i - 1][(z - j + 10) % 10] + A[i][j][k]);
          else if (MX[i][j][k] != -1 && thz((z - j + 10) % 10, z))
            ckmx(f[i][z], f[i - 1][(z - j + 10) % 10] + MX[i][j][k]);
        }
      ans = max(ans, f[i][z]);
    }
  cout << ans << endl;
}
