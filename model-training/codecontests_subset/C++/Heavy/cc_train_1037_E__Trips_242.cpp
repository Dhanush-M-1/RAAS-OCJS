#include <bits/stdc++.h>
using namespace std;
struct edge {
  int to, net;
};
int head[2000000];
int e_n;
edge edges[2000000];
int deg[2000000];
bool sd[2000000];
int v1[2000000], v2[2000000];
set<pair<int, int> > help;
set<pair<int, int> > tt;
void Init() {
  help.clear();
  e_n = 0;
  memset(sd, 0, sizeof(sd));
  memset(deg, 0, sizeof(deg));
  memset(head, -1, sizeof(head));
}
void add(int f, int t) {
  int tmp = head[f];
  edges[e_n++] = edge{t, tmp};
  head[f] = e_n - 1;
}
int main(void) {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n, m, k;
  Init();
  cin >> n >> m >> k;
  int i, j, x, y;
  for (i = 1; i <= m; i++) {
    cin >> x >> y;
    v1[i] = x, v2[i] = y;
    add(x, y);
    add(y, x);
    ++deg[x], ++deg[y];
  }
  for (i = 1; i <= n; i++) {
    help.insert(make_pair(deg[i], i));
  }
  list<int> res;
  for (i = m; i >= 1; i--) {
    while (!help.empty() && help.begin()->first < k) {
      int cur = help.begin()->second;
      sd[cur] = 1;
      help.erase(help.begin());
      for (j = head[cur]; j != -1; j = edges[j].net) {
        int t = edges[j].to;
        if (!tt.count(make_pair(cur, t))) {
          help.erase(help.find(make_pair(deg[t], t)));
          deg[t]--;
          help.insert(make_pair(deg[t], t));
          tt.insert(make_pair(cur, t));
          tt.insert(make_pair(t, cur));
        }
      }
    }
    res.push_front(help.size());
    if (sd[v1[i]] == 0 && sd[v2[i]] == 0) {
      help.erase(help.find(make_pair(deg[v1[i]], v1[i])));
      help.insert(make_pair(--deg[v1[i]], v1[i]));
      help.erase(help.find(make_pair(deg[v2[i]], v2[i])));
      help.insert(make_pair(--deg[v2[i]], v2[i]));
    }
    tt.insert(make_pair(v1[i], v2[i]));
    tt.insert(make_pair(v2[i], v1[i]));
  }
  for (auto a : res) cout << a << "\n";
  return 0;
}
