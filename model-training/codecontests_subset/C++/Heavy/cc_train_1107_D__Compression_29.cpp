#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)5202;
const int mod = (int)1e9 + 7;
int n, m, k, l, s, t, r, ans, T;
bool a[maxn][maxn], now;
int b[maxn][maxn];
vector<int> ppp;
string p;
inline int cal(int x) {
  if (x >= '0' && x <= '9')
    return x - '0';
  else
    return x - 'A' + 10;
}
inline int query(int l1, int r1, int l2, int r2) {
  return b[l2][r2] - b[l2][r1 - 1] - b[l1 - 1][r2] + b[l1 - 1][r1 - 1];
}
int ttt(int k) {
  for (int i = k; i <= n; i += k)
    for (int j = k; j <= n; j += k) {
      int nowi = i - k + 1;
      int nowj = j - k + 1;
      int tmp = query(nowi, nowj, i, j);
      if (tmp != 0 && tmp != k * k) return 0;
    }
  return 1;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p;
    for (int j = 0; j < n / 4; j++) {
      int tmp = cal(p[j]);
      a[i][(j)*4 + 4] = tmp % 2;
      tmp /= 2;
      a[i][(j)*4 + 3] = tmp % 2;
      tmp /= 2;
      a[i][(j)*4 + 2] = tmp % 2;
      tmp /= 2;
      a[i][(j)*4 + 1] = tmp % 2;
      tmp /= 2;
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      b[i][j] = b[i - 1][j] + b[i][j - 1] + a[i][j] - b[i - 1][j - 1];
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) {
      ppp.push_back(i);
    }
  }
  int L = 1, R = ppp.size();
  for (int i = R - 1; i >= 0; i--) {
    if (ttt(ppp[i])) {
      ans = ppp[i];
      break;
    }
    if ((double)clock() / (double)CLOCKS_PER_SEC >= 2.4) break;
  }
  cout << ans << endl;
  return 0;
}
