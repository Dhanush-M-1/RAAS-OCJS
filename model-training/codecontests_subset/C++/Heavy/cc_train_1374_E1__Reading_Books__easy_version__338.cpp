#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
const int mod = 1e9 + 7;
long long a[N], a1 = 0, b[N], b1 = 0, c[N], c1 = 0, d, dis;
char o;
pair<int, int> p;
bool mark = true;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long t, n, m, mx, k, ans = 0, sum = 0, x, y, l, r;
  string s;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> l >> m >> t;
    if (m == 1 && t == 1) {
      c[c1++] = l;
    }
    if (m == 1 && t == 0) {
      a[a1++] = l;
    }
    if (m == 0 && t == 1) {
      b[b1++] = l;
    }
  }
  sort(a, a + a1);
  sort(b, b + b1);
  sort(c, c + c1);
  long long a2 = 0, b2 = 0, c2 = 0;
  m = min(a1, b1);
  m = k - m;
  if (c1 < m)
    cout << -1 << endl;
  else {
    c2 = max(c2, m);
    for (int i = 0; i < m; i++) {
      ans += c[i];
    }
    m = min(a1, b1);
    if (m > k) m = k;
    for (int i = 0; i < m; i++) {
      if (c2 < c1 && a[a2] + b[b2] >= c[c2])
        ans += c[c2++];
      else {
        ans += a[a2++];
        ans += b[b2++];
      }
    }
    cout << ans;
  }
}
