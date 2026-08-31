#include <bits/stdc++.h>
using namespace std;
void getre() {
  int x = 0;
  printf("%d\n", 1 / x);
}
void gettle() {
  int res = 1;
  while (1) res <<= 1;
  printf("%d\n", res);
}
template <typename T, typename S>
inline bool upmin(T &a, const S &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T, typename S>
inline bool upmax(T &a, const S &b) {
  return a < b ? a = b, 1 : 0;
}
template <typename N, typename PN>
inline N flo(N a, PN b) {
  return a >= 0 ? a / b : -((-a - 1) / b) - 1;
}
template <typename N, typename PN>
inline N cei(N a, PN b) {
  return a > 0 ? (a - 1) / b + 1 : -(-a / b);
}
template <typename N>
N gcd(N a, N b) {
  return b ? gcd(b, a % b) : a;
}
template <typename N>
inline int sgn(N a) {
  return a > 0 ? 1 : (a < 0 ? -1 : 0);
}
inline void gn(long long &x) {
  int sg = 1;
  char c;
  while (((c = getchar()) < '0' || c > '9') && c != '-')
    ;
  c == '-' ? (sg = -1, x = 0) : (x = c - '0');
  while ((c = getchar()) >= '0' && c <= '9') x = x * 10 + c - '0';
  x *= sg;
}
inline void gn(int &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(unsigned long long &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline void gn(long double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline void gs(char *s) { scanf("%s", s); }
inline void gc(char &c) {
  while ((c = getchar()) > 126 || c < 33)
    ;
}
inline void pc(char c) { putchar(c); }
inline long long sqr(long long a) { return a * a; }
inline double sqrf(double a) { return a * a; }
const int inf = 0x3f3f3f3f;
const double pi = 3.14159265358979323846264338327950288L;
const double eps = 1e-6;
const int mo = 1;
int qp(int a, long long b) {
  int n = 1;
  do {
    if (b & 1) n = 1ll * n * a % mo;
    a = 1ll * a * a % mo;
  } while (b >>= 1);
  return n;
}
int sg[555];
int num[555];
int tot = 0;
int n;
int main() {
  sg[++tot] = 1;
  char c;
  while (gc(c), c != '=') {
    if (c == '?')
      continue;
    else
      sg[++tot] = c == '+' ? 1 : -1;
  }
  gn(n);
  int suma = 0, sumi = 0;
  for (int i = (1), _ed = (tot + 1); i < _ed; i++) {
    if (sg[i] == 1)
      suma += n, sumi += 1;
    else
      suma -= 1, sumi -= n;
  }
  if (n >= sumi && n <= suma) {
    printf("Possible\n");
    for (int i = (1), _ed = (tot + 1); i < _ed; i++)
      if (sg[i] == 1)
        num[i] = n;
      else
        num[i] = 1;
    int cur = suma;
    while (cur > n) {
      for (int i = (1), _ed = (tot + 1); i < _ed; i++)
        if (sg[i] == 1 && num[i] > 1) {
          int del = min(cur - n, num[i] - 1);
          num[i] -= del;
          cur -= del;
        } else if (sg[i] == -1 && num[i] < n) {
          int del = min(cur - n, n - num[i]);
          num[i] += del;
          cur -= del;
        }
    }
    for (int i = (1), _ed = (tot + 1); i < _ed; i++) {
      if (i > 1) printf(" %c ", sg[i] == 1 ? '+' : '-');
      printf("%d", num[i]);
    }
    printf(" = %d\n", n);
  } else {
    printf("Impossible\n");
  }
  return 0;
}
