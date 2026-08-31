#include <bits/stdc++.h>
using namespace std;
void err(istream_iterator<string> it) {}
template <typename T, typename... Args>
void err(istream_iterator<string> it, T a, Args... args) {
  cerr << *it << " = " << a << "\n";
  err(++it, args...);
}
vector<pair<int, int> > edge(200003);
vector<vector<pair<int, int> > > ad(200003);
int sz[200003];
stack<int> pq;
int node;
int process(int k, int j) {
  int i, x, a, s;
  while (!pq.empty()) {
    s = pq.top();
    pq.pop();
    node--;
    sz[s] = 0;
    x = ad[s].size();
    for (i = 0; i < x; i++) {
      a = ad[s][i].first;
      if (ad[s][i].second <= j) {
        sz[a]--;
        if (sz[a] == k - 1) pq.push(a);
      }
    }
  }
  return node;
}
int main() {
  int n, m, k, i, a, b;
  scanf("%d%d%d", &n, &m, &k);
  for (i = 0; i < m; i++) {
    scanf("%d%d", &a, &b);
    a--, b--;
    ad[a].emplace_back(b, i);
    ad[b].emplace_back(a, i);
    sz[a]++, sz[b]++;
    edge[i] = {a, b};
  }
  vector<int> ans(m);
  for (i = 0; i < n; i++)
    if (sz[i] < k) pq.push(i);
  node = n;
  int j;
  for (i = m - 1; i >= 0; i--) {
    ans[i] = process(k, i);
    tie(a, b) = edge[i];
    if (sz[a] > 0 && sz[b] > 0) {
      if (sz[a] == k) pq.push(a);
      if (sz[b] == k) pq.push(b);
      sz[a]--, sz[b]--;
    }
  }
  for (i = 0; i < m; i++) printf("%d\n", ans[i]);
}
