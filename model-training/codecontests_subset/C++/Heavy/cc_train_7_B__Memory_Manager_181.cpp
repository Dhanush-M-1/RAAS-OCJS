#include <bits/stdc++.h>
using namespace std;
long long t, n, i, j, k, x, y, z, l, r, mid, ans, mod = 1e9 + 7, g, m;
long long a[400005], b[400005], c[400005], d[400005];
char ch;
string s, st;
vector<long long> v[300005], u;
int main() {
  ios::sync_with_stdio(NULL);
  cin.tie(0);
  cout.tie(0);
  memset(b, -1, sizeof b);
  cin >> m >> n;
  while (m--) {
    cin >> s;
    if (s[0] == 'a') {
      cin >> x;
      for (i = 0; i < n; i++) {
        for (j = 0; j < x; j++)
          if (i + j == n || a[i + j]) break;
        if (j == x) {
          for (j = 0; j < x; j++) a[i + j] = 1;
          y++;
          b[y] = i;
          c[y] = i + x;
          d[i] = y;
          break;
        }
      }
      if (i == n)
        cout << "NULL\n";
      else
        cout << y << "\n";
    }
    if (s[0] == 'e') {
      cin >> x;
      if (x > 0 && x < 1000 && b[x] + 1) {
        d[b[x]] = -1;
        for (i = b[x]; i < c[x]; i++) a[i] = 0;
        b[x] = c[x] = -1;
      } else
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
    }
    if (s[0] == 'd') {
      j = 0;
      for (i = 0; i < n; i++)
        if (a[i]) {
          z = x = c[d[i]] - b[d[i]];
          for (k = i; x--; k++) a[k] = 0;
          x = z;
          d[j] = d[i];
          b[d[j]] = j;
          c[d[j]] = j + x;
          for (j; x--; j++) a[j] = 1;
          i += z - 1;
        }
    }
  }
}
