#include <bits/stdc++.h>
using namespace std;
int n;
int k;
vector<int> v;
struct block {
  int total;
  int el[134];
  int dp[134];
  int sz;
  block() {
    total = 0;
    sz = 0;
  }
  pair<long long int, long long int> way[134];
  bool need;
  inline void build() { need = true; }
  inline void build(int dum) {
    need = false;
    for (int i = 0; i < sz; i++) {
      int val = el[i];
      way[i] = (make_pair(el[i], dp[i]));
    }
    sort(way, way + sz);
    for (int i = 1; i < sz; i++) {
      way[i].second += way[i - 1].second;
      if (way[i].second >= 998244353) way[i].second -= 998244353;
    }
  }
  inline long long int query() {
    if (need) build(114);
    long long int until = k - total;
    int id = upper_bound(way, way + sz, make_pair(until, LLONG_MAX)) - way;
    id--;
    if (id < 0) return 0;
    return way[id].second;
  }
};
block b[900];
vector<int> vv[100002];
void add_rng(int l, int r, int x) {
  int lef = l / 134;
  int rig = r / 134;
  for (int i = lef + 1; i < rig; i++) {
    b[i].total += x;
  }
  if (lef == rig) {
    for (int i = l % 134; i <= r % 134; i++) {
      b[lef].el[i] += x;
    }
    b[lef].build();
  } else {
    for (int i = l % 134; i < b[lef].sz; i++) {
      b[lef].el[i] += x;
    }
    for (int i = 0; i <= r % 134; i++) {
      b[rig].el[i] += x;
    }
    b[lef].build();
    b[rig].build();
  }
}
long long int gt(int f) {
  int be = f / 134;
  long long int z = 0;
  for (int i = 0; i <= be; i++) {
    z += b[i].query();
    if (z >= 998244353) z -= 998244353;
  }
  return z;
}
set<int> us;
set<int> tmp;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int a;
    scanf("%d", &a);
    v.push_back(a);
  }
  for (int i = 0; i < n; i++) {
    b[i / 134].el[b[i / 134].sz++] = 0;
    b[i / 134].dp[b[i / 134].sz - 1] = 0;
  }
  for (int i = 0; i < 100002; i++) {
    vv[i].push_back(-1);
  }
  b[0].dp[0]++;
  for (int i = 0; i < n; i++) {
    int belong = (i + 1) / 134;
    int att = (i + 1) % 134;
    int val = v[i];
    if (us.count(val) == 0) {
      us.insert(val);
      tmp.insert(val);
    } else {
      if (tmp.count(val)) {
        tmp.erase(val);
      }
    }
    if (vv[val].size() == 1) {
      add_rng(0, i, 1);
    } else {
      vector<int> &V = vv[val];
      add_rng(V[V.size() - 2] + 1, V[V.size() - 1], -1);
      add_rng(V.back() + 1, i, 1);
    }
    vv[val].push_back(i);
    long long int nex = gt(i);
    if (nex >= 998244353) nex -= 998244353;
    b[belong].dp[att] += nex;
    b[belong].build();
  }
  long long int ans = b[(n) / 134].dp[(n) % 134];
  printf("%lld\n", ans);
  return 0;
}
