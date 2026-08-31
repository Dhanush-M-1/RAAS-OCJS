#include <bits/stdc++.h>
const int INF = 0x3f3f3f3f;
const long long INF_LL = 9223372036854775807LL;
const double E = exp(1.0);
const double PI = acos(-1.0);
long long gcd(long long a, long long b) {
  while (b ^= a ^= b ^= a %= b)
    ;
  return a;
}
long long lcd(long long a, long long b) { return a * b / gcd(a, b); }
int read() {
  char ch = getchar();
  int x = 0, f = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while ('0' <= ch && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
inline void write(long long x) {
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
void init_cin() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(0);
  std::cout.tie(0);
}
using namespace std;
int main() {
  init_cin();
  int n;
  cin >> n;
  while (n--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    int one = min(c / 2, b);
    b -= one;
    ans += 3 * one;
    one = min(a, b / 2);
    ans += 3 * one;
    cout << ans << endl;
  }
}
