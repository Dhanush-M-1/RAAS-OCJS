#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:256000000")
using namespace std;
const long double PI = acosl((long double)-1.0);
const long long LINF = ((1ull << 63) - 1ull);
const int MOD = 1000000007;
const int MAXN = 1000005;
int n, m, k;
int v1[MAXN], v2[MAXN];
pair<int, int> w[MAXN];
int ans[1001];
int p[1001];
int c[1001];
int l[1001];
int r[1001];
vector<vector<vector<int> > > comps;
int num;
void init() {
  scanf("%d%d%d", &n, &m, &k);
  comps.resize(k + 1);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d%d", &v1[i], &v2[i], &w[i].first);
    w[i].second = i;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d%d", &l[i], &r[i]);
  }
}
void init_dsu() {
  comps[num].resize(n + 1);
  for (int i = 1; i <= n; i++) {
    p[i] = i;
    comps[num][i].push_back(i);
  }
}
inline bool union_sets(int v1, int v2) {
  if (p[v1] == p[v2]) {
    return c[v1] != c[v2];
  }
  int p1 = p[v1];
  int p2 = p[v2];
  if (comps[num][p1].size() < comps[num][p2].size()) {
    swap(p1, p2);
  }
  for (int i = 0; i < comps[num][p2].size(); i++) {
    p[comps[num][p2][i]] = p1;
  }
  comps[num][p1].insert(comps[num][p1].end(), comps[num][p2].begin(),
                        comps[num][p2].end());
  if (c[v1] == c[v2]) {
    for (int i = 0; i < comps[num][p2].size(); i++) {
      c[comps[num][p2][i]] ^= 1;
    }
  }
  return true;
}
void solve() {
  init();
  sort(w + 1, w + m + 1);
  for (num = 1; num <= k; num++) {
    init_dsu();
    int ans = -1;
    for (int j = m; j >= 1; j--) {
      if (l[num] <= w[j].second && w[j].second <= r[num]) {
        if (!union_sets(v1[w[j].second], v2[w[j].second])) {
          ans = w[j].first;
          break;
        }
      }
    }
    printf("%d\n", ans);
  }
}
void precalc() {}
int main() {
  srand(25);
  precalc();
  int tests = 1;
  for (int i = 1; i <= tests; i++) {
    solve();
  }
  return 0;
}
