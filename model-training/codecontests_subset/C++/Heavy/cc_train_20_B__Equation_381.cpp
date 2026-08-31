#include <bits/stdc++.h>
using namespace std;
bool SR(int &x) { return scanf("%d", &x) == 1; }
bool SR(long long &x) { return scanf("%lld", &x) == 1; }
bool SR(double &x) { return scanf("%lf", &x) == 1; }
bool SR(char *s) { return scanf("%s", s) == 1; }
bool RI() { return true; }
template <typename I, typename... T>
bool RI(I &x, T &...tail) {
  return SR(x) && RI(tail...);
}
void SP(const int x) { printf("%d", x); }
void SP(const long long x) { printf("%lld", x); }
void SP(const double x) { printf("%.16lf", x); }
void SP(const char *s) { printf("%s", s); }
void PL() { puts(""); }
template <typename I, typename... T>
void PL(const I x, const T... tail) {
  SP(x);
  if (sizeof...(tail)) putchar(' ');
  PL(tail...);
}
int ar[3];
void read() {
  for (int i = 0; i < int(3); i++) RI(ar[i]);
}
void build() {}
void sol0(int a) {
  if (a == 0)
    PL(-1);
  else
    PL(0);
}
void sol1(int a, int b) {
  PL(1);
  PL((0.0 - b) / a);
}
void sol2(long long a, long long b, long long c) {
  long long d = b * b - 4 * a * c;
  if (d < 0)
    PL(0);
  else if (d == 0) {
    PL(1);
    PL((0.0 - b) / (2 * a));
  } else {
    double p = sqrt(d);
    vector<double> v;
    v.push_back((-b + p) / (2 * a));
    v.push_back((-b - p) / (2 * a));
    sort(begin(v), end(v));
    PL(2);
    for (auto x : v) PL(x);
  }
}
void sol() {
  if (ar[0] == 0 && ar[1] == 0)
    sol0(ar[2]);
  else if (ar[0] == 0)
    sol1(ar[1], ar[2]);
  else
    sol2(ar[0], ar[1], ar[2]);
}
int main() {
  read();
  build();
  sol();
  return 0;
}
