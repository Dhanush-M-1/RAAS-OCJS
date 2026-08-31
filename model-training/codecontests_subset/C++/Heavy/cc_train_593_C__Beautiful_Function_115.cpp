#include <bits/stdc++.h>
using namespace std;
void SR(int &x) { scanf("%d", &x); }
void SR(long long &x) { scanf("%lld", &x); }
void SR(double &x) { scanf("%lf", &x); }
void SR(char *s) { scanf("%s", s); }
void RI() {}
template <typename I, typename... T>
void RI(I &x, T &...tail) {
  SR(x);
  RI(tail...);
}
void SP(const int x) { printf("%d", x); }
void SP(const long long x) { printf("%lld", x); }
void SP(const double x) { printf("%.16lf", x); }
void SP(const char *s) { printf(s); }
void PS() { puts(""); }
template <typename I, typename... T>
void PS(I &x, T &...tail) {
  putchar(' ');
  SP(x);
  PS(tail...);
}
void PL() { puts(""); }
template <typename I, typename... T>
void PL(const I x, const T... tail) {
  SP(x);
  PS(tail...);
}
const int maxn = 52;
int n;
int a[maxn][2], r[maxn];
void read() {
  RI(n);
  for (int i = 0; i < int(n); i++) RI(a[i][0], a[i][1], r[i]);
}
char ans[maxn][2][1003];
void build() {
  for (int i = 0; i < int(n); i++)
    for (int j = 0; j < int(2); j++) a[i][j] -= a[i][j] % 2;
  for (int i = 0; i < int(n); i++)
    for (int j = 0; j < int(2); j++) {
      char *s = ans[i][j];
      sprintf(s, "(%d*(2-abs((abs((t%+d))-abs((t%+d))))))", a[i][j] / 2, -i - 1,
              -i + 1);
    }
}
void print(int i, int j) {
  if (i == 0)
    printf(ans[i][j]);
  else {
    putchar('(');
    print(i - 1, j);
    putchar('+');
    printf(ans[i][j]);
    putchar(')');
  }
}
void sol() {
  print(n - 1, 0);
  PL();
  print(n - 1, 1);
  PL();
}
int main() {
  read();
  build();
  sol();
  return 0;
}
