#include <bits/stdc++.h>
using namespace std;
const long double pi = acos(-1);
const long long md = 1e9 + 7;
long long n, q, a, i, k, pos;
vector<pair<long long, long long> > v, ans;
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first)
    return a.second < b.second;
  else
    return a > b;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> a;
    v.push_back({a, i});
  }
  sort(v.begin(), v.end(), comp);
  cin >> q;
  while (q--) {
    cin >> k >> pos;
    ans.clear();
    for (i = 0; i < k; i++) {
      ans.push_back({v[i].second, v[i].first});
    }
    sort(ans.begin(), ans.end());
    pos--;
    cout << ans[pos].second << '\n';
  }
  return 0;
}
