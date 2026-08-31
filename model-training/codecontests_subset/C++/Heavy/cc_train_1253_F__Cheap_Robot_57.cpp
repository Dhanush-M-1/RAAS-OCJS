#include <bits/stdc++.h>
using namespace std;
int n, m, k, q;
vector<pair<long long, long long>> adj[100001];
int owner[100001];
long long dst[100001];
struct edge {
  long long a, b, c;
  bool operator<(const edge& masik) const { return c < masik.c; }
};
vector<edge> lst;
int par[100001];
set<int> qs[100001];
long long ans[300001];
void init() {
  for (int i = 1; i <= n; ++i) {
    par[i] = -1;
  }
}
int get(int x) {
  if (par[x] == -1) return x;
  return par[x] = get(par[x]);
}
void merge(int x, int y, long long w) {
  int px = get(x), py = get(y);
  if (px == py) return;
  if (qs[px].size() > qs[py].size()) {
    swap(px, py);
  }
  for (auto i : qs[px]) {
    auto it = qs[py].find(i);
    if (it != qs[py].end()) {
      qs[py].erase(i);
      ans[i] = w;
    } else {
      qs[py].insert(i);
    }
  }
  par[px] = py;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k >> q;
  for (int i = 0; i < m; ++i) {
    int a, b, c;
    cin >> a >> b >> c;
    adj[a].push_back({b, c});
    adj[b].push_back({a, c});
  }
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 greater<pair<long long, long long>>>
      pq;
  for (int i = 1; i <= k; ++i) {
    owner[i] = i;
    pq.push({0, i});
  }
  while (!pq.empty()) {
    auto tp = pq.top();
    pq.pop();
    if (dst[tp.second] < tp.first) continue;
    for (auto i : adj[tp.second]) {
      if (owner[i.first] != owner[tp.second]) {
        if (owner[i.first] == 0) {
          dst[i.first] = i.second + tp.first;
          owner[i.first] = owner[tp.second];
          pq.push({dst[i.first], i.first});
        } else {
          if (dst[i.first] > i.second + tp.first) {
            dst[i.first] = i.second + tp.first;
            owner[i.first] = owner[tp.second];
            pq.push({dst[i.first], i.first});
          } else {
            lst.push_back({owner[i.first], owner[tp.second],
                           dst[i.first] + dst[tp.second] + i.second});
          }
        }
      } else {
        if (dst[i.first] > i.second + tp.first) {
          dst[i.first] = i.second + tp.first;
          pq.push({dst[i.first], i.first});
        }
      }
    }
  }
  sort(lst.begin(), lst.end());
  for (int i = 0; i < q; ++i) {
    int a, b;
    cin >> a >> b;
    qs[a].insert(i);
    qs[b].insert(i);
  }
  init();
  for (auto i : lst) {
    merge(i.a, i.b, i.c);
  }
  for (int i = 0; i < q; ++i) {
    cout << ans[i] << "\n";
  }
  return 0;
}
