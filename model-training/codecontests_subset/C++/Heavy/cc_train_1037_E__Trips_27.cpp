#include <bits/stdc++.h>
using namespace std;
vector<vector<long long> > adj;
set<long long> st;
vector<long long> deg;
long long k;
set<pair<long long, long long> > edges;
void remove(long long r) {
  st.erase(r);
  for (long long i = 0; i < adj[r].size(); i++) {
    long long c = adj[r][i];
    if (st.find(c) == st.end()) continue;
    if (edges.find(make_pair(r, c)) == edges.end()) continue;
    edges.erase(make_pair(r, c));
    edges.erase(make_pair(c, r));
    deg[c]--;
    if (deg[c] < k) remove(c);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  long long n, m;
  cin >> n >> m >> k;
  vector<long long> x(m);
  vector<long long> y(m);
  adj.resize(n);
  deg.resize(n, 0);
  for (long long i = 0; i < m; i++) {
    cin >> x[i] >> y[i];
    x[i]--;
    y[i]--;
    adj[x[i]].push_back(y[i]);
    adj[y[i]].push_back(x[i]);
    edges.insert(make_pair(x[i], y[i]));
    edges.insert(make_pair(y[i], x[i]));
    deg[x[i]]++;
    deg[y[i]]++;
  }
  for (long long i = 0; i < n; i++) {
    st.insert(i);
  }
  for (long long i = 0; i < n; i++) {
    if (st.find(i) == st.end()) continue;
    if (deg[i] < k) remove(i);
  }
  vector<long long> res;
  res.push_back(st.size());
  for (long long i = m - 1; i >= 1; i--) {
    if (st.find(x[i]) == st.end() || st.find(y[i]) == st.end()) {
      res.push_back(st.size());
      continue;
    }
    edges.erase(make_pair(x[i], y[i]));
    edges.erase(make_pair(y[i], x[i]));
    deg[x[i]]--;
    deg[y[i]]--;
    if (deg[x[i]] < k) remove(x[i]);
    if (st.find(y[i]) != st.end()) {
      if (deg[y[i]] < k) remove(y[i]);
    }
    res.push_back(st.size());
  }
  reverse(res.begin(), res.end());
  for (long long i = 0; i < res.size(); i++) {
    cout << res[i] << endl;
  }
  return 0;
}
