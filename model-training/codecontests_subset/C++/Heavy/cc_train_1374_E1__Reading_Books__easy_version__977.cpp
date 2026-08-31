#include <bits/stdc++.h>
using std::max;
using std::min;
const int N = 2e5 + 5, INF = 0x7fffffff;
struct book {
  int id, val, a, b;
  book() {}
  book(int val, int a, int b) : val(val), a(a), b(b) {}
  bool operator<(const book &rhs) const { return val < rhs.val; }
  bool operator>(const book &rhs) const { return val > rhs.val; }
};
template <typename T, typename comp>
struct Heap {
  T hp[N];
  comp cm;
  int cnt;
  Heap() { cnt = 0; }
  void push(T x) {
    hp[cnt++] = x;
    int p = cnt;
    while (((p) >> 1) && cm(hp[p - 1], hp[((p) >> 1) - 1]))
      std::swap(hp[((p) >> 1) - 1], hp[p - 1]), p = ((p) >> 1);
  }
  T pop() {
    T res = hp[0], nr = hp[cnt - 1];
    cnt--;
    hp[0] = nr;
    int p = 1;
    while (((p) << 1) <= cnt) {
      T mns = hp[((p) << 1) - 1];
      int np = ((p) << 1);
      if (((p) << 1 | 1) <= cnt && cm(hp[((p) << 1 | 1) - 1], mns))
        mns = hp[(np = ((p) << 1 | 1)) - 1];
      if (cm(mns, hp[p - 1]))
        std::swap(hp[p - 1], hp[np - 1]), p = np;
      else
        break;
    }
    return res;
  }
  const T top() { return hp[0]; }
  const int size() { return cnt; }
};
bool cmp(const book &x, const book &y) {
  if (x.a != y.a) return x.a < y.a;
  if (x.b != y.b) return x.b < y.b;
  return x.val < y.val;
}
struct H {
  Heap<book, std::greater<book> > tp;
  Heap<book, std::less<book> > bt;
  int tps, bts;
  H() { tps = bts = 0; }
  void push(book x) {
    if (bt.size() && x > bt.top())
      bt.push(x), bts += x.val;
    else
      tp.push(x), tps += x.val;
  }
  int ksum(int k) {
    while (tp.size() < k)
      tps += bt.top().val, bts -= bt.top().val, tp.push(bt.top()), bt.pop();
    while (tp.size() > k)
      bts += tp.top().val, tps -= tp.top().val, bt.push(tp.top()), tp.pop();
    return tps;
  }
  const int size() { return tp.size() + bt.size(); }
};
int main() {
  static book bk[N];
  static H heap;
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= n; i++)
    scanf("%d%d%d", &bk[i].val, &bk[i].a, &bk[i].b), bk[i].id = i;
  std::sort(bk + 1, bk + 1 + n, cmp);
  book *b0 = NULL, *b1 = NULL, *b2 = NULL, *b3 = NULL;
  int n0 = 0, n1 = 0, n2 = 0, n3 = 0;
  for (int i = 1; i <= n; i++) {
    if (bk[i].a == 0 && bk[i].b == 0) n0++;
    if (bk[i].a == 0 && bk[i].b == 1) n1++;
    if (bk[i].a == 1 && bk[i].b == 0) n2++;
    if (bk[i].a == 1 && bk[i].b == 1) n3++;
  }
  b0 = bk;
  b1 = b0 + n0;
  b2 = b1 + n1;
  b3 = b2 + n2;
  int n12 = min(n1, n2);
  int sa = k, sb = 0;
  bool flg = false;
  for (int i = 1; i <= n3; i++) {
    if (0 <= sa && sa <= n12 && 0 <= sb && sb <= n3 && sa * 2 + sb <= m &&
        sa * 2 + sb <= n) {
      flg = true;
      break;
    }
    sa--;
    sb++;
  }
  if (0 <= sa && sa <= n12 && 0 <= sb && sb <= n3 && sa * 2 + sb <= m &&
      sa * 2 + sb <= n)
    flg = true;
  if (!flg) return printf("-1\n"), 0;
  int vans = 0;
  for (int i = 1; i <= sa; i++) vans += b1[i].val + b2[i].val;
  for (int i = 1; i <= sb; i++) vans += b3[i].val;
  for (int i = 1; i <= n0; i++) heap.push(b0[i]);
  for (int i = sa + 1; i <= n1; i++) heap.push(b1[i]);
  for (int i = sa + 1; i <= n2; i++) heap.push(b2[i]);
  int ans = INF, ansi = 0;
  if (heap.size() + sa * 2 + sb >= m)
    ans = vans + heap.ksum(m - sa * 2 - sb), ansi = sb;
  int sbb = sb;
  for (int i = sb + 1, j = sa; i <= n3 && j >= 1; i++, j--) {
    vans += b3[i].val - b1[j].val - b2[j].val;
    heap.push(b1[j]);
    heap.push(b2[j]);
    if (heap.size() + (j - 1) * 2 + i >= m) {
      int na = vans + heap.ksum(m - (j - 1) * 2 - i);
      if (na < ans) ans = na, ansi = i;
    }
    sbb = i;
  }
  for (int i = sbb + 1; i <= n3; i++) {
    vans += b3[i].val;
    if (m >= i && heap.size() + i >= m) {
      int na = vans + heap.ksum(m - i);
      if (na < ans) ans = na, ansi = i;
    }
  }
  printf("%d\n", ans);
  int vv = 0;
  for (int i = 1; i <= ansi; i++) printf("%d ", b3[i].id), vv++;
  for (int i = 1; i <= max(0, k - ansi); i++)
    printf("%d %d ", b1[i].id, b2[i].id), vv += 2;
  static book tmp[N];
  int pp = 0;
  for (int i = 1; i <= n0; i++) tmp[++pp] = b0[i];
  for (int i = max(0, k - ansi) + 1; i <= n1; i++) tmp[++pp] = b1[i];
  for (int i = max(0, k - ansi) + 1; i <= n2; i++) tmp[++pp] = b2[i];
  std::sort(tmp + 1, tmp + 1 + pp);
  for (int i = 1; i <= m - vv; i++) printf("%d ", tmp[i].id);
  return 0;
}
