#include <bits/stdc++.h>
using namespace std;
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  return a.first > b.first || a.first == b.first && a.second < b.second;
}
bool comp2(pair<long long, long long> a, pair<long long, long long> b) {
  return a.second < b.second;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  long long a[n];
  pair<long long, long long> s[n];
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    s[i] = {a[i], i};
  }
  sort(s, s + n, comp);
  vector<pair<long long, long long> > ans;
  long long m;
  cin >> m;
  for (long long j = 0; j < m; j++) {
    long long k, p;
    cin >> k >> p;
    ans.clear();
    for (long long i = 0; i < k; i++) ans.push_back(s[i]);
    sort(ans.begin(), ans.end(), comp2);
    cout << ans[p - 1].first << endl;
  }
  return 0;
}
