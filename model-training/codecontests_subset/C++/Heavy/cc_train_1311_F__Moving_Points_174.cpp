#include <bits/stdc++.h>
using namespace std;
using ll = long long;
ll ftget(vector<ll> &ft, ll idx) {
  ll ans = 0;
  while (idx > 0) {
    ans += ft[idx];
    idx -= (idx & (-idx));
  }
  return ans;
}
void ftput(vector<ll> &ft, ll idx, ll value) {
  while (idx < ft.size()) {
    ft[idx] += value;
    idx += (idx & (-idx));
  }
}
void run() {
  ll n;
  cin >> n;
  vector<pair<ll, ll>> data;
  vector<ll> vx, vv;
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    vx.push_back(x);
  }
  for (int i = 0; i < n; ++i) {
    int x;
    cin >> x;
    vv.push_back(x);
    data.emplace_back(vx[i], x);
  }
  vx.clear();
  vx.shrink_to_fit();
  sort(vv.begin(), vv.end());
  map<ll, ll> comp;
  for (int i = 0; i < n; ++i) {
    comp[vv[i]] = i + 1;
  }
  vv.clear();
  vv.shrink_to_fit();
  for (auto &x : data) {
    x.second = comp[x.second];
  }
  comp.clear();
  vector<ll> ftdist(n + 10, 0);
  vector<ll> ftcnt(n + 10, 0);
  ll ans = 0;
  sort(data.begin(), data.end());
  for (auto pt : data) {
    ll prevno = ftget(ftcnt, pt.second);
    ll prevdst = ftget(ftdist, pt.second);
    ans += prevno * pt.first - prevdst;
    ftput(ftcnt, pt.second, 1);
    ftput(ftdist, pt.second, pt.first);
  }
  cout << ans << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  run();
  return 0;
}
