#include <bits/stdc++.h>
using namespace std;
void faster() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
const int maxn = 5e3 + 2e2 + 1;
const long long inf = 1e18;
const long long mod = 1e9 + 7;
const long double pi = acos(-1);
long long n, a[maxn][maxn];
string s;
int main() {
  faster();
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> s;
    int x;
    for (int j = 0; j < n / 4; ++j) {
      if ('A' <= s[j] && s[j] <= 'F')
        x = 10 + (s[j] - 'A');
      else
        x = s[j] - '0';
      for (int k = 0; k < 4; ++k) a[i][j * 4 + (3 - k) + 1] = (x >> k) & 1;
    }
  }
  for (int i = 1; i <= n; ++i) {
    for (int j = 1; j <= n; ++j) {
      a[i][j] += a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1];
    }
  }
  for (int k = n; k >= 1; --k) {
    if ((n % k) != 0) continue;
    bool u = 0;
    for (int i = 1; i <= n; i += k) {
      for (int j = 1; j <= n; j += k) {
        int res = (a[i + k - 1][j + k - 1] + a[i - 1][j - 1] -
                   a[i + k - 1][j - 1] - a[i - 1][j + k - 1]);
        if (res != 0 && res != k * k) {
          u = 1;
          break;
        }
      }
      if (u) break;
    }
    if (!u) {
      cout << k;
      return 0;
    }
  }
  return 0;
}
