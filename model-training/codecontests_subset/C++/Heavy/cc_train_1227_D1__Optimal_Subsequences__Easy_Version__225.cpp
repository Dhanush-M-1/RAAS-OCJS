#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5;
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first < b.first) return true;
  if (a.first > b.first) return false;
  if (a.second < b.second) return false;
  return true;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  vector<long long> a(n);
  vector<pair<long long, long long> > b;
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    b.push_back({a[i], i});
  }
  sort(b.begin(), b.end(), comp);
  long long t;
  cin >> t;
  while (t--) {
    long long k, pos;
    cin >> k >> pos;
    vector<pair<long long, long long> > c;
    long long cnt = 0;
    for (long long i = n - 1; i >= 0; i--) {
      c.push_back({b[i].second, b[i].first});
      cnt++;
      if (cnt == k) break;
    }
    sort(c.begin(), c.end());
    cout << c[pos - 1].second << endl;
  }
  return 0;
}
