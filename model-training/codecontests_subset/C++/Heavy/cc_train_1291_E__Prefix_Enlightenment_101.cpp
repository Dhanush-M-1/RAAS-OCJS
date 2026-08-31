#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 10;
const int INF = 1e9 + 7;
struct node {
  int l, r;
  node(int _l = 0, int _r = 0) : l(_l), r(_r){};
  void operator+=(node x) {
    l = min(l + x.l, INF);
    r = min(r + x.r, INF);
  }
  int get() { return min(l, r); }
} val[N];
int root[N], rev[N];
pair<int, int> getRoot(int u) {
  if (u == root[u]) {
    return make_pair(u, 0);
  } else {
    pair<int, int> tmp = getRoot(root[u]);
    root[u] = tmp.first;
    rev[u] ^= tmp.second;
    return make_pair(root[u], rev[u]);
  }
}
int n, k;
vector<int> adj[N];
string s;
int main() {
  cin >> n >> k;
  cin >> s;
  for (int i = 1; i <= k; i++) {
    val[i] = node(1, 0);
    root[i] = i;
    rev[i] = 0;
    int c;
    cin >> c;
    while (c--) {
      int x;
      cin >> x;
      adj[x].push_back(i);
    }
  }
  int curAns = 0;
  for (int i = 1; i <= n; i++) {
    int t = (s[i - 1] - '0') ^ 1;
    if (adj[i].size() == 1) {
      pair<int, int> u = getRoot(adj[i][0]);
      curAns -= val[u.first].get();
      val[u.first] += node((u.second == t) * INF, (u.second != t) * INF);
      curAns += val[u.first].get();
    }
    if (adj[i].size() == 2) {
      pair<int, int> u = getRoot(adj[i][0]);
      pair<int, int> v = getRoot(adj[i][1]);
      if (u.first != v.first) {
        curAns -= val[u.first].get();
        curAns -= val[v.first].get();
        if (u.first > v.first) swap(u, v);
        if (u.second ^ v.second ^ t) {
          rev[v.first] = 1;
          swap(val[v.first].l, val[v.first].r);
        }
        root[v.first] = u.first;
        val[u.first] += val[v.first];
        curAns += val[u.first].get();
      }
    }
    cout << curAns << endl;
  }
}
