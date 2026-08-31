#include <bits/stdc++.h>
using namespace std;
const int inf = 2000000000;
const long long infLL = 9000000000000000000;
template <typename first, typename second>
ostream& operator<<(ostream& os, const pair<first, second>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <typename T>
ostream& operator<<(ostream& os, const vector<T>& v) {
  os << "{";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const set<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ",";
    os << *it;
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const multiset<T>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << *it;
  }
  return os << "]";
}
template <typename first, typename second>
ostream& operator<<(ostream& os, const map<first, second>& v) {
  os << "[";
  for (auto it = v.begin(); it != v.end(); ++it) {
    if (it != v.begin()) os << ", ";
    os << it->first << " = " << it->second;
  }
  return os << "]";
}
void faltu() { cerr << '\n'; }
template <typename T>
void faltu(T a[], int n) {
  for (int i = 0; i < n; ++i) cerr << a[i] << ' ';
  cerr << '\n';
}
template <typename T, typename... hello>
void faltu(T arg, const hello&... rest) {
  cerr << arg << ' ';
  faltu(rest...);
}
const int mx = 3e5 + 5;
int n, m;
int p[mx];
set<int> st[mx];
set<pair<int, int> > unvisited;
int cnt;
int rev[mx];
void dfs(int u, int idx) {
  ++cnt;
  unvisited.erase(make_pair(idx, u));
  int cur = 0;
  int hmm = idx;
  while (1) {
    auto itr = unvisited.upper_bound(make_pair(hmm, -1));
    if (itr == unvisited.begin()) return;
    --itr;
    int v = (*itr).second;
    cur = v;
    hmm = (*itr).first;
    if (st[u].lower_bound(v) != st[u].upper_bound(v)) continue;
    dfs(v, (*itr).first);
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) cin >> p[i], rev[p[i]] = i;
  for (int i = 1; i <= n; ++i) unvisited.insert(make_pair(i, p[i]));
  for (int i = 1; i <= m; ++i) {
    int u, v;
    cin >> u >> v;
    st[v].insert(u);
  }
  dfs(p[n], n);
  cout << n - cnt << '\n';
}
