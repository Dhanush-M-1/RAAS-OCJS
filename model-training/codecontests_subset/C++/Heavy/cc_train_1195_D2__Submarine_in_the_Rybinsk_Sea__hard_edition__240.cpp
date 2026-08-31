#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int N = 15000;
const int M = 200050;
long long n, a[2][50][M], ans = 0, k[M], mp[50];
int s[M][100];
char ss[M][100];
const long long mod = 998244353;
const long long mm = 1000000000;
int main() {
  memset(a, 0, sizeof(a));
  scanf("%lld", &n);
  for (int i = 1; i <= n; i++) {
    getchar();
    scanf("%s", ss[i]);
    k[i] = strlen(ss[i]);
    for (int j = 0; j <= k[i] - 1; j++) s[i][j] = ss[i][j] - '0';
    mp[k[i]]++;
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= k[i] - 1; j++) {
      for (int b = 0; b <= k[i] - 1; b++) {
        if (b < j)
          a[0][b][i] = a[1][b][i] = (a[0][b][i] * 100 + s[i][j]) % mod;
        else
          a[0][b][i] = a[1][b][i] = (a[0][b][i] * 10 + s[i][j]) % mod;
      }
    }
    for (int b = 0; b <= k[i] - 1; b++) {
      a[0][b][i] = (a[0][b][i] * 10);
    }
    int res = n;
    for (int b = 0; b <= k[i] - 1; b++) {
      ans = (ans + a[0][b][i] * mp[k[i] - b]) % mod;
      res -= mp[k[i] - b];
    }
    ans = (ans + a[0][0][i] * res) % mod;
    res = n;
    for (int b = 0; b <= k[i] - 1; b++) {
      ans = (ans + a[1][b][i] * mp[k[i] - b - 1]) % mod;
      res -= mp[k[i] - b - 1];
    }
    ans = (ans + a[1][0][i] * res) % mod;
  }
  cout << ans;
  return 0;
}
