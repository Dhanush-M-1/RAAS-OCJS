#include <bits/stdc++.h>
using namespace std;
struct eq {
  long long si, f, s, r;
};
bool compare(eq a, eq b) {
  if (a.f == b.f) return a.s < b.s;
  return a.f < b.f;
}
bool comp(eq a, eq b) { return a.si < b.si; }
void solve() {
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (long long i = 0; i < n; i++) {
    long long t;
    cin >> t;
    v.push_back({t, -(i + 1)});
  }
  sort(v.begin(), v.end());
  long long m;
  cin >> m;
  while (m--) {
    long long k, p;
    cin >> k >> p;
    vector<pair<long long, long long> > temp;
    for (long long i = n - 1; i > n - 1 - k; i--) {
      temp.push_back({-(v[i].second), v[i].first});
    }
    sort(temp.begin(), temp.end());
    cout << temp[p - 1].second << endl;
  }
  return;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long t = 1;
  while (t--) {
    solve();
  }
}
