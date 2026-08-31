#include <bits/stdc++.h>
using namespace std;
int n, S, a[200010], fa[200010];
inline int getf(int x) { return x == fa[x] ? x : fa[x] = getf(fa[x]); }
inline void merge(int x, int y) {
  x = getf(x);
  y = getf(y);
  if (x != y) fa[x] = y;
}
pair<int, int> p[200010];
class node {
 public:
  int vl, pos, id;
  bool operator<(const node &t) const { return vl < t.vl; }
};
int rk[200010], rr[200010];
bool vis[200010];
int main() {
  scanf("%d%d", &n, &S);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    p[i] = make_pair(a[i], i);
  }
  sort(p + 1, p + n + 1);
  iota(fa + 1, fa + n + 1, 1);
  int cnt = 0;
  for (int i = 1; i <= n; i++)
    if (a[i] != p[i].first) cnt++;
  if (cnt > S) {
    puts("-1");
    return 0;
  }
  vector<node> v;
  v.push_back((node){0, 0, 0});
  for (int i = 1; i <= n; i++) {
    if (a[i] != p[i].first) {
      v.push_back((node){a[i], 0, i});
      v.back().pos = v.size() - 1;
    }
  }
  sort(v.begin() + 1, v.end());
  int s = v.size() - 1;
  for (int i = 1; i <= s; i++) rk[v[i].pos] = i, rr[v[i].pos] = v[i].id;
  for (int i = 1; i <= s; i++) merge(i, rk[i]);
  for (int i = 2; i <= s; i++) {
    if (v[i].vl == v[i - 1].vl && getf(i) != getf(i - 1)) {
      swap(rk[v[i].pos], rk[v[i - 1].pos]);
      merge(i - 1, i);
    }
  }
  vector<vector<int> > cycle;
  for (int i = 1; i <= s; i++) {
    if (!vis[i]) {
      cycle.push_back(vector<int>({rr[i]}));
      vis[i] = 1;
      for (int j = rk[i]; j != i; j = rk[j]) {
        cycle.back().push_back(rr[j]);
        vis[j] = 1;
      }
    }
  }
  cnt = min((int)cycle.size(), S - s);
  vector<vector<int> > opt;
  for (int i = cnt; i < cycle.size(); i++) opt.push_back(cycle[i]);
  if (cnt >= 2) {
    opt.push_back(vector<int>());
    for (int i = 0; i < cnt; i++)
      opt.back().insert(opt.back().end(), cycle[i].begin(), cycle[i].end());
    opt.push_back(vector<int>());
    for (int i = 0; i < cnt; i++) opt.back().push_back(cycle[i].front());
    reverse(opt.back().begin(), opt.back().end());
  } else {
    for (int i = 0; i < cnt; i++) opt.push_back(cycle[i]);
  }
  printf("%u\n", opt.size());
  for (auto &x : opt) {
    printf("%u\n", x.size());
    for (auto &y : x) printf("%d ", y);
    puts("");
  }
  return 0;
}
