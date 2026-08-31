#include <bits/stdc++.h>
using namespace std;
bool SR(int &_x) { return scanf("%d", &_x) == 1; }
bool SR(long long &_x) { return scanf("%" PRId64, &_x) == 1; }
bool SR(double &_x) { return scanf("%lf", &_x) == 1; }
bool SR(char *_s) { return scanf("%s", _s) == 1; }
bool RI() { return true; }
template <typename I, typename... T>
bool RI(I &_x, T &..._tail) {
  return SR(_x) && RI(_tail...);
}
void SP(const int _x) { printf("%d", _x); }
void SP(const long long _x) { printf("%" PRId64, _x); }
void SP(const double _x) { printf("%.16lf", _x); }
void SP(const char *s) { printf("%s", s); }
void PL() { puts(""); }
template <typename I, typename... T>
void PL(const I _x, const T... _tail) {
  SP(_x);
  if (sizeof...(_tail)) putchar(' ');
  PL(_tail...);
}
const int maxn = 5e3 + 3;
const int INF = 1e8 + 888;
struct Seg1 {
  int sh[maxn << 2], ga[maxn << 2];
  void eat(int x, char op, int val) {
    if (op == 's') {
      sh[x] += val;
      ga[x] += val;
    } else if (op == 'g') {
      ga[x] = min(ga[x], val);
    } else
      assert(0);
  }
  void init(int x, int low, int high) {
    sh[x] = 0;
    ga[x] = INF;
    if (low == high) return;
    int mid = (low + high) / 2;
    init(x << 1, low, mid);
    init(x << 1 | 1, mid + 1, high);
  }
  void push(int x) {
    eat(x << 1, 's', sh[x]);
    eat(x << 1 | 1, 's', sh[x]);
    eat(x << 1, 'g', ga[x]);
    eat(x << 1 | 1, 'g', ga[x]);
    sh[x] = 0;
    ga[x] = INF;
  }
  void fix(int x, int low, int high, int a, int b, char op, int v) {
    if (low == a && b == high) {
      eat(x, op, v);
      return;
    }
    int mid = (low + high) / 2;
    push(x);
    if (b <= mid)
      fix(x << 1, low, mid, a, b, op, v);
    else if (mid + 1 <= a)
      fix(x << 1 | 1, mid + 1, high, a, b, op, v);
    else
      fix(x << 1, low, mid, a, mid, op, v),
          fix(x << 1 | 1, mid + 1, high, mid + 1, b, op, v);
  }
  void print(int x, int low, int high, int *a) {
    if (low == high) {
      a[low] = ga[x] - sh[x];
      return;
    }
    int mid = (low + high) / 2;
    push(x);
    print(x << 1, low, mid, a);
    print(x << 1 | 1, mid + 1, high, a);
  }
} seg1;
struct Seg2 {
  int tag[maxn << 2], hi[maxn << 2];
  void push(int x) {
    tag[x << 1] += tag[x];
    tag[x << 1 | 1] += tag[x];
    hi[x << 1] += tag[x];
    hi[x << 1 | 1] += tag[x];
    tag[x] = 0;
  }
  void pull(int x) { hi[x] = max(hi[x << 1], hi[x << 1 | 1]); }
  void init(int x, int low, int high, int *a) {
    tag[x] = 0;
    if (low == high) {
      hi[x] = a[low];
      return;
    }
    int mid = (low + high) / 2;
    init(x << 1, low, mid, a);
    init(x << 1 | 1, mid + 1, high, a);
    pull(x);
  }
  void add(int x, int low, int high, int a, int b, int v) {
    if (low == a && b == high) {
      tag[x] += v;
      hi[x] += v;
      return;
    }
    int mid = (low + high) / 2;
    push(x);
    if (b <= mid)
      add(x << 1, low, mid, a, b, v);
    else if (mid + 1 <= a)
      add(x << 1 | 1, mid + 1, high, a, b, v);
    else
      add(x << 1, low, mid, a, mid, v),
          add(x << 1 | 1, mid + 1, high, mid + 1, b, v);
    pull(x);
  }
  int ask(int x, int low, int high, int a, int b) {
    if (low == a && b == high) return hi[x];
    int mid = (low + high) / 2;
    push(x);
    int ret = 0;
    if (b <= mid)
      ret = ask(x << 1, low, mid, a, b);
    else if (mid + 1 <= a)
      ret = ask(x << 1 | 1, mid + 1, high, a, b);
    else
      ret = max(ask(x << 1, low, mid, a, mid),
                ask(x << 1 | 1, mid + 1, high, mid + 1, b));
    pull(x);
    return ret;
  }
} seg2;
int n, m;
int op[maxn], l[maxn], r[maxn], v[maxn];
void read() {
  RI(n, m);
  for (int i = (1); i <= int(m); i++) RI(op[i], l[i], r[i], v[i]);
}
int a[maxn];
void build() {
  seg1.init(1, 1, n);
  for (int i = (1); i <= int(m); i++)
    seg1.fix(1, 1, n, l[i], r[i], " sg"[op[i]], v[i]);
  seg1.print(1, 1, n, a);
}
void sol() {
  seg2.init(1, 1, n, a);
  for (int i = (1); i <= int(m); i++) {
    if (op[i] == 1)
      seg2.add(1, 1, n, l[i], r[i], v[i]);
    else {
      if (seg2.ask(1, 1, n, l[i], r[i]) != v[i]) {
        PL("NO");
        return;
      }
    }
  }
  PL("YES");
  for (int i = (1); i <= int(n); i++) printf("%d%c", a[i], " \n"[i == n]);
}
int main() {
  read();
  build();
  sol();
  return 0;
}
