#include <bits/stdc++.h>
using namespace std;
int dcmp(double a, double b) {
  return ((fabs(a - b) < (1e-9)) ? 0 : (a < b) ? -1 : +1);
}
double crossP(const complex<double> &v1, const complex<double> &v2) {
  return (conj(v1) * v2).imag();
}
double dotP(const complex<double> &v1, const complex<double> &v2) {
  return (conj(v1) * v2).real();
}
double lengthSqr(const complex<double> &p) { return dotP(p, p); }
double length(const complex<double> &p) { return hypot(p.real(), p.imag()); }
double fixAngle(double a) { return ((a > 1) ? 1 : (a < -1) ? -1 : a); }
bool same(const complex<double> &p1, const complex<double> &p2) {
  return ((dcmp(p1.real(), p2.real()) == 0 && dcmp(p1.imag(), p2.imag()) == 0)
              ? 1
              : 0);
}
double getAngle_A_abc(double a, double b, double c) {
  return acos(fixAngle((b * b + c * c - a * a) / (2 * b * c)));
}
const int N = 5e3 + 9, und = 1e9 + 9;
int x[N], y[N], z[N];
struct state {
  int t, l, r, a;
};
state op[N];
int n, m;
bool check() {
  for (__typeof(m) i = 0; i < m; ++i) {
    if (op[i].t == 1)
      for (__typeof(op[i].r + 1) j = op[i].l; j < op[i].r + 1; ++j)
        y[j] += op[i].a;
    else {
      int mx = -(~(1 << 31));
      for (__typeof(op[i].r + 1) j = op[i].l; j < op[i].r + 1; ++j)
        mx = max(mx, y[j]);
      if (mx != op[i].a) return 0;
    }
  }
  return 1;
}
int main() {
  for (__typeof((int)N) i = 0; i < (int)N; ++i) y[i] = und, z[i] = und;
  scanf("%d %d", &n, &m);
  for (__typeof(m) i = 0; i < m; ++i) {
    int t, l, r, a;
    scanf("%d %d %d %d", &t, &l, &r, &a);
    --l, --r;
    op[i].t = t;
    op[i].l = l;
    op[i].r = r;
    op[i].a = a;
    if (t == 1)
      for (__typeof(r + 1) j = l; j < r + 1; ++j) x[j] += a;
    else
      for (__typeof(r + 1) j = l; j < r + 1; ++j)
        y[j] = min(y[j], a - x[j]), z[j] = y[j];
  }
  bool ok = check();
  if (!ok) return puts("NO"), 0;
  puts("YES");
  for (__typeof(n) i = 0; i < n; ++i) printf("%d ", z[i] == und ? 0 : z[i]);
  return 0;
}
