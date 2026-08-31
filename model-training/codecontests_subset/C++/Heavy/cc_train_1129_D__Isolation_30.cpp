#include <bits/stdc++.h>
#pragma GCC optimize("O2,Ofast,inline,unroll-all-loops,-ffast-math")
#pragma GCC target("avx,sse2,sse3,sse4,popcnt")
using namespace std;
int a[100007], bel[100007], pre[100007], pos[100007], tag[293], delt[100007], n,
    k, S;
int f[100007], sum[293][100007 * 2 + 1], ans[293];
const int p = 998244353;
template <class T>
void read(T &x) {
  char ch = x = 0;
  bool fl = false;
  while (!isdigit(ch)) fl |= ch == '-', ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x = fl ? -x : x;
}
void add(int &x, const int &y) { x = (x + y) % p; }
void ins(int x, int y, long long val) {
  int id = bel[x];
  add(sum[id][(delt[x] = y - tag[id]) + 100007], val);
  if (y <= k) add(ans[id], val);
}
void build(int id) {
  for (int i = (id - 1) * S; i < id * S; i++) {
    add(sum[id][delt[i] + 100007], p - f[i]);
    delt[i] += tag[id];
    add(sum[id][delt[i] + 100007], f[i]);
  }
  tag[id] = 0;
}
void upd(int l, int r, int val) {
  if (bel[l] == bel[r]) {
    build(bel[l]);
    for (int i = l; i <= r; i++) {
      add(sum[bel[l]][delt[i] + 100007], p - f[i]);
      if (~val && delt[i] == k) add(ans[bel[l]], p - f[i]);
      if (!~val && delt[i] == k + 1) add(ans[bel[l]], f[i]);
      delt[i] += val;
      add(sum[bel[l]][delt[i] + 100007], f[i]);
    }
  } else {
    build(bel[l]);
    for (int i = l; i < bel[l] * S; i++) {
      add(sum[bel[l]][delt[i] + 100007], p - f[i]);
      if (~val && delt[i] == k) add(ans[bel[l]], p - f[i]);
      if (!~val && delt[i] == k + 1) add(ans[bel[l]], f[i]);
      delt[i] += val;
      add(sum[bel[l]][delt[i] + 100007], f[i]);
    }
    build(bel[r]);
    for (int i = (bel[r] - 1) * S; i <= r; i++) {
      add(sum[bel[r]][delt[i] + 100007], p - f[i]);
      if (~val && delt[i] == k) add(ans[bel[r]], p - f[i]);
      if (!~val && delt[i] == k + 1) add(ans[bel[r]], f[i]);
      delt[i] += val;
      add(sum[bel[r]][delt[i] + 100007], f[i]);
    }
    for (int i = bel[l] + 1; i < bel[r]; i++) {
      if (~val)
        add(ans[i], p - sum[i][k - tag[i] + 100007]);
      else
        add(ans[i], sum[i][k + 1 - tag[i] + 100007]);
      tag[i] += val;
    }
  }
}
int que(int r) {
  int ret = 0;
  for (int i = 1; i < bel[r]; i++) {
    add(ret, ans[i]);
  }
  build(bel[r]);
  for (int i = (bel[r] - 1) * S; i <= r; i++) {
    if (delt[i] <= k) add(ret, f[i]);
  }
  return ret;
}
int main() {
  read(n), read(k), S = max((int)sqrt(n), n / 289);
  for (int i = 1; i <= n; i++) {
    read(a[i]), pre[i] = pos[a[i]], pos[a[i]] = i;
  }
  for (int i = 0; i <= n; i++) {
    bel[i] = i / S + 1;
  }
  ins(0, 0, f[0] = 1);
  for (int i = 1; i <= n; i++) {
    upd(pre[i], i - 1, 1);
    if (pre[i]) upd(pre[pre[i]], pre[i] - 1, -1);
    f[i] = que(i - 1), ins(i, 0, f[i]);
  }
  printf("%d\n", f[n]);
  return 0;
}
