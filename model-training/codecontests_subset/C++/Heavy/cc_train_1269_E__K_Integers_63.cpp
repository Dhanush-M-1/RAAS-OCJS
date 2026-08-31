#include <bits/stdc++.h>
using namespace std;
const int MX = 2e5 + 5, MXX = 23;
const long long mod = 1e9 + 7, inf = 1e18 + 6;
int n, a[MX], ind[MX], ver[MX];
void add(int l) {
  for (int i = l + 1; i < MX; i += i & -i) ver[i]++;
}
int ask(int pn) {
  int ans = 0;
  for (pn++; pn; pn -= pn & -pn) ans += ver[pn];
  return ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << fixed << setprecision(9);
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n; ++i) ind[a[i]] = i;
  set<int> nw;
  long long ans = 0;
  int md = ind[1];
  for (int i = 1; i < n + 1; ++i) {
    nw.insert(ind[i]);
    auto v = nw.find(ind[i]);
    add(ind[i]);
    int ver = ask(ind[i]);
    if (i & 1) {
      if (ind[i] > md) md = *next(nw.find(md), 1);
    } else {
      if (ind[i] < md) md = *prev(nw.find(md), 1);
    }
    if (md != ind[i]) {
      int ls = ((i % 2 == 0) && md > ind[i] ? *next(nw.find(md), 1) : md);
      int dis = ls - ind[i];
      dis = max(dis, -dis);
      dis--;
      int fr = ((i % 2 == 0) && md > ind[i] ? (i / 2) : ((i - 1) / 2));
      fr++;
      int bs = ver - fr;
      bs = max(bs, -bs);
      bs--;
      ans += (long long)(dis - bs);
    }
    if (md == ind[i] && (i % 2 == 0)) {
      ans += *next(nw.find(md), 1) - md - 1;
    }
    ans -= (min(i - ver, ver - 1));
    ans += i - ver;
    cout << ans << ' ';
  }
  cout << "\n";
  return 0;
}
