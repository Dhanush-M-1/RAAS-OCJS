#include <bits/stdc++.h>
using namespace std;
struct nnn {
  int adj, next;
  long long c;
};
const long long modn = (long long)1000000007;
int n, m, tot, tt, tno;
int g[300000];
nnn addr[300000];
long long f[300000], fs[300000], s[300000], pc[300000], lq[300000], sdi[300000],
    spc[300000];
int sn[300000], sf[300000], ss[300000], tr[700000], td[700000], v[300000];
void ins(int x, int y, long long c) {
  tot++;
  addr[tot].adj = y;
  addr[tot].c = c;
  addr[tot].next = g[x];
  g[x] = tot;
}
void dfs(int d, int dep, long long dist) {
  dep++;
  tt++;
  sn[tt] = d;
  sf[d] = tt;
  ss[tt] = dep;
  fs[d] = 0, f[d] = 0, pc[d] = 1;
  dist %= modn;
  lq[d] = dist;
  v[d] = 1;
  for (int p = g[d]; p != -1; p = addr[p].next) {
    if (v[p[addr].adj]) continue;
    dfs(addr[p].adj, dep, dist + addr[p].c);
    fs[d] += (fs[addr[p].adj] + (addr[p].c * pc[addr[p].adj]) % modn) % modn;
    fs[d] %= modn;
    pc[d] = (pc[d] + pc[addr[p].adj]) % modn;
    f[d] += (f[addr[p].adj] +
             (pc[addr[p].adj] * ((addr[p].c * addr[p].c) % modn)) % modn +
             ((long long)2) * ((addr[p].c * fs[addr[p].adj]) % modn)) %
            modn;
    f[d] %= modn;
    tt++;
    sn[tt] = d;
    ss[tt] = dep;
  }
}
void dfs2(int d, long long sum, long long ed, long long npc, long long ndi) {
  long long a = npc, b = ndi;
  if (d != 1) {
    long long thi = (f[d] + (pc[d] * ((ed * ed) % modn)) % modn +
                     ((long long)2) * ((ed * fs[d]) % modn)) %
                    modn;
    sum = (sum + ((long long)20000000) * modn - thi) % modn;
    npc -= pc[d];
    ndi = (ndi + ((long long)20000000) * modn - fs[d] - (pc[d] * ed) % modn) %
          modn;
    thi = (sum + (npc * ((ed * ed) % modn)) % modn +
           ((long long)2) * ((ed * ndi) % modn)) %
          modn;
    s[d] = thi;
    sdi[d] = (ndi + (npc * ed) % modn) % modn;
    spc[d] = npc;
    b = ((npc * ed) % modn + ndi + fs[d]) % modn;
  } else {
    s[d] = 0;
    npc = pc[d];
    ndi = fs[d];
    sdi[d] = 0;
    spc[d] = 0;
    a = npc;
    b = ndi;
  }
  v[d] = 1;
  for (int p = g[d]; p != -1; p = addr[p].next) {
    if (v[addr[p].adj]) continue;
    dfs2(addr[p].adj, s[d] + f[d], addr[p].c, a, b);
  }
}
void inst(int d, int l, int r, int x, int c) {
  if (l > r) return;
  if (l == r) {
    tr[d] = c;
    td[d] = sn[x];
    return;
  }
  int o = (l + r) >> 1, ll = 2 * d, rr = 2 * d + 1;
  if (x <= o)
    inst(ll, l, o, x, c);
  else
    inst(rr, o + 1, r, x, c);
  if (tr[ll] < tr[rr]) {
    tr[d] = tr[ll];
    td[d] = td[ll];
  } else {
    tr[d] = tr[rr];
    td[d] = td[rr];
  }
}
int mfind(int d, int l, int r, int x, int y, int *id) {
  if (l > r) return 1000000007;
  if (l == x && r == y) {
    *id = td[d];
    return tr[d];
  }
  int o = (l + r) >> 1, ll = 2 * d, rr = 2 * d + 1;
  if (y <= o) {
    return mfind(ll, l, o, x, y, id);
  }
  if (x > o) {
    return mfind(rr, o + 1, r, x, y, id);
  }
  int lid, rid;
  int lp = mfind(ll, l, o, x, o, &lid),
      rp = mfind(rr, o + 1, r, o + 1, y, &rid);
  if (lp < rp) {
    *id = lid;
    return lp;
  } else {
    *id = rid;
    return rp;
  }
}
int main() {
  int tn;
  int ti, i, j, k, o;
  int a, b;
  double c, d;
  scanf("%d", &n);
  {
    memset(g, -1, sizeof(g));
    tot = 0;
    for (i = 0; i < n - 1; i++) {
      scanf("%d%d%d", &a, &b, &k);
      ins(a, b, k);
      ins(b, a, k);
    }
    tt = 0;
    memset(v, 0, sizeof(v));
    dfs(1, 0, 0);
    memset(v, 0, sizeof(v));
    dfs2(1, 0, 0, 0, 0);
    for (i = 1; i <= tt; i++) {
      inst(1, 1, tt, i, ss[i]);
    }
    scanf("%d", &m);
    for (i = 0; i < m; i++) {
      scanf("%d%d", &a, &b);
      mfind(1, 1, tt, (((sf[a]) < (sf[b])) ? (sf[a]) : (sf[b])),
            max(sf[a], sf[b]), &k);
      long long dd = (lq[a] + lq[b] + ((long long)20000000) * modn -
                      ((long long)2) * lq[k]) %
                     modn;
      if (k != b) {
        long long temp = (f[b] + ((long long)2) * ((dd * fs[b]) % modn) +
                          ((dd * dd) % modn * pc[b]) % modn) %
                         modn;
        long long ans = (((long long)20000000) * modn - s[a] - f[a] +
                         ((long long)2) * temp) %
                        modn;
        printf("%I64d\n", ans);
        if (ans == 48911997) printf("%d %d %d\n", a, b, k);
      } else {
        long long temp = (s[b] + ((long long)2) * ((dd * sdi[b]) % modn) +
                          ((dd * dd) % modn * spc[b]) % modn) %
                         modn;
        long long ans = (s[a] + f[a] + ((long long)20000000) * modn -
                         ((long long)2) * temp) %
                        modn;
        printf("%I64d\n", ans);
        if (ans == 48911997) printf("%d %d %d\n", a, b, k);
      }
    }
  }
  return 0;
}
