#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const long long MOD = 1e9 + 7;
const long long mxN = 2e5 + 3;
bool cmp(pair<long long, long long> p1, pair<long long, long long> p2) {
  if (p1.first > p2.first)
    return true;
  else if (p1.first == p2.first) {
    if (p1.second < p2.second) return true;
    return false;
  }
  return false;
}
void solve() {
  long long n;
  cin >> n;
  long long a[n + 1];
  pair<long long, long long> b[n];
  for (long long i = 0; i < n; ++i) {
    cin >> a[i + 1];
    b[i].first = a[i + 1];
    b[i].second = (i + 1);
  }
  sort(b, b + n, cmp);
  long long m;
  cin >> m;
  long long kj, pos_j;
  vector<vector<long long> > ve(n);
  for (long long i = 0; i < n; ++i) {
    for (long long j = i; j < n; ++j) {
      ve[j].push_back(b[i].second);
    }
  }
  for (long long i = 0; i < n; ++i) sort((ve[i]).begin(), (ve[i]).end());
  while (m--) {
    cin >> kj >> pos_j;
    kj--;
    (pos_j)--;
    cout << a[ve[kj][pos_j]] << "\n";
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long nT = 1;
  for (long long i = (long long)1; i <= (long long)nT; ++i) solve();
  return 0;
}
