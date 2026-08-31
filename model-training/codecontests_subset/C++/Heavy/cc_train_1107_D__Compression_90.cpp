#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long double eps = 1e-7;
const int inf = 1000000010;
const long long INF = 10000000000000010LL;
const int mod = 1000000007;
const int MAXN = 5300;
int n, m, k, u, v, x, y, t, a, b, ans, cnt;
bool A[MAXN][MAXN];
vector<int> D;
char ch;
bool check(int x) {
  for (int i = 0; i < n; i += x)
    for (int j = 0; j < n; j += x) {
      bool f = A[i][j];
      for (int ii = i; ii < i + x; ii++)
        for (int jj = j; jj < j + x; jj++)
          if (A[ii][jj] != f) return 0;
    }
  return 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j += 4) {
      cin >> ch;
      if ('0' <= ch && ch <= '9')
        x = ch - '0';
      else
        x = ch - 'A' + 10;
      if (x & 8) A[i][j] = 1;
      if (x & 4) A[i][j + 1] = 1;
      if (x & 2) A[i][j + 2] = 1;
      if (x & 1) A[i][j + 3] = 1;
    }
  }
  for (int i = 1; i <= n; i++)
    if (n % i == 0) D.push_back(i), cnt++;
  for (int x : D) {
    if (check(x)) ans = x;
  }
  cout << ans << '\n';
  return 0;
}
