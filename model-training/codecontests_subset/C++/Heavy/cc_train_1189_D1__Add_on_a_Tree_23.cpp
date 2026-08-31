#include <bits/stdc++.h>
using namespace std;
int sc(int &x) { return scanf("%d", &x); }
int sc(unsigned int &x) { return scanf("%u", &x); }
int sc(long long &x) { return scanf("%lld", &x); }
int sc(unsigned long long &x) { return scanf("%llu", &x); }
int sc(double &x) { return scanf("%lf", &x); }
int sc(long double &x) { return scanf("%Lf", &x); }
int sc(char *x) { return scanf("%s", x); }
int sc(char &x) { return scanf("%c", &x); }
template <typename T, typename... Args>
void sc(T &v, Args &...args) {
  sc(v);
  sc(args...);
}
void pr(const int &x) { printf("%d", x); }
void pr(const unsigned int &x) { printf("%u", x); }
void pr(const long long &x) { printf("%lld", x); }
void pr(const unsigned long long &x) { printf("%llu", x); }
void pr(const double &x) { printf("%.10lf", x); }
void pr(const long double &x) { printf("%.10Lf", x); }
void pr(const char *const &x) { printf("%s", x); }
void pr(char *const &x) { printf("%s", x); }
void pr(const char &x) { printf("%c", x); }
template <typename T, typename... Args>
void pr(T const &v, Args const &...args) {
  pr(v);
  pr(' ');
  pr(args...);
}
const long long MOD = 1e9 + 7;
inline void _add(long long &a, long long b) { a = (a + b) % MOD; }
inline void _sub(long long &a, long long b) { a = (a + MOD - b) % MOD; }
inline void _mul(long long &a, long long b) { a = (long long)a * b % MOD; }
inline long long _Add(long long a, long long b) { return (a + b) % MOD; }
inline long long _Sub(long long a, long long b) { return (a + MOD - b) % MOD; }
inline long long _Mul(long long a, long long b) { return a * b % MOD; }
int deg[100100], n;
int main() {
  sc(n);
  int u, v;
  for (int i = 1, lim = n - 1; i <= lim; ++i) {
    sc(u, v);
    deg[u]++;
    deg[v]++;
  }
  for (int i = 1, lim = n; i <= lim; ++i) {
    if (deg[i] == 2) {
      pr("NO");
      return 0;
    }
  }
  pr("YES");
  pr("\n");
  return 0;
}
