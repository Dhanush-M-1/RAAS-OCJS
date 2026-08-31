#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T abs(T a) {
  return ((a < 0) ? -a : a);
}
template <typename T>
inline T sqr(T a) {
  return a * a;
}
const int N = 100500;
int n;
vector<pair<int, int> > g[N];
const int MOD = 1e9 + 7;
inline int add(int a, int b) {
  int res = a + b;
  if (res >= MOD) res -= MOD;
  return res;
}
inline int sub(int a, int b) {
  int res = a - b;
  if (res < 0) res += MOD;
  return res;
}
inline int mul(int a, int b) {
  long long res = a * 1LL * b;
  if (res >= MOD) res %= MOD;
  return int(res);
}
struct thing {
  int cnt, sum, sumSq;
  thing() {}
  thing(int cnt, int sum, int sumSq) : cnt(cnt), sum(sum), sumSq(sumSq) {}
  thing extend(int len) {
    thing res(cnt, add(sum, mul(len, cnt)),
              add(sumSq, add(mul(2, mul(sum, len)), mul(mul(len, len), cnt))));
    return res;
  }
};
thing operator+(const thing& a, const thing& b) {
  thing res(add(a.cnt, b.cnt), add(a.sum, b.sum), add(a.sumSq, b.sumSq));
  return res;
}
thing operator-(const thing& a, const thing& b) {
  thing res(sub(a.cnt, b.cnt), sub(a.sum, b.sum), sub(a.sumSq, b.sumSq));
  return res;
}
thing down[N];
void dfsDown(int v, int p = -1) {
  down[v] = thing(1, 0, 0);
  for (int i = int(0); i < int(int((g[v]).size())); ++i) {
    int to = g[v][i].first;
    if (to == p) continue;
    dfsDown(to, v);
    down[v] = down[v] + down[to].extend(g[v][i].second);
  }
}
const int LOG = 20;
int pp[N][LOG];
thing sumAll[N];
thing ups[N];
int tin[N], tout[N], dep[N], curT;
int depLen[N];
void dfs(int v, int p = -1, thing up = thing(0, 0, 0)) {
  ups[v] = up;
  sumAll[v] = up + down[v];
  tin[v] = curT++;
  pp[v][0] = p == -1 ? v : p;
  for (int i = int(1); i < int(LOG); ++i) pp[v][i] = pp[pp[v][i - 1]][i - 1];
  for (int i = int(0); i < int(int((g[v]).size())); ++i) {
    int to = g[v][i].first;
    if (to == p) continue;
    dep[to] = dep[v] + 1;
    depLen[to] = add(depLen[v], g[v][i].second);
    dfs(to, v,
        (sumAll[v] - down[to].extend(g[v][i].second)).extend(g[v][i].second));
  }
  tout[v] = curT++;
}
bool isParent(int p, int v) { return tin[p] <= tin[v] && tout[v] <= tout[p]; }
int lca(int a, int b) {
  if (dep[a] > dep[b]) swap(a, b);
  for (int i = LOG - 1; i >= 0; --i) {
    if (dep[pp[b][i]] > dep[a]) b = pp[b][i];
  }
  if (dep[a] != dep[b]) b = pp[b][0];
  assert(dep[a] == dep[b]);
  for (int i = LOG - 1; i >= 0; --i) {
    if (pp[a][i] != pp[b][i]) {
      a = pp[a][i];
      b = pp[b][i];
    }
  }
  if (a != b) {
    a = pp[a][0];
    b = pp[b][0];
  }
  assert(a == b);
  return a;
}
int d(int a, int b) {
  int p = lca(a, b);
  return sub(add(depLen[a], depLen[b]), mul(2, depLen[p]));
}
int f(int a, int b) {
  int res = sumAll[a].sumSq;
  if (isParent(b, a)) {
    res = sub(res, mul(2, ups[b].extend(d(a, b)).sumSq));
  } else {
    res = sub(res, mul(2, down[b].extend(d(a, b)).sumSq));
    res = sub(0, res);
  }
  return res;
}
bool solve() {
  if (scanf("%d", &n) != 1) return false;
  curT = 0;
  for (int i = int(0); i < int(n - 1); ++i) {
    int a, b, c;
    assert(scanf("%d%d%d", &a, &b, &c) == 3);
    --a;
    --b;
    g[a].push_back(pair<int, int>(b, c));
    g[b].push_back(pair<int, int>(a, c));
  }
  dep[0] = 0;
  depLen[0] = 0;
  dfsDown(0);
  dfs(0);
  int q;
  assert(scanf("%d", &q) == 1);
  for (int i = int(0); i < int(q); ++i) {
    int a, b;
    assert(scanf("%d%d", &a, &b) == 2);
    --a;
    --b;
    printf("%d\n", f(a, b));
  }
  for (int i = int(0); i < int(n); ++i) {
    g[i].clear();
  }
  return true;
}
int main() {
  cout << fixed << setprecision(10);
  cerr << fixed << setprecision(3);
  while (solve()) {
  }
  return 0;
}
