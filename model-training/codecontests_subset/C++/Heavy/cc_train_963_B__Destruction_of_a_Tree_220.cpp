#include <bits/stdc++.h>
using namespace std;
const long long N = 200010;
void solve() {
  long long n, m, i, j, k;
  cin >> n;
  vector<vector<long long> > v(n + 1);
  long long p[n + 1], root;
  for (i = 1; i <= n; i++) {
    cin >> p[i];
    if (p[i] > 0) {
      v[i].push_back(p[i]);
      v[p[i]].push_back(i);
    } else {
      root = i;
    }
  }
  if (n % 2 == 0) {
    cout << "NO\n";
    return;
  }
  cout << "YES\n";
  vector<long long> a;
  set<pair<long long, long long> > s;
  queue<long long> q;
  vector<long long> vis(n + 1), lev(n + 1), sz(n + 1);
  lev[root] = 1;
  q.push(root);
  vis[root] = 1;
  while (!q.empty()) {
    long long x = q.front();
    q.pop();
    if (v[x].size() % 2 == 0) {
      s.insert({-lev[x], x});
    }
    for (i = 0; i < v[x].size(); i++) {
      if (!vis[v[x][i]]) {
        vis[v[x][i]] = 1;
        lev[v[x][i]] = lev[x] + 1;
        q.push(v[x][i]);
      }
    }
  }
  for (i = 1; i <= n; i++) sz[i] = v[i].size();
  vector<long long> fr(n + 1);
  while (s.size() > 0) {
    set<pair<long long, long long> >::iterator itr;
    itr = s.begin();
    pair<long long, long long> p = *itr;
    s.erase(itr);
    long long x = p.second;
    fr[x] = 1;
    cout << x << "\n";
    for (i = 0; i < v[x].size(); i++) {
      if (sz[v[x][i]] % 2 == 1 && fr[v[x][i]] == 0) {
        s.insert({-lev[v[x][i]], v[x][i]});
      } else if (s.find({-lev[v[x][i]], v[x][i]}) != s.end()) {
        s.erase(s.find({-lev[v[x][i]], v[x][i]}));
      }
      sz[v[x][i]]--;
    }
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, m, i, j;
  long long q = 1;
  while (q--) solve();
}
