#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
const long long MOD = 1e9 + 7;
pair<int, int> es[200000];
vector<pair<int, int> > g[200000];
int degree[200000];
set<pair<int, int> > st;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (long long i = 0; i < m; i++) {
    scanf("%d%d", &es[i].first, &es[i].second);
    es[i].first--, es[i].second--;
    g[es[i].first].push_back({es[i].second, i});
    g[es[i].second].push_back({es[i].first, i});
    degree[es[i].first]++, degree[es[i].second]++;
  }
  reverse(es, es + m);
  for (long long i = 0; i < n; i++) st.insert({degree[i], i});
  while (!st.empty() && st.begin()->first < k) {
    auto v = st.begin();
    for (pair<int, int> &i : g[v->second]) {
      int to = i.first;
      if (st.find({degree[to], to}) != st.end()) {
        st.erase({degree[to], to});
        degree[to]--;
        st.insert({degree[to], to});
      }
    }
    st.erase(v);
  }
  vector<int> out;
  for (long long j = 0; j < m; j++) {
    out.push_back(st.size());
    int u = es[j].first, v = es[j].second;
    if (st.find({degree[u], u}) != st.end() &&
        st.find({degree[v], v}) != st.end()) {
      st.erase({degree[u], u});
      degree[u]--;
      st.insert({degree[u], u});
      st.erase({degree[v], v});
      degree[v]--;
      st.insert({degree[v], v});
      while (!st.empty() && st.begin()->first < k) {
        auto v = st.begin();
        for (pair<int, int> &i : g[v->second]) {
          if (i.second >= m - j - 1) continue;
          int to = i.first;
          if (st.find({degree[to], to}) != st.end()) {
            st.erase({degree[to], to});
            degree[to]--;
            st.insert({degree[to], to});
          }
        }
        st.erase(v);
      }
    }
  }
  reverse(begin(out), end(out));
  for (int i : out) printf("%d\n", i);
}
