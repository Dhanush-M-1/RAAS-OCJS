#include <bits/stdc++.h>
const double pi = 3.141592653589793238;
const int MOD1 = 1e9 + 7;
const int MOD2 = 998244353;
const int N = 3e5 + 5;
using namespace std;
bool cmp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first != b.first) return (a.first > b.first);
  return (a.second < b.second);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n = 0;
  cin >> n;
  vector<pair<long long, long long>> a(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i + 1;
  }
  sort((a).begin(), (a).end(), cmp);
  long long q = 0;
  cin >> q;
  while (q--) {
    long long k, pos;
    cin >> k >> pos;
    set<pair<long long, long long>> s;
    for (long long i = 0; i < k; i++) {
      s.insert({a[i].second, a[i].first});
    }
    while (--pos) s.erase(s.begin());
    auto m = *(s.begin());
    cout << m.second << "\n";
  }
}
