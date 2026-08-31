#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m;
  cin >> n >> m;
  long long a[n + 2];
  map<long long, long long> pam2;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    pam2[a[i]] = i;
  }
  if (m == 0) {
    cout << 0;
    return 0;
  }
  long long u, v;
  map<long long, vector<long long> > pam;
  long long s = a[n];
  vector<long long> v1;
  for (long long i = 1; i <= m; i++) {
    cin >> u >> v;
    if (v == s) v1.push_back(u);
    pam[u].push_back(v);
  }
  if (v1.size() == 0) {
    cout << 0;
    return 0;
  }
  vector<pair<long long, long long> > b;
  for (long long i = 0; i < v1.size(); i++) {
    b.push_back({pam2[v1[i]], v1[i]});
  }
  sort(b.begin(), b.end());
  long long Ans = n;
  long long ans = 0;
  for (long long i = b.size() - 1; i >= 0; i--) {
    long long p = b[i].second;
    vector<long long> t = pam[p];
    long long cnt = 0;
    for (long long j = 0; j < t.size(); j++) {
      long long idx = pam2[t[j]];
      if (idx > b[i].first and idx < Ans) {
        cnt++;
      }
    }
    if (cnt == Ans - b[i].first - 1 - ans) {
      ans++;
      pam2[b[i].second] = n + 1;
    }
    pam[p].clear();
    t.clear();
  }
  cout << ans;
}
