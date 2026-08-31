#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e4 + 10;
const int maxm = 1e5 + 10;
const int mod = 1e9 + 7;
int a[maxn], a1 = 7, b1 = 7;
int ask(int x, int y) {
  cout << '?' << ' ' << x << ' ' << y << endl;
  fflush(stdout);
  int ans;
  cin >> ans;
  return ans;
}
int main() {
  int tmp, a = 0, b = 0, big;
  tmp = ask(0, 0);
  big = tmp;
  for (int i = 1 << 29; i; i >>= 1) {
    tmp = ask(a | i, b | i);
    if (tmp == 0) {
      if (big == 0) {
        tmp = ask(a | i, b);
        if (tmp == 1) {
          continue;
        } else {
          a |= i;
          b |= i;
        }
        continue;
      }
      a |= i;
      b |= i;
      continue;
    }
    if (tmp != big) {
      if (big > 0) {
        a |= i;
      } else {
        b |= i;
      }
      big = ask(a, b);
      continue;
    }
    tmp = ask(a | i, b);
    if (big > 0) {
      if (tmp != big) {
        b |= i;
        a |= i;
      } else {
        continue;
      }
    } else {
      if (tmp != big) {
        continue;
      } else {
        b |= i;
        a |= i;
      }
    }
  }
  cout << '!' << ' ' << a << ' ' << b << endl;
  fflush(stdout);
  return 0;
}
