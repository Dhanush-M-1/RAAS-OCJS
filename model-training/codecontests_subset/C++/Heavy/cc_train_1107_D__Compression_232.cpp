#include <bits/stdc++.h>
int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
using namespace ::std;
const int maxn = 5300;
const int inf = 1e9 + 800;
const int mod = 1e9 + 7;
bool ro[maxn][maxn];
bool cu[maxn][maxn];
bool mosro[maxn];
bool moscu[maxn];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < n; j += 4) {
      char c = s[j / 4];
      if ('A' <= c && c <= 'Z') {
        c -= 'A';
        c += 10;
      } else {
        c -= '0';
      }
      ro[i][j] = ((c >> 3) & 1);
      ro[i][j + 1] = ((c >> 2) & 1);
      ro[i][j + 2] = ((c >> 1) & 1);
      ro[i][j + 3] = ((c >> 0) & 1);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = n - 1; j >= 0; j--) {
      cu[i][j] = ro[j][i];
    }
  }
  for (int i = 0; i + 1 < n; i++) {
    mosro[i] = 1;
    moscu[i] = 1;
    for (int j = 0; j < n; j++) {
      if (ro[i][j] != ro[i + 1][j]) {
        mosro[i] = 0;
      }
      if (cu[i][j] != cu[i + 1][j]) {
        moscu[i] = 0;
      }
    }
  }
  for (int x = n; x >= 1; x--) {
    if (n % x == 0) {
      bool good = 1;
      for (int j = 0; j + 1 < n; j++) {
        if (j % x != x - 1 && (mosro[j] == 0 || moscu[j] == 0)) {
          good = 0;
          break;
        }
      }
      if (good) {
        cout << x;
        return 0;
      }
    }
  }
}
