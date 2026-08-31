#include <bits/stdc++.h>
double const EPS = 3e-8;
using namespace std;
template <class T>
T gcd(T a, T b) {
  return (b != 0 ? gcd<T>(b, a % b) : a);
}
template <class T>
T lcm(T a, T b) {
  return (a / gcd<T>(a, b) * b);
}
template <class T>
inline bool read(T &x) {
  int c = getchar();
  int sgn = 1;
  while (~c && c < '0' || c > '9') {
    if (c == '-') sgn = -1;
    c = getchar();
  }
  for (x = 0; ~c && '0' <= c && c <= '9'; c = getchar()) x = x * 10 + c - '0';
  x *= sgn;
  return ~c;
}
const int MX = 1e5 + 10;
int inp[3][MX];
int main() {
  map<int, int> ID, prst;
  int n = ({
    int a;
    read(a);
    a;
  });
  for (__typeof((n)-1) i = (0); i <= (n)-1; ++i) {
    inp[0][i] = ({
      int a;
      read(a);
      a;
    });
    prst[inp[0][i]]++;
  }
  for (__typeof((n - 1) - 1) i = (0); i <= (n - 1) - 1; ++i) {
    inp[1][i] = ({
      int a;
      read(a);
      a;
    });
    prst[inp[1][i]]--;
  }
  for (__typeof((n)-1) i = (0); i <= (n)-1; ++i) {
    if (prst[inp[0][i]] == 1) {
      prst[inp[0][i]]--;
      cout << inp[0][i] << endl;
      break;
    }
  }
  for (__typeof((n - 1) - 1) i = (0); i <= (n - 1) - 1; ++i) {
    prst[inp[1][i]]++;
  }
  for (__typeof((n - 2) - 1) i = (0); i <= (n - 2) - 1; ++i) {
    inp[2][i] = ({
      int a;
      read(a);
      a;
    });
    prst[inp[2][i]]--;
  }
  for (__typeof((n - 1) - 1) i = (0); i <= (n - 1) - 1; ++i) {
    if (prst[inp[1][i]] == 1) {
      prst[inp[1][i]]--;
      cout << inp[1][i] << endl;
      break;
    }
  }
  return 0;
}
