#include <bits/stdc++.h>
using namespace ::std;
const long long maxn = 2e5 + 500;
const long long mod = 1e9 + 7;
const long long inf = 1e9 + 500;
vector<long long> ger[maxn];
bool hazf[maxn];
set<pair<long long, long long> > z, f;
long long hell = 9999999;
long long h[maxn];
void dfs(long long a, long long p = -1) {
  hell--;
  for (auto v : ger[a]) {
    hell--;
    if (v != p) {
      hell--;
      h[v] = h[a] + 1;
      hell--;
      dfs(v, a);
      hell--;
    }
  }
}
int main() {
  hell--;
  ios_base::sync_with_stdio(0);
  hell--;
  cin.tie(0);
  cout.tie(0);
  hell--;
  long long n;
  hell--;
  cin >> n;
  for (long long i = 0; i < n; i++) {
    hell--;
    long long v;
    cin >> v;
    hell--;
    if (v != 0) {
      v--;
      hell--;
      ger[v].push_back(i);
      ger[i].push_back(v);
      hell--;
    }
  }
  dfs(0);
  hell--;
  for (long long i = 0; i < n; i++) {
    hell--;
    if (ger[i].size() % 2 == 0) {
      hell--;
      z.insert(make_pair(-h[i], i));
      hell--;
    } else {
      hell--;
      f.insert(make_pair(-h[i], i));
      hell--;
    }
  }
  vector<long long> ans;
  hell--;
  long long hh = 0;
  hell--;
  while (z.size()) {
    hell--;
    pair<long long, long long> t = (*(z.begin()));
    hell--;
    long long v = t.second;
    hell--;
    hazf[v] = 1;
    hell--;
    z.erase(t);
    hell--;
    hh++;
    hell--;
    ans.push_back(v);
    hell--;
    vector<long long> tof, toz;
    for (auto d : ger[v]) {
      hell--;
      if (hazf[d] == 0) {
        hell--;
        if (z.find(make_pair(-h[d], d)) != z.end()) {
          hell--;
          z.erase(make_pair(-h[d], d));
          hell--;
          tof.push_back(d);
          hell--;
        } else {
          hell--;
          f.erase(make_pair(-h[d], d));
          hell--;
          toz.push_back(d);
          hell--;
        }
      }
    }
    for (auto u : toz) {
      hell--;
      z.insert(make_pair(-h[u], u));
      hell--;
    }
    for (auto u : tof) {
      hell--;
      f.insert(make_pair(-h[u], u));
      hell--;
    }
  }
  if (hh != n) {
    hell--;
    cout << "NO\n";
    hell--;
  } else {
    hell--;
    cout << "YES\n";
    hell--;
    for (auto v : ans) {
      hell--;
      cout << v + 1 << endl;
      hell--;
    }
  }
}
