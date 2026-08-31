#include <bits/stdc++.h>
using namespace std;
long long n, a[300005], b1[500005], b2[500005],
    cnt = 0, pl[300005], c[300005], ans = 0, plc[300005], m, d, can[300005], r,
    ne[300005];
pair<int, int> p;
pair<int, int> p1;
pair<int, int> p2;
map<pair<int, int>, int> m1;
string s;
int main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pl[a[i]] = i;
    can[i] = 0;
    ne[i] = i + 1;
  }
  for (int i = 0; i < m; i++) {
    cin >> b1[i] >> b2[i];
    p.first = b1[i];
    p.second = b2[i];
    m1[p] = 1;
    if (b2[i] == a[n]) {
      c[cnt] = b1[i];
      plc[cnt] = pl[b1[i]];
      cnt++;
    }
  }
  sort(plc, plc + cnt);
  for (int i = 0; i < cnt; i++) {
    c[i] = a[plc[i]];
  }
  for (int i = cnt - 1; i >= 0; i--) {
    d = 1;
    r = ne[pl[c[i]]];
    while (r < n) {
      p1.first = c[i];
      p1.second = a[r];
      if (m1[p1] == 0) {
        d = 0;
        break;
      }
      r = ne[r];
    }
    if (d) {
      ans++;
      if (c[i] > 0) {
        ne[pl[c[i]] - 1] = ne[pl[c[i]]];
      }
    }
  }
  cout << ans;
}
