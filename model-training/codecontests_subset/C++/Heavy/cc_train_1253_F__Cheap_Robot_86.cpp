#include <bits/stdc++.h>
using namespace std;
const long long N = 4e5;
vector<tuple<long long, long long, long long> > edge;
priority_queue<long long> q;
long long d[N];
set<long long> se[N];
long long pa[N];
vector<long long> qr[N];
vector<pair<long long, long long> > ke[N];
long long Res[N];
long long anc(long long u) {
  if (pa[u] > 0) {
    pa[u] = anc(pa[u]);
    return pa[u];
  } else
    return u;
}
void join(long long u, long long v, long long z) {
  u = anc(u);
  v = anc(v);
  if (u == v) {
    return;
  }
  if (pa[u] > pa[v]) swap(u, v);
  pa[u] += pa[v];
  pa[v] = u;
  for (auto& vse : se[v]) {
    if (se[u].size())
      if (se[u].find(vse) != se[u].end()) {
        Res[vse] = z;
      }
  }
  for (auto& vse : se[v]) se[u].insert(vse);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  long long n, m, k, Q;
  cin >> n >> m >> k >> Q;
  for (long long i = 1; i <= m; i++) {
    long long first, second, z;
    cin >> first >> second >> z;
    ke[first].push_back(pair<long long, long long>(second, z));
    ke[second].push_back(pair<long long, long long>(first, z));
    edge.push_back(tuple<long long, long long, long long>(first, second, z));
  }
  priority_queue<pair<long long, long long> > q;
  for (long long i = 1; i <= k; i++) {
    q.push(pair<long long, long long>(0, i));
    d[i] = 0;
  }
  for (long long i = k + 1; i <= n; i++) d[i] = 1e18;
  while (q.size()) {
    long long u;
    u = q.top().second;
    q.pop();
    for (auto& v : ke[u]) {
      long long first, second;
      tie(second, first) = v;
      if (d[second] > d[u] + first) {
        d[second] = d[u] + first;
        q.push(pair<long long, long long>(-d[second], second));
      }
    }
  }
  for (auto& i : edge) {
    long long first, second, z;
    tie(first, second, z) = i;
    get<2>(i) = d[first] + d[second] + z;
  }
  sort(edge.begin(), edge.end(),
       [](const tuple<long long, long long, long long>& a,
          const tuple<long long, long long, long long>& b) -> bool {
         return get<2>(a) < get<2>(b);
       });
  for (long long i = 1; i <= Q; i++) {
    long long first, second;
    cin >> first >> second;
    se[first].insert(i);
    se[second].insert(i);
  }
  for (long long i = 1; i <= n; i++) pa[i] = -1;
  for (auto& i : edge) {
    long long first, second, z;
    tie(first, second, z) = i;
    join(first, second, z);
  }
  for (long long i = 1; i <= Q; i++) {
    cout << Res[i] << "\n";
  }
}
