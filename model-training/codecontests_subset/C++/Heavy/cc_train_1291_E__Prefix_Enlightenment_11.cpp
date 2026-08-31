#include <bits/stdc++.h>
using namespace std;
const int N = 3e5;
const int oo = 1e7 + 5;
int du[] = {-1, 0, 0, 1};
int dv[] = {0, -1, 1, 0};
const long long mod = 1e9 + 7;
long long sqr(long long x) { return x * x; }
int getbit(int state, int i) { return ((state >> i) & 1); }
int n, m, res, dad[N + 5];
vector<int> g[N + 5];
char s[N + 5];
struct Clara {
  int l, r, state;
  Clara(int L = 0, int R = 0, int State = 0) {
    l = L;
    r = R;
    state = State;
  }
  int getmin() { return min(l, r); }
  void add(Clara tmp) {
    l = min(oo, l + tmp.l);
    r = min(oo, r + tmp.r);
  }
} node[N + 5];
pair<int, int> getdad(int u) {
  if (dad[u] < 0) return pair<int, int>(u, 0);
  pair<int, int> tmp = getdad(dad[u]);
  dad[u] = tmp.first;
  node[u].state ^= tmp.second;
  return pair<int, int>(tmp.first, node[u].state);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> m >> (s + 1);
  for (int i = 1; i <= m; i++) {
    int c, k;
    node[i] = Clara(1, 0, 0);
    dad[i] = -1;
    cin >> c;
    for (int j = 1; j <= c; j++) {
      cin >> k;
      g[k].push_back(i);
    }
  }
  for (int i = 1; i <= n; i++) {
    int type = s[i] - '0';
    if (g[i].size() == 1) {
      pair<int, int> u = getdad(g[i][0]);
      res -= node[u.first].getmin();
      if ((!type && !u.second) || (type && u.second))
        node[u.first].add(Clara(0, oo, 0));
      else
        node[u.first].add(Clara(oo, 0, 0));
      res += node[u.first].getmin();
    } else if (g[i].size() == 2) {
      pair<int, int> u = getdad(g[i][0]);
      pair<int, int> v = getdad(g[i][1]);
      if (u.first != v.first) {
        res -= node[u.first].getmin() + node[v.first].getmin();
        if (dad[u.first] > dad[v.first]) swap(u, v);
        if ((type && u.second != v.second) || (!type && u.second == v.second)) {
          swap(node[v.first].l, node[v.first].r);
          node[v.first].state = 1;
        }
        node[u.first].add(node[v.first]);
        dad[u.first] += dad[v.first];
        dad[v.first] = u.first;
        res += node[u.first].getmin();
      }
    }
    cout << res << '\n';
  }
  return 0;
}
