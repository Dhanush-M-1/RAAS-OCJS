#include <bits/stdc++.h>
using namespace std;
const int MX = 4e5, MOD = 1e9 + 7;
long long n, m, k, q;
long long P[MX];
vector<tuple<long long, long long, long long>> edges;
vector<pair<long long, long long>> adjList[MX];
set<int> qr[MX];
long long r[MX], p[MX];
long long ans[MX];
long long curAns = 0;
void dijkstra() {
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      pq;
  for (int i = int(0); i < int(n); i++) P[i] = 1e18;
  for (int i = int(0); i < int(k); i++) pq.push({0, i}), P[i] = 0;
  while (!pq.empty()) {
    pair<long long, long long> p = pq.top();
    pq.pop();
    long long u = p.second, w = p.first;
    if (P[u] != w) continue;
    for (pair<long long, long long> v : adjList[u])
      if (w + v.second < P[v.first])
        pq.push({w + v.second, v.first}), P[v.first] = w + v.second;
  }
}
void buildDSU() {
  for (int i = int(0); i < int(n); i++) r[i] = 0, p[i] = i;
}
int getSet(int i) { return i == p[i] ? i : p[i] = getSet(p[i]); }
bool isSameSet(int i, int j) { return getSet(i) == getSet(j); }
void unionSet(int i, int j) {
  if (!isSameSet(i, j)) {
    i = getSet(i), j = getSet(j);
    if (r[i] > r[j]) {
      p[j] = i;
      for (long long u : qr[j]) {
        if (qr[i].count(u)) {
          qr[i].erase(u);
          ans[u] = curAns;
        } else {
          qr[i].insert(u);
        }
      }
    } else {
      p[i] = j;
      for (long long u : qr[i]) {
        if (qr[j].count(u)) {
          qr[j].erase(u);
          ans[u] = curAns;
        } else {
          qr[j].insert(u);
        }
      }
      if (r[i] == r[j]) r[j]++;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> k >> q;
  for (int i = int(0); i < int(m); i++) {
    int u, v, w;
    cin >> u >> v >> w;
    u--;
    v--;
    adjList[u].push_back({v, w});
    adjList[v].push_back({u, w});
    edges.push_back({u, v, w});
  }
  dijkstra();
  buildDSU();
  for (int Q = int(0); Q < int(q); Q++) {
    int a, b;
    cin >> a >> b;
    a--;
    b--;
    qr[a].insert(Q);
    qr[b].insert(Q);
  }
  priority_queue<tuple<long long, long long, long long>,
                 vector<tuple<long long, long long, long long>>,
                 greater<tuple<long long, long long, long long>>>
      pq;
  for (int i = int(0); i < int(m); i++) {
    long long u, v, w;
    tie(u, v, w) = edges[i];
    pq.push({w + P[u] + P[v], u, v});
  }
  while (!pq.empty()) {
    long long u, v, w;
    tie(w, u, v) = pq.top();
    pq.pop();
    if (!isSameSet(u, v)) {
      curAns = w;
      unionSet(u, v);
    }
  }
  for (int i = int(0); i < int(q); i++) cout << ans[i] << endl;
}
