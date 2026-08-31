#include <bits/stdc++.h>
using namespace std;
int m[5250][5250];
bool search(int u, int n) {
  bool ret = true;
  for (int i = 0; i < n / u; i++) {
    for (int j = 0; j < n / u; j++) {
      for (int x = 0; x < u; x++) {
        for (int y = 0; y < u; y++) {
          if (m[i * u][j * u] != m[i * u + x][j * u + y]) {
            return false;
          }
        }
      }
    }
  }
  return ret;
}
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string s;
    cin >> s;
    for (int j = 0; j < n / 4; j++) {
      int t;
      if (s[j] >= 'A') {
        t = s[j] - 'A' + 10;
      } else
        t = s[j] - '0';
      for (int k = 0; k < 4; k++) {
        m[i][j * 4 + 3 - k] = t % 2;
        t /= 2;
      }
    }
  }
  map<int, int> c;
  int d = n;
  for (int i = 2; i * i <= d; i++) {
    while (d % i == 0) {
      c[i]++;
      d /= i;
    }
  }
  if (d != 1) c[d]++;
  int ans = 1;
  for (auto it = c.begin(); it != c.end(); it++) {
    int p = it->first;
    int q = it->second;
    for (int i = 1; i <= q; i++) {
      if (!search(pow(p, i), n)) {
        ans *= pow(p, i - 1);
        break;
      }
      if (i == q) {
        ans *= pow(p, i);
      }
    }
  }
  cout << ans << endl;
  return 0;
}
