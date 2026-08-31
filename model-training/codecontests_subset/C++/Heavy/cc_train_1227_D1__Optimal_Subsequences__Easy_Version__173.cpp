#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return rge<c>{i, j};
}
template <class c>
auto dud(c* x) -> decltype(cerr << *x, 0);
template <class c>
char dud(...);
struct debug {
  template <class c>
  debug& operator<<(const c&) {
    return *this;
  }
};
const long long MOD = 1e9 + 7;
const long long N = 1e7 + 10;
const long long INF = 1e18 + 10;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  vector<long long> v(n);
  map<long long, vector<long long> > mp;
  for (long long i = 0; i < n; i++) {
    cin >> v[i];
    mp[v[i]].push_back(i);
  }
  vector<long long> t = v;
  sort(t.begin(), t.end());
  long long q;
  cin >> q;
  while (q--) {
    long long k, pos;
    cin >> k >> pos;
    pos--;
    vector<pair<long long, long long> > ans;
    map<long long, long long> cnt;
    for (long long i = n - k; i < n; i++) {
      ans.push_back(make_pair(mp[t[i]][cnt[t[i]]], t[i]));
      cnt[t[i]]++;
    }
    sort(ans.begin(), ans.end());
    cout << ans[pos].second << endl;
  }
  return 0;
}
