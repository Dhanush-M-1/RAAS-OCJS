#include <bits/stdc++.h>
using namespace std;
inline void fastio() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n);
  for (int i = 0; i < n; ++i) cin >> a[i];
  map<int, vector<int> > mp;
  for (int i = 0; i < n; ++i) {
    mp[a[i]].push_back(i);
  }
  vector<int> szs(0);
  vector<int> ind(0);
  for (auto i : mp) {
    szs.push_back((int)i.second.size());
    ind.push_back((int)i.first);
  }
  reverse(szs.begin(), szs.end());
  reverse(ind.begin(), ind.end());
  vector<int> ps = {szs[0]};
  for (int i = 1; i < szs.size(); ++i) {
    ps.push_back(ps.back() + szs[i]);
  }
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    pos--;
    set<int> psps;
    int nowind = 0;
    int nowel = 0;
    for (int i = 0; i < k; ++i) {
      psps.insert(mp[ind[nowind]][nowel]);
      nowel++;
      if (nowel == mp[ind[nowind]].size()) {
        nowel = 0;
        nowind++;
      }
    }
    vector<int> v;
    for (auto i : psps) {
      v.push_back(i);
    }
    cout << a[v[pos]] << "\n";
  }
}
signed main() {
  fastio();
  solve();
}
