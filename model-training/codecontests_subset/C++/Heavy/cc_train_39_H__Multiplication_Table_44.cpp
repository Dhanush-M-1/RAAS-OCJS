#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 20;
const int MAX = 10000007;
inline long long read() {
  char c = getchar();
  long long x = 0, f = 1;
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = x * 10 + c - '0', c = getchar();
  }
  return x * f;
}
inline void out(int x) {
  if (x > 9) out(x / 10);
  putchar(x % 10 + '0');
}
int k;
int main() {
  k = read();
  for (int i = (1); i <= (k - 1); ++i) {
    for (int j = (1); j <= (k - 1); ++j) {
      int t = i * j;
      int kep = t;
      string s;
      while (kep) {
        s += kep % k + '0';
        kep /= k;
      }
      reverse(s.begin(), s.end());
      cout << s << " ";
    }
    cout << "\n";
  }
  return 0;
}
