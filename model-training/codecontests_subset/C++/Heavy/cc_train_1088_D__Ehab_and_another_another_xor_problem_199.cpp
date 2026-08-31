#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("unroll-loops")
#pragma GCC target("sse2")
using namespace std;
long long ask(long long c, long long d) {
  long long ret;
  cout << "? " << c << " " << d << endl;
  cin >> ret;
  return ret;
}
void print(long long a, long long b) {
  cout << "! " << a << " " << b << endl;
  exit(0);
}
void sol(long long is, long long a, long long b, long long id) {
  if (id == -1) print(a, b);
  long long cur = 0;
  if (is == 1) {
    cur = ask(a | (1 << id), b | (1 << id));
    if (cur == 1) {
      if (ask(a, b | (1 << id)) == 1) {
        a |= (1 << id);
        b |= (1 << id);
      } else {
      }
      sol(1, a, b, id - 1);
    } else {
      a |= (1 << id);
      sol(ask(a, b), a, b, id - 1);
    }
  } else if (is == 0) {
    for (long long i = id; i >= 0; i--) {
      if (ask(a | (1 << i), b) == -1) {
        a |= (1 << i);
        b |= (1 << i);
      }
    }
    print(a, b);
  } else {
    cur = ask(a | (1 << id), b | (1 << id));
    if (cur == -1) {
      if (ask(a | (1 << id), b) == 1) {
      } else {
        a |= (1 << id);
        b |= (1 << id);
      }
      sol(-1, a, b, id - 1);
    } else {
      b |= (1 << id);
      sol(ask(a, b), a, b, id - 1);
    }
  }
}
signed main() {
  if (ask(0, 0) == 0) {
    long long res = 0;
    for (long long i = 0; i < 30; i++) {
      if (ask(1 << i, 0) == -1) {
        res |= (1 << i);
      }
    }
    print(res, res);
  } else {
    sol(ask(0, 0), 0, 0, 29);
  }
  return 0;
}
