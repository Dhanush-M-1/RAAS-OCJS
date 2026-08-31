#include <bits/stdc++.h>
using namespace std;
template <class c>
struct rge {
  c b, e;
};
template <class c>
rge<c> range(c i, c j) {
  return {i, j};
}
struct printer {
  ~printer() { cerr << endl; }
  template <class c>
  printer& operator,(c x) {
    cerr << boolalpha << x;
    return *this;
  }
  printer& operator,(string x) {
    cerr << x;
    return *this;
  }
  template <class c, class d>
  printer& operator,(pair<c, d> x) {
    return *this, "(", x.first, ", ", x.second, ")";
  }
  template <class... d, template <class...> class c>
  printer& operator,(c<d...> x) {
    return *this, range(begin(x), end(x));
  }
  template <class c>
  printer& operator,(rge<c> x) {
    *this, "[";
    for (auto it = x.b; it != x.e; ++it) *this, (it == x.b ? "" : ", "), *it;
    return *this, "]";
  }
};
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int my_rand(int l, int r) { return uniform_int_distribution<int>(l, r)(rng); }
const int N = 200009;
vector<int> vec[N];
int ar[N], degree[N], level[N];
struct node {
  int u, lv, id;
  bool operator<(const node& p) const { return p.lv > lv; }
};
void dfs(int u, int par, int lv) {
  level[u] = lv;
  int v, i, sz = vec[u].size();
  for (i = 0; i < sz; i++) {
    v = vec[u][i];
    if (v != par) {
      dfs(v, u, lv + 1);
    }
  }
}
int main() {
  int n, i, r;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &r);
    if (r == 0) continue;
    vec[i].push_back(r);
    vec[r].push_back(i);
    degree[r]++;
    degree[i]++;
  }
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  }
  for (i = 1; i <= n; i++) {
    if (degree[i] == 1) {
      dfs(i, -1, 0);
      break;
    }
  }
  priority_queue<node> pq;
  for (i = 1; i <= n; i++) {
    if (degree[i] % 2 == 0) pq.push({i, level[i], 0});
  }
  vector<int> ans;
  while (!pq.empty()) {
    node top = pq.top();
    pq.pop();
    if (top.id != ar[top.u]) continue;
    ans.push_back(top.u);
    int sz = vec[top.u].size();
    for (i = 0; i < sz; i++) {
      int v = vec[top.u][i];
      if (degree[v] > 0) {
        degree[v]--;
        ar[v]++;
        if (degree[v] == 0)
          ans.push_back(v);
        else if (degree[v] % 2 == 0) {
          pq.push({v, level[v], ar[v]});
        }
      }
    }
    degree[top.u] = 0;
  }
  int sz = ans.size();
  printf("YES\n");
  for (i = 0; i < sz; i++) {
    printf("%d\n", ans[i]);
  }
  return 0;
}
