#include <bits/stdc++.h>
inline long long minn(long long a, long long b) {
  if (a < b) return a;
  return b;
}
const int MAXN = 2e5 + 5;
const long long INF = 1ll << 60;
int n;
long long mi[MAXN << 2], tag[MAXN << 2];
inline void pushdwn(int k) {
  mi[k << 1] -= tag[k];
  tag[k << 1] += tag[k];
  mi[k << 1 | 1] -= tag[k];
  tag[k << 1 | 1] += tag[k];
  tag[k] = 0;
}
inline void pushup(int k) { mi[k] = minn(mi[k << 1], mi[k << 1 | 1]); }
void bld(int k, int l, int r) {
  if (l == r) {
    scanf("%I64d", mi + k);
    return;
  }
  int mid = l + r >> 1;
  bld(k << 1, l, mid);
  bld(k << 1 | 1, mid + 1, r);
  pushup(k);
  return;
}
int qx, qy, qv;
int Query(int k, int l, int r) {
  if (l == r) return l;
  pushdwn(k);
  int mid = l + r >> 1;
  if (!mi[k << 1 | 1]) return Query(k << 1 | 1, mid + 1, r);
  return Query(k << 1, l, mid);
}
void Modify2(int k, int l, int r) {
  if (l == r) {
    if (mi[k] < 0) mi[k] = INF;
    return;
  }
  pushdwn(k);
  if (mi[k] < 0) {
    int mid = l + r >> 1;
    Modify2(k << 1, l, mid);
    Modify2(k << 1 | 1, mid + 1, r);
    pushup(k);
  }
  return;
}
void Modify(int k, int l, int r) {
  if (qx <= l && r <= qy) {
    mi[k] -= qv;
    tag[k] += qv;
    if (mi[k] < 0) {
      if (l == r) {
        mi[k] = INF;
        return;
      }
      Modify2(k, l, r);
    }
    return;
  }
  pushdwn(k);
  int mid = l + r >> 1;
  if (qx <= mid) Modify(k << 1, l, mid);
  if (mid < qy) Modify(k << 1 | 1, mid + 1, r);
  pushup(k);
  return;
}
int ans[MAXN];
int main() {
  scanf("%d", &n);
  bld(1, 1, n);
  for (int i = 1; i <= n; i++) {
    int t = Query(1, 1, n);
    ans[t] = i;
    qx = t, qy = n, qv = i;
    Modify(1, 1, n);
  }
  for (int i = 1; i <= n; i++) printf("%d%c", ans[i], i == n ? '\n' : ' ');
  return 0;
}
