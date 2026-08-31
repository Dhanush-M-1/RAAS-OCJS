#include <bits/stdc++.h>
using namespace std;
long long pw(long long a, long long b) {
  if (b == 0) return 1;
  if (b % 2 == 1)
    return (a * pw((a * a) % 1000000007, b / 2)) % 1000000007;
  else
    return (1 * pw((a * a) % 1000000007, b / 2)) % 1000000007;
}
bool comp(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first) return a.second < b.second;
  return a.first > b.first;
}
bool comp2(pair<long long, long long> a, pair<long long, long long> b) {
  return a.second < b.second;
}
void solve() {
  int n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (int i = 0; i < n; i++) {
    long long x;
    cin >> x;
    v.push_back({x, i});
  }
  sort(v.begin(), v.end(), comp);
  vector<vector<pair<long long, long long> > > ans;
  for (int k = 0; k < n + 1; k++) {
    vector<pair<long long, long long> > temp;
    for (int j = 0; j < k; j++) temp.push_back(v[j]);
    sort(temp.begin(), temp.end(), comp2);
    ans.push_back(temp);
  }
  long long m;
  cin >> m;
  while (m--) {
    long long k, p;
    cin >> k >> p;
    cout << ans[k][p - 1].first << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
