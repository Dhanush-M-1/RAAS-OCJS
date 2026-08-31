#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10, mod = 1e9 + 7, lg = 16 + 2;
long long n, q, par[N][lg], sumup[N][lg], tvin[N][lg], sumin[N][lg],
    cntin[N][lg], sumst[N], tvst[N], cntst[N], updtv[N], updsum[N], updcnt[N],
    h[N];
vector<pair<long long, long long> > gr[N];
long long mrg(long long ftv, long long fsum, long long fcnt, long long add) {
  return 1ll *
         (1ll * ftv + 1ll * fsum * add % mod * 2 % mod +
          1ll * add * add % mod * fcnt % mod) %
         mod;
}
void getSt(long long v, long long par = -1) {
  for (auto p : gr[v]) {
    long long u = p.first, w = p.second;
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
void getPr(long long v, long long parent = -1, long long wb = -1) {
  if (parent != -1) {
    h[v] = h[parent] + 1;
    par[v][0] = parent, sumup[v][0] = wb;
    for (long long i = 1; i < lg - 1; i++)
      par[v][i] = par[par[v][i - 1]][i - 1],
      sumup[v][i] = (sumup[v][i - 1] + sumup[par[v][i - 1]][i - 1]) % mod;
    cntin[v][0] = cntst[parent] - updcnt[v],
    sumin[v][0] = (sumst[parent] - updsum[v] + mod) % mod;
    tvin[v][0] = mrg((tvst[parent] - updtv[v] + mod) % mod, sumin[v][0],
                     cntin[v][0], wb);
    sumin[v][0] = (sumin[v][0] + 1ll * cntin[v][0] * wb % mod) % mod;
    for (long long i = 1; i < lg - 1; i++) {
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
    long long u = p.first, w = p.second;
    if (u != parent) getPr(u, v, w);
  }
}
bool isAnc(long long v, long long u) {
  long long diff = h[v] - h[u];
  if (diff <= 0) return false;
  for (long long i = 0; i < lg - 1; i++)
    if (((diff >> i) & 1)) v = par[v][i];
  if (v == u) return true;
  return false;
}
long long AnsAnc(long long v, long long u) {
  long long pst = tvst[v], rtr = 0, sumrn = 0;
  long long diff = h[v] - h[u];
  for (long long i = lg - 1; i >= 0; i--) {
    if (((diff >> i) & 1)) {
      rtr = (rtr + mrg(tvin[v][i], sumin[v][i], cntin[v][i], sumrn)) % mod;
      sumrn = (sumrn + sumup[v][i]) % mod;
      v = par[v][i];
    }
  }
  return (rtr + pst) % mod;
}
long long getSum(long long v, long long u) {
  if (h[u] > h[v]) swap(u, v);
  long long diff = h[v] - h[u], rtr = 0;
  for (long long i = 0; i < lg - 1; i++) {
    if (((diff >> i) & 1)) rtr = (rtr + sumup[v][i]) % mod, v = par[v][i];
  }
  if (v == u) return rtr;
  for (long long i = lg - 1; i >= 0; i--) {
    if (par[v][i] != par[u][i]) {
      rtr = ((rtr + sumup[v][i]) % mod + sumup[u][i]) % mod;
      v = par[v][i], u = par[u][i];
    }
  }
  rtr = ((rtr + sumup[v][0]) % mod + sumup[u][0]) % mod;
  return rtr;
}
long long AnsN(long long v, long long u) {
  long long sum = getSum(v, u);
  return mrg(tvst[u], sumst[u], cntst[u], sum);
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 0; i < n - 1; i++) {
    long long x, y, w;
    cin >> x >> y >> w;
    x--, y--;
    gr[x].push_back({y, w});
    gr[y].push_back({x, w});
  }
  getSt(0);
  getPr(0);
  cin >> q;
  while (q--) {
    long long x, y;
    cin >> x >> y;
    x--, y--;
    long long rtr;
    if (isAnc(x, y))
      rtr = AnsAnc(x, y);
    else
      rtr = AnsN(x, y);
    long long mn = AnsAnc(x, 0);
    rtr = ((rtr * 2 - mn) % mod + mod) % mod;
    cout << rtr << "\n";
  }
  return 0;
}
