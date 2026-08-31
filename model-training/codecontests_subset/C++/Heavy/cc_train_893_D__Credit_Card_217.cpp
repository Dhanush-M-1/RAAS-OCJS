#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
const int MAX_N = 1e5 + 5;
int n;
long long d;
long long a[MAX_N], rec[MAX_N];
long long add[MAX_N << 2];
long long ma[MAX_N << 2];
void pushUp(int rt) { ma[rt] = max(ma[rt << 1], ma[rt << 1 | 1]); }
void pushDown(int rt) {
  if (add[rt]) {
    add[rt << 1] += add[rt];
    add[rt << 1 | 1] += add[rt];
    ma[rt << 1] += add[rt];
    ma[rt << 1 | 1] += add[rt];
    add[rt] = 0;
  }
}
void build(int l, int r, int rt) {
  add[rt] = 0;
  if (l == r) {
    ma[rt] = rec[l];
    return;
  }
  int m = (l + r) >> 1;
  build(l, m, rt << 1);
  build(m + 1, r, rt << 1 | 1);
  pushUp(rt);
}
void update(int L, int R, int c, int l, int r, int rt) {
  if (L <= l && r <= R) {
    add[rt] += c;
    ma[rt] += c;
    return;
  }
  pushDown(rt);
  int m = (l + r) >> 1;
  if (L <= m) update(L, R, c, l, m, rt << 1);
  if (m < R) update(L, R, c, m + 1, r, rt << 1 | 1);
  pushUp(rt);
}
long long query(int L, int R, int l, int r, int rt) {
  if (L <= l && r <= R) return ma[rt];
  pushDown(rt);
  int m = (l + r) >> 1;
  long long ret = -0x7fffffff;
  if (L <= m) ret = max(ret, query(L, R, l, m, rt << 1));
  if (m < R) ret = max(ret, query(L, R, m + 1, r, rt << 1 | 1));
  return ret;
}
int main() {
  scanf("%d%lld", &n, &d);
  for (int i = (1), _end_ = (n + 1); i < _end_; ++i) scanf("%lld", &a[i]);
  for (int i = (1), _end_ = (n + 1); i < _end_; ++i) rec[i] = rec[i - 1] + a[i];
  build(1, n, 1);
  int cnt = 0;
  bool flag = true;
  long long mav = query(1, n, 1, n, 1);
  if (mav > d) flag = false;
  if (flag)
    for (int i = (1), _end_ = (n + 1); i < _end_; ++i) {
      if (a[i] == 0) {
        long long tmp = query(i, i, 1, n, 1);
        if (tmp >= 0) continue;
        cnt++;
        long long mav = query(i, n, 1, n, 1);
        if (mav > d) {
          flag = false;
          break;
        }
        if (tmp + d - mav < 0) {
          flag = false;
          break;
        }
        update(i, n, d - mav, 1, n, 1);
      }
    }
  if (flag) {
    printf("%d\n", cnt);
  } else
    puts("-1");
  return 0;
}
