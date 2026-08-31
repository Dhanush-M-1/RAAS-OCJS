#include <bits/stdc++.h>
using namespace std;
bool Finish_read;
template <class T>
inline void read(T &x) {
  Finish_read = 0;
  x = 0;
  int f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    if (ch == EOF) return;
    ch = getchar();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x *= f;
  Finish_read = 1;
}
template <class T>
inline void print(T x) {
  if (x / 10 != 0) print(x / 10);
  putchar(x % 10 + '0');
}
template <class T>
inline void writeln(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
  putchar('\n');
}
template <class T>
inline void write(T x) {
  if (x < 0) putchar('-');
  x = abs(x);
  print(x);
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) {
  long long gg = gcd(a, b);
  a /= gg;
  if (a <= LLONG_MAX / b) return a * b;
  return LLONG_MAX;
}
const int maxn = 1e5 + 7;
int n, m;
int main() {
  long long x;
  int n;
  cin >> n;
  while (n--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else
      cout << (r / d + 1) * d << endl;
  }
  return 0;
}
