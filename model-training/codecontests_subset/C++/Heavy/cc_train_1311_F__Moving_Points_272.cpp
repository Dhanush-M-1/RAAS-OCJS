#include <bits/stdc++.h>
using namespace std;
bool comp(pair<long long, long long> p1, pair<long long, long long> p2) {
  if (p1.second == p2.second) return p1.first < p2.first;
  return p1.second < p2.second;
}
signed main() {
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v(n);
  for (long long i = 0; i < n; i++) {
    cin >> v[i].first;
  }
  for (long long i = 0; i < n; i++) {
    cin >> v[i].second;
  }
  sort(v.begin(), v.end());
  map<long long, long long> mp;
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    ans += (2 * i - n + 1) * v[i].first;
    mp[v[i].first] = i;
  }
  sort(v.begin(), v.end(), comp);
  for (long long i = 0; i < n; i++) {
    ans += (i - mp[v[i].first]) * v[i].first;
  }
  cout << ans << endl;
}
