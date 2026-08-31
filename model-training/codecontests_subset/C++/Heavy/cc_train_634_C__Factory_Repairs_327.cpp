#include <bits/stdc++.h>
using namespace std;
struct FastReader {
  FastReader operator>>(int &x) const {
    scanf("%d", &x);
    return *this;
  }
  FastReader operator>>(signed long long &x) const {
    scanf("%I64d", &x);
    return *this;
  }
  FastReader operator>>(double &x) const {
    scanf("%lf", &x);
    return *this;
  }
  FastReader operator>>(char &x) const {
    do {
      x = getchar();
    } while (x == ' ' || x == '\n');
    return *this;
  }
  FastReader operator>>(char *x) const {
    scanf("%s", x);
    return *this;
  }
} in;
struct FastWriter {
  FastWriter operator<<(const int x) const {
    printf("%d", x);
    return *this;
  }
  FastWriter operator<<(const signed long long x) const {
    printf("%I64d", x);
    return *this;
  }
  FastWriter operator<<(const double x) const {
    printf("%lf", x);
    return *this;
  }
  FastWriter operator<<(const char x) const {
    putchar(x);
    return *this;
  }
  FastWriter operator<<(const char *x) const {
    printf("%s", x);
    return *this;
  }
  FastWriter operator<<(const string x) const { return operator<<(x.c_str()); }
} out;
template <class T>
T sqr(T x) {
  return x * x;
}
const int N = (int)2e5 + 11;
int n, k, a, b, q;
int t, x, y;
signed long long t1[N * 4], t2[N * 4];
void update1(int v, int l, int r, int i, int x) {
  if (l >= r) return;
  if (l + 1 == r)
    t1[v] = min(t1[v] + x, (signed long long)a);
  else {
    int m = (l + r) / 2;
    if (i < m)
      update1(v * 2 + 1, l, m, i, x);
    else
      update1(v * 2 + 2, m, r, i, x);
    t1[v] = t1[v * 2 + 1] + t1[v * 2 + 2];
  }
}
void update2(int v, int l, int r, int i, int x) {
  if (l >= r) return;
  if (l + 1 == r)
    t2[v] = min(t2[v] + x, (signed long long)b);
  else {
    int m = (l + r) / 2;
    if (i < m)
      update2(v * 2 + 1, l, m, i, x);
    else
      update2(v * 2 + 2, m, r, i, x);
    t2[v] = t2[v * 2 + 1] + t2[v * 2 + 2];
  }
}
signed long long query1(int v, int l, int r, int lq, int rq) {
  if (l >= r || lq >= rq) return 0;
  if (l == lq && r == rq) return t1[v];
  int m = (l + r) / 2;
  signed long long f = query1(v * 2 + 1, l, m, lq, min(rq, m));
  signed long long s = query1(v * 2 + 2, m, r, max(lq, m), rq);
  return f + s;
}
signed long long query2(int v, int l, int r, int lq, int rq) {
  if (l >= r || lq >= rq) return 0;
  if (l == lq && r == rq) return t2[v];
  int m = (l + r) / 2;
  signed long long f = query2(v * 2 + 1, l, m, lq, min(rq, m));
  signed long long s = query2(v * 2 + 2, m, r, max(lq, m), rq);
  return f + s;
}
int main() {
  in >> n >> k >> a >> b >> q;
  int m = n + 2;
  for (int i = 0; i < q; i++) {
    in >> t;
    if (t == 1) {
      in >> x >> y;
      update1(0, 0, m, x, y);
      update2(0, 0, m, x, y);
    } else {
      in >> x;
      signed long long f = query2(0, 0, m, 0, x);
      signed long long s = query1(0, 0, m, x + k, m);
      out << (f + s) << '\n';
    }
  }
  return 0;
}
