#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
const int mod = 998244353;
int n, k, sq;
int a[N], dp[N], bl[N], bk[405][N], tag[405], val[405], num[N];
vector<int> ve[N], pos[405];
inline void rebuild(int p) {
  int l = (p - 1) * sq + 1, r = min(n, p * sq);
  for (int i = 0; i < pos[p].size(); ++i) bk[p][pos[p][i]] = 0;
  for (int i = l; i <= r; ++i) num[i] += tag[p];
  tag[p] = 0;
  val[p] = 0;
  pos[p].clear();
  for (int i = l; i <= r; ++i) {
    (bk[p][num[i]] += dp[i - 1]) %= mod;
    pos[p].push_back(num[i]);
    if (num[i] <= k) (val[p] += dp[i - 1]) %= mod;
  }
}
inline void insert(int l, int r) {
  for (int i = bl[l] + 1; i < bl[r]; ++i)
    (val[i] +=
     k - tag[i] >= 0 && k - tag[i] <= n ? mod - bk[i][k - tag[i]] : 0) %= mod,
        ++tag[i];
  for (int i = l, lim = min(r, bl[l] * sq); i <= lim; ++i) ++num[i];
  if (bl[l] != bl[r])
    for (int i = (bl[r] - 1) * sq + 1; i <= r; ++i) ++num[i];
  rebuild(bl[l]);
  rebuild(bl[r]);
}
inline void erase(int l, int r) {
  for (int i = bl[l] + 1; i < bl[r]; ++i)
    --tag[i], (val[i] += k - tag[i] >= 0 && k - tag[i] <= n ? bk[i][k - tag[i]]
                                                            : 0) %= mod;
  for (int i = l, lim = min(r, bl[l] * sq); i <= lim; ++i) --num[i];
  if (bl[l] != bl[r])
    for (int i = (bl[r] - 1) * sq + 1; i <= r; ++i) --num[i];
  rebuild(bl[l]);
  rebuild(bl[r]);
}
int main() {
  scanf("%d%d", &n, &k);
  dp[0] = 1;
  sq = sqrt(n);
  for (int i = 1; i <= n; ++i)
    scanf("%d", &a[i]), bl[i] = (i - 1) / sq + 1, ve[i].push_back(0);
  for (int i = 1; i <= n; ++i) {
    ve[a[i]].push_back(i);
    if (ve[a[i]].size() >= 3) {
      int sz = ve[a[i]].size(), l = ve[a[i]][sz - 3] + 1, r = ve[a[i]][sz - 2];
      erase(l, r);
    }
    int sz = ve[a[i]].size(), l = ve[a[i]][sz - 2] + 1, r = ve[a[i]][sz - 1];
    insert(l, r);
    for (int j = 1; j <= bl[n]; ++j) (dp[i] += val[j]) %= mod;
  }
  return printf("%d\n", dp[n]), 0;
}
