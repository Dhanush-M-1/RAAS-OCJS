#include <bits/stdc++.h>
using namespace std;
long long mod = 1000000007;
long long power(long long a, long long b, long long modi) {
  long long res = 1;
  while (b) {
    if (b % 2) {
      res = (res * a) % modi;
    }
    b /= 2;
    a = (a * a) % modi;
  }
  return res;
}
int dirx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int diry[] = {-1, 0, 1, -1, 1, -1, 0, 1};
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
long long n, m;
long long curres, ans = 0;
long long a[5500], b[5500], c[5500];
vector<long long> vt;
int mat[5500][5500], sum[5500][5500];
string fun(int num) {
  string ans;
  while (num > 0) {
    ans += '0' + (num % 2);
    num /= 2;
  }
  while (ans.length() < 4) ans += "0";
  reverse(ans.begin(), ans.end());
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  int flag = 0;
  char ch;
  string s;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n / 4; j++) {
      cin >> ch;
      int num;
      if (isalpha(ch))
        num = 10 + (ch - 'A');
      else
        num = ch - '0';
      s = fun(num);
      for (int k = 0; k < 4; k++) mat[i][(j - 1) * 4 + k + 1] = (s[k] - '0');
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      sum[i][j] =
          sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (mat[i][j]);
  long long ans = 1;
  vt.push_back(n);
  for (int i = 2; i * i <= n; i++) {
    if (n % i == 0) {
      vt.push_back(i);
      if (i == n / i) continue;
      vt.push_back(n / i);
    }
  }
  for (auto x : vt) {
    bool flag = true;
    int i = x;
    while (i <= n) {
      int j = x;
      while (j <= n) {
        long long cur =
            sum[i][j] - sum[i - x][j] - sum[i][j - x] + sum[i - x][j - x];
        if (cur == 0 || cur == x * x) {
        } else
          flag = false;
        j += x;
      }
      i += x;
    }
    if (flag) ans = max(ans, x);
  }
  cout << ans;
  return 0;
}
