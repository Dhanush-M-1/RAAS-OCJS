#include <bits/stdc++.h>
#pragma GCC optimize("-Ofast")
using namespace std;
bool compare(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first != b.first) {
    return a.first > b.first;
  } else {
    return a.second < b.second;
  }
}
int32_t main() {
  long long n;
  cin >> n;
  long long arr[n];
  vector<pair<long long, long long> > v;
  for (long long i = 0; i < n; i++) {
    cin >> arr[i];
    v.push_back({arr[i], i});
  }
  sort(v.begin(), v.end(), compare);
  long long m;
  cin >> m;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    vector<pair<long long, long long> > cur;
    for (long long i = 0; i < k; i++) {
      cur.push_back({v[i].second, v[i].first});
    }
    sort(cur.begin(), cur.end());
    cout << cur[pos - 1].second << '\n';
  }
}
