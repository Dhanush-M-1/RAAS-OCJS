#include <bits/stdc++.h>
using namespace std;
template <class S, class T>
ostream& operator<<(ostream& os, const pair<S, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
void debug(T a, T b) {
  cerr << "[";
  for (T i = a; i != b; ++i) {
    if (i != a) cerr << ", ";
    cerr << *i;
  }
  cerr << "]\n";
}
struct Edge {
  int u, v, w, idx;
  inline bool operator<(const Edge& o) const { return w > o.w; }
};
const int N = 1010;
int par[N];
int opp[N];
int get(int n) {
  if (par[n] != n) {
    par[n] = get(par[n]);
  }
  return par[n];
}
inline void merge(int u, int v) {
  u = get(u), v = get(v);
  if (u == v) {
    return;
  }
  if (rand() & 1) {
    par[v] = u;
  } else {
    par[u] = v;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, q;
  cin >> n >> m >> q;
  vector<Edge> edge(m);
  for (int i = 0; i < (m); ++i) {
    cin >> edge[i].u >> edge[i].v >> edge[i].w;
    --edge[i].u, --edge[i].v;
    edge[i].idx = i;
  }
  sort(edge.begin(), edge.end());
  while (q--) {
    int l, r;
    cin >> l >> r;
    --l, --r;
    for (int i = 0; i < (n); ++i) {
      par[i] = i;
      opp[i] = -1;
    }
    int ans = -1;
    for (Edge e : edge) {
      if (e.idx >= l and e.idx <= r) {
        int u = get(e.u), v = get(e.v);
        if (u == v) {
          ans = e.w;
          break;
        }
        if (opp[u] != -1) {
          merge(opp[u], v);
        } else {
          opp[u] = v;
        }
        if (opp[v] != -1) {
          merge(opp[v], u);
        } else {
          opp[v] = u;
        }
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
