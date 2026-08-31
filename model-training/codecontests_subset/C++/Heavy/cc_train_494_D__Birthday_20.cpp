#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10, mod = 1e9 + 7, lg = 16 + 2;
int n, q, par[N][lg], sumup[N][lg], tvin[N][lg], sumin[N][lg], cntin[N][lg],
    sumst[N], tvst[N], cntst[N], updtv[N], updsum[N], updcnt[N], h[N];
vector<pair<int, int> > gr[N];
long long mrg(int ftv, int fsum, int fcnt, int add) {
  return 1ll *
         (1ll * ftv + 1ll * fsum * add % mod * 2 % mod +
          1ll * add * add % mod * fcnt % mod) %
         mod;
}
void getSt(int v, int par = -1) {
  for (auto p : gr[v]) {
    int u = p.first, w = p.second;
    if (u != par) {
      getSt(u, v);
      updtv[u] = mrg(tvst[u], sumst[u], cntst[u], w),
      tvst[v] = (tvst[v] + updtv[u]) % mod;
      updsum[u] = (1ll * cntst[u] * w % mod + sumst[u]) % mod,
      sumst[v] = (sumst[v] + updsum[u]) % mod;
      updcnt[u] = cntst[u], cntst[v] = cntst[v] + updcnt[u];
    }
  }
  cntst[v]++;
}
void getPr(int v, int parent = -1, int wb = -1) {
  if (parent != -1) {
    h[v] = h[parent] + 1;
    par[v][0] = parent, sumup[v][0] = wb;
    for (int i = 1; i < lg - 1; i++)
      par[v][i] = par[par[v][i - 1]][i - 1],
      sumup[v][i] = (sumup[v][i - 1] + sumup[par[v][i - 1]][i - 1]) % mod;
    cntin[v][0] = cntst[parent] - updcnt[v],
    sumin[v][0] = (sumst[parent] - updsum[v] + mod) % mod;
    tvin[v][0] = mrg((tvst[parent] - updtv[v] + mod) % mod, sumin[v][0],
                     cntin[v][0], wb);
    sumin[v][0] = (sumin[v][0] + 1ll * cntin[v][0] * wb % mod) % mod;
    for (int i = 1; i < lg - 1; i++) {
      cntin[v][i] = (cntin[v][i - 1] + cntin[par[v][i - 1]][i - 1]) % mod;
      sumin[v][i] = ((sumin[v][i - 1] + 1ll * sumup[v][i - 1] *
                                            cntin[par[v][i - 1]][i - 1] % mod) %
                         mod +
                     sumin[par[v][i - 1]][i - 1] % mod) %
                    mod;
      tvin[v][i] = (tvin[v][i - 1] +
                    mrg(tvin[par[v][i - 1]][i - 1], sumin[par[v][i - 1]][i - 1],
                        cntin[par[v][i - 1]][i - 1], sumup[v][i - 1])) %
                   mod;
    }
  }
  for (auto p : gr[v]) {
    int u = p.first, w = p.second;
    if (u != parent) getPr(u, v, w);
  }
}
bool isAnc(int v, int u) {
  int diff = h[v] - h[u];
  if (diff <= 0) return false;
  for (int i = 0; i < lg - 1; i++)
    if (((diff >> i) & 1)) v = par[v][i];
  if (v == u) return true;
  return false;
}
int AnsAnc(int v, int u) {
  int pst = tvst[v], rtr = 0, sumrn = 0;
  int diff = h[v] - h[u];
  for (int i = lg - 1; i >= 0; i--) {
    if (((diff >> i) & 1)) {
      rtr = (rtr + mrg(tvin[v][i], sumin[v][i], cntin[v][i], sumrn)) % mod;
      sumrn = (sumrn + sumup[v][i]) % mod;
      v = par[v][i];
    }
  }
  return (rtr + pst) % mod;
}
int getSum(int v, int u) {
  if (h[u] > h[v]) swap(u, v);
  int diff = h[v] - h[u], rtr = 0;
  for (int i = 0; i < lg - 1; i++) {
    if (((diff >> i) & 1)) rtr = (rtr + sumup[v][i]) % mod, v = par[v][i];
  }
  if (v == u) return rtr;
  for (int i = lg - 1; i >= 0; i--) {
    if (par[v][i] != par[u][i]) {
      rtr = ((rtr + sumup[v][i]) % mod + sumup[u][i]) % mod;
      v = par[v][i], u = par[u][i];
    }
  }
  rtr = ((rtr + sumup[v][0]) % mod + sumup[u][0]) % mod;
  return rtr;
}
int AnsN(int v, int u) {
  int sum = getSum(v, u);
  return mrg(tvst[u], sumst[u], cntst[u], sum);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int x, y, w;
    cin >> x >> y >> w;
    x--, y--;
    gr[x].push_back({y, w});
    gr[y].push_back({x, w});
  }
  getSt(0);
  getPr(0);
  cin >> q;
  while (q--) {
    int x, y;
    cin >> x >> y;
    x--, y--;
    long long rtr;
    if (isAnc(x, y))
      rtr = AnsAnc(x, y);
    else
      rtr = AnsN(x, y);
    int mn = AnsAnc(x, 0);
    rtr = ((rtr * 2 - mn) % mod + mod) % mod;
    cout << rtr << "\n";
  }
  return 0;
}
