#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using pll = pair<ll, ll>;
using pil = pair<int, ll>;
using pli = pair<ll, int>;
using pii = pair<int, int>;
template <class T>
inline bool Min(T &a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
inline bool Max(T &a, T b) {
  return a < b ? (a = b, true) : false;
}
inline int ni() {
  int a;
  scanf("%d", &a);
  return a;
}
inline void pi(int a) { printf("%d", a); }
inline ll nl() {
  ll a;
  scanf("%lld", &a);
  return a;
}
inline void pl(ll a) { printf("%lld", a); }
inline double nd() {
  double a;
  scanf("%lf", &a);
  return a;
}
inline void pd(double a) { printf("%.8lf", a); }
inline char nc() {
  char a;
  scanf("%c", &a);
  return a;
}
inline void pc(char a) { printf("%c", a); }
inline void ps(string str) { printf("%s", str.c_str()); }
inline void sp() { putchar(' '); }
inline void endl() { putchar('\n'); }
int n, t;
int A[100], B[100];
void ans(int T[]) {
  printf("abs(");
  for (int i = 0; i < (int)(n - 1); ++i) printf("(");
  for (int i = 0; i < (int)(n); ++i) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", T[i] / 2, i, i);
    if (i > 0) printf(")");
    if (i + 1 < n) printf("+");
  }
  putchar(')');
  endl();
}
void solve() {
  n = ni();
  for (int i = 0; i < (int)(n); ++i) A[i] = ni(), B[i] = ni(), t = ni();
  ans(A);
  ans(B);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
