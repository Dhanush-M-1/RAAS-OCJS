#include <bits/stdc++.h>
using namespace std;
struct ahowwogaw {
  int v, next;
} _[1000005];
int head[1000005], tot = 1, zyl[200005], yihuo[1000005], a[1000005];
bool qwer[1000005];
int fyr(int iakioi) {
  if (zyl[iakioi] >= 0) {
    return zyl[iakioi];
  }
  int i, ykb = 0, t;
  for (i = head[iakioi]; i; i = _[i].next) {
    ykb++;
  }
  bool have[ykb + 3];
  memset(have, 0, sizeof(have));
  for (i = head[iakioi]; i; i = _[i].next) {
    t = fyr(_[i].v);
    if (t <= ykb) {
      have[t] = 1;
    }
  }
  for (i = 0; have[i]; i++) {
  }
  zyl[iakioi] = i;
  return i;
}
int main() {
  memset(zyl, -1, sizeof(zyl));
  int n, m, i, A, B, ykb, maxzyl = 0, maxid, win = -1;
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    scanf("%d", a + i);
  }
  for (i = 0; i < m; i++) {
    scanf("%d %d", &A, &B);
    _[tot].v = B;
    _[tot].next = head[A];
    head[A] = tot++;
  }
  for (i = 1; i <= n; i++) {
    ykb = fyr(i);
    yihuo[ykb] ^= a[i];
    if (ykb > maxzyl) {
      maxzyl = ykb;
      maxid = i;
    }
  }
  for (i = maxzyl; i >= 0; i--) {
    if (yihuo[i]) {
      win = i;
      break;
    }
  }
  if (win < 0) {
    cout << "LOSE";
    return 0;
  }
  for (i = 1; i <= n; i++) {
    if (zyl[i] == win && (yihuo[zyl[i]] ^ a[i]) < a[i]) {
      a[i] ^= yihuo[zyl[i]];
      win = i;
      break;
    }
  }
  for (i = head[win]; i; i = _[i].next) {
    if (!qwer[zyl[_[i].v]]) {
      a[_[i].v] ^= yihuo[zyl[_[i].v]];
      qwer[zyl[_[i].v]] = 1;
    }
  }
  cout << "WIN" << endl;
  for (i = 1; i <= n; i++) {
    cout << a[i] << " ";
  }
  return 0;
}
