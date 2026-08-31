#include <bits/stdc++.h>
using namespace std;
const int MN = 100005, LG = 20;
const long long MOD = 1000000000 + 7;
vector<pair<int, int> > G[MN];
long long pod[MN], sumaPod[MN], resPod[MN], res[MN], D[MN], suma[MN];
long long sumaAll;
int dp[LG][MN], used[MN], pre[MN], post[MN];
int cnt;
int n;
void ala(int x, long long xd) {
  D[x] = xd;
  pod[x] = 1;
  pre[x] = ++cnt;
  int s = G[x].size();
  for (int i = 0; i < s; ++i) {
    if (!pod[G[x][i].first]) {
      dp[0][G[x][i].first] = x;
      ala(G[x][i].first, xd + G[x][i].second);
      long long ck = G[x][i].second;
      pod[x] += pod[G[x][i].first];
      sumaPod[x] += (sumaPod[G[x][i].first] + ck * pod[G[x][i].first]);
      sumaPod[x] %= MOD;
      resPod[x] += (resPod[G[x][i].first] +
                    ((G[x][i].second * sumaPod[G[x][i].first]) << 1) +
                    ((ck * ck) % MOD) * pod[G[x][i].first]) %
                   MOD;
      resPod[x] %= MOD;
    }
  }
  post[x] = ++cnt;
}
void basia(int x, int p, long long c) {
  used[x] = 1;
  int s = G[x].size();
  if (p) {
    suma[x] =
        (suma[p] + (((((long long)(n - (pod[x] << 1))) * c) % MOD) + MOD)) %
        MOD;
    res[x] = (res[p] -
              (resPod[x] + (((c * sumaPod[x]) << 1) % MOD) +
               ((((c * c) % MOD) * pod[x]) % MOD)) +
              MOD) %
             MOD;
    res[x] =
        (resPod[x] +
         ((((res[x] +
             (((c * (suma[p] - sumaPod[x] - ((c * (pod[x])) % MOD))) << 1) %
              MOD) +
             (((c * c) % MOD) * ((long long)(n - pod[x]))) % MOD) %
            MOD) +
           MOD) %
          MOD)) %
        MOD;
  } else {
    res[x] = resPod[x];
    suma[x] = sumaPod[x];
  }
  for (int i = 0; i < s; ++i) {
    if (!used[G[x][i].first])
      basia(G[x][i].first, x, (long long)G[x][i].second);
  }
}
bool child(int x, int y) { return (pre[x] >= pre[y] && post[x] <= post[y]); }
int lca(int x, int y) {
  if (child(x, y)) return y;
  if (child(y, x)) return x;
  int s = LG - 1;
  while (s >= 0) {
    if (child(y, dp[s][x]))
      --s;
    else
      x = dp[s][x];
  }
  x = dp[0][x];
  return x;
}
long long d(int x, int y) { return D[x] + D[y] - ((D[lca(x, y)]) << 1); }
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    int a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    G[a].push_back(make_pair(b, c));
    G[b].push_back(make_pair(a, c));
    sumaAll += c;
    sumaAll %= MOD;
  }
  ala(1, 0LL);
  basia(1, 0, 0LL);
  dp[0][1] = 1;
  for (int i = 1; i < LG; ++i)
    for (int j = 1; j <= n; ++j) dp[i][j] = dp[i - 1][dp[i - 1][j]];
  int q;
  scanf("%d", &q);
  while (q--) {
    int a, b;
    scanf("%d%d", &a, &b);
    long long x = d(a, b);
    x %= MOD;
    long long wynik;
    if (child(a, b)) {
      wynik =
          ((res[a] - (res[b] - resPod[b] + ((x * (suma[b] - sumaPod[b])) << 1) +
                      (((x * x) % MOD) * ((long long)((long long)n - pod[b])))))
           << 1) %
              MOD -
          res[a] + MOD;
      wynik = ((wynik % MOD) + MOD) % MOD;
    } else {
      wynik =
          ((resPod[b] + ((sumaPod[b] * x) << 1) + (((x * x) % MOD) * pod[b]))
           << 1);
      wynik = ((wynik % MOD) - res[a] + MOD) % MOD;
    }
    printf("%I64d\n", wynik);
  }
}
