#include <bits/stdc++.h>
using namespace std;
struct X {
  int id;
  int sz;
  int dep;
  X() {}
  X(int id, int sz, int dep) : id(id), sz(sz), dep(dep) {}
  bool operator<(const X x) const {
    if (sz % 2 == 0 && x.sz % 2 != 0) return 1;
    if (sz % 2 != 0 && x.sz % 2 == 0) return 0;
    if (dep > x.dep) return 1;
    if (dep < x.dep) return 0;
    return id < x.id;
  }
};
set<X> st;
unordered_set<int> v[200005];
vector<int> ans;
int dep[200005];
void dfs(int now, int fa) {
  dep[now] = dep[fa] + 1;
  for (auto x : v[now]) {
    if (x == fa) continue;
    dfs(x, now);
  }
}
int main(void) {
  int n;
  scanf("%d", &n);
  int i;
  for (i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    if (p != 0) {
      v[i].insert(p);
      v[p].insert(i);
    }
  }
  dfs(1, 1);
  for (i = 1; i <= n; i++) {
    st.insert(X(i, v[i].size(), dep[i]));
  }
  while (st.size()) {
    X b = *st.begin();
    if (b.sz % 2 != 0) break;
    ans.push_back(b.id);
    st.erase(st.begin());
    for (auto nxt : v[b.id]) {
      st.erase(X(nxt, v[nxt].size(), dep[nxt]));
      v[nxt].erase(b.id);
      st.insert(X(nxt, v[nxt].size(), dep[nxt]));
    }
    v[b.id].clear();
  }
  if (st.size() == 0) {
    printf("YES\n");
    for (auto g : ans) printf("%d\n", g);
  } else
    printf("NO\n");
  return 0;
}
