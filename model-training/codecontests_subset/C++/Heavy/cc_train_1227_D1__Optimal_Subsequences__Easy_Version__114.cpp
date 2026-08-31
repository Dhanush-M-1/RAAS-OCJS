#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long n;
  cin >> n;
  vector<long long> v(n);
  map<long long, vector<long long>> def;
  for (long long i = 0; i < n; i++) {
    cin >> v[i];
    def[v[i]].push_back(i);
  }
  vector<long long> g;
  for (auto p : def) {
    long long a = p.first;
    vector<long long> b = p.second;
    for (long long i = 0; i < b.size(); i++) {
      g.push_back(b[b.size() * 1ll - i - 1]);
    }
  }
  reverse(g.begin(), g.end());
  long long m;
  cin >> m;
  for (long long i = 0; i < m; i++) {
    long long k, pos;
    cin >> k >> pos;
    vector<long long> f;
    for (long long j = 0; j < k; j++) {
      f.push_back(g[j]);
    }
    sort(f.begin(), f.end());
    cout << v[f[pos - 1]] << "\n";
  }
  return 0;
}
