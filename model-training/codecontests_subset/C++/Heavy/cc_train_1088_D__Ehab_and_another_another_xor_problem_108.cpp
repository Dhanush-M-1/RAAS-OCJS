#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
long long query(long long c, long long d) {
  long long re;
  cout << "? " << c << " " << d << "\n", fflush(stdout);
  cin >> re;
  return re;
}
const long long C = 29;
int main() {
  long long a = 0, b = 0, x, y, z, type;
  x = query(1LL << C, 0), y = query(0, 1LL << C);
  if (x == 1)
    if (y == 1) {
      z = query(0, 0), type = 1;
      if (z == 1)
        a = 1LL << C;
      else
        b = 1LL << C;
    } else
      type = query(0, 0);
  else if (x == -1)
    if (y == -1) {
      z = query(0, 0), type = -1;
      if (z == 1)
        a = 1LL << C;
      else
        b = 1LL << C;
    } else
      a = b = 1LL << C, type = query(0, 0);
  else if (type = 0, y == -1)
    a = b = 1LL << C;
  else if (y == 0) {
    z = query(0, 0);
    if (z == 1)
      a = 1LL << C;
    else
      b = 1LL << C;
  }
  for (long long i = 1LL << (C - 1); i; i >>= 1) {
    x = query(a | i, b);
    y = query(a, b | i);
    if (x == 1)
      if (y == 1) {
        z = type, type = 1;
        if (z == 1)
          a |= i;
        else
          b |= i;
      } else
        ;
    else if (x == -1)
      if (y == -1) {
        z = type, type = -1;
        if (z == 1)
          a |= i;
        else
          b |= i;
      } else
        a |= i, b |= i;
    else if (y == -1)
      a |= i, b |= i, type = 0;
    else if (y == 0) {
      z = type, type = 0;
      if (z == 1)
        a |= i;
      else
        b |= i;
    } else
      type = 0;
  }
  cout << "! " << a << ' ' << b << "\n", fflush(stdout);
}
