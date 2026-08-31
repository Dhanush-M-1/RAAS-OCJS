#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
int n;
set<int> all;
struct d {
  map<int, int> v;
  int &operator[](int x) { return v[x]; }
  void init(int x) {
    for (int i = 2; i * i <= x; i++)
      if (x % i == 0) {
        int cnt = 0;
        while (x % i == 0) cnt++, x /= i;
        v[i] = cnt;
        all.insert(i);
      }
    if (x > 1) {
      v[x] = 1;
      all.insert(x);
    }
  }
  bool operator!=(d b) {
    for (set<int>::iterator it = all.begin(); it != all.end(); it++)
      if (v[*it] != b[*it]) return 1;
    return 0;
  }
};
long long gcd(long long a, long long b) { return (b ? gcd(b, a % b) : a); }
int trs(d &a) {
  int g = 0;
  for (map<int, int>::iterator it = a.v.begin(); it != a.v.end(); it++)
    g = gcd(g, it->second);
  if (g)
    for (map<int, int>::iterator it = a.v.begin(); it != a.v.end(); it++)
      it->second /= g;
  return g;
}
d a[105], b[105];
inline int power(int x, long long y) {
  int z = 1;
  while (y) {
    if (y & 1) z = 1ll * z * x % mod;
    x = 1ll * x * x % mod;
    y >>= 1;
  }
  return z;
}
namespace unsame {
void chk(d a0, d a1, d b0, d b1) {
  int aa, bb, cc;
  bool ok = 0;
  int x, y;
  for (set<int>::iterator it = all.begin(); it != all.end(); it++) {
    int ta = b0[*it];
    int tb = -b1[*it];
    int tc = a0[*it] - a1[*it];
    if (ta || tb || tc) {
      if (!ta || !tb) {
        if (!ta && !tb) {
          puts("-1");
          return;
        }
        if (!ta) {
          x = -tc / tb;
          if (x < 0 || tc % tb) {
            puts("-1");
            return;
          }
          swap(a0, b0);
        } else {
          x = -tc / ta;
          if (x < 0 || tc % ta) {
            puts("-1");
            return;
          }
        }
        break;
      }
      int g = gcd(gcd(ta, tb), tc);
      ta /= g;
      tb /= g;
      tc /= g;
      if (ok && (ta != aa || tb != bb || tc != cc)) {
        int t = ta * bb - tb * aa;
        if (!t) {
          puts("-1");
          return;
        }
        int w = aa * tc - ta * cc;
        y = w / t;
        if (y < 0 || y * t != w) {
          puts("-1");
          return;
        }
        w = tb * cc - bb * tc;
        x = w / t;
        if (x < 0 || x * t != w) {
          puts("-1");
          return;
        }
        break;
      } else {
        aa = ta;
        bb = tb;
        cc = tc;
        ok = 1;
      }
    }
  }
  d r;
  for (set<int>::iterator it = all.begin(); it != all.end(); it++)
    r[*it] = a0[*it] + x * b0[*it];
  for (int i = 1; i <= n; i++) {
    int p = -1;
    for (set<int>::iterator it = all.begin(); it != all.end(); it++) {
      if (b[i][*it]) {
        int t = (r[*it] - a[i][*it]) / b[i][*it];
        if (t * b[i][*it] + a[i][*it] != r[*it]) {
          puts("-1");
          return;
        }
        if (p == -1) p = t;
        if (t != p) {
          puts("-1");
          return;
        }
      } else {
        if (r[*it] != a[i][*it]) {
          puts("-1");
          return;
        }
      }
    }
  }
  int res = 1;
  for (set<int>::iterator it = all.begin(); it != all.end(); it++) {
    res = 1ll * res * power(*it, r[*it]) % mod;
  }
  printf("%d\n", res);
}
}  // namespace unsame
namespace same {
int k[105], c[105];
int T(d &a, d &b) {
  int mn = 1e9;
  for (set<int>::iterator it = all.begin(); it != all.end(); it++)
    if (b[*it]) {
      mn = min(mn, a[*it] / b[*it]);
    }
  for (set<int>::iterator it = all.begin(); it != all.end(); it++)
    if (b[*it]) {
      a[*it] -= mn * b[*it];
    }
  return mn;
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b)
    return x = 1, y = 0, a;
  else {
    long long d = exgcd(b, a % b, y, x);
    y -= a / b * x;
    return d;
  }
}
inline long long mul(long long x, long long y, long long mod) {
  long long z = 0;
  while (y) {
    if (y & 1) z = (z + x) % mod;
    x = (x + x) % mod;
    y >>= 1;
  }
  return z;
}
void work() {
  for (int i = 1; i <= n; i++) c[i] = T(a[i], b[i]);
  for (int i = 2; i <= n; i++)
    if (a[i] != a[1]) {
      puts("-1");
      exit(0);
    }
  long long tk = k[1], tc = c[1];
  if (tk) {
    for (int i = 2; i <= n; i++) {
      long long C = k[i], D = c[i], v = ((tc - c[i]) % tk + tk) % tk, x, y, dd,
                aa = tk, t2;
      dd = exgcd(tk, C, x, y);
      if (v % dd) {
        puts("-1");
        return;
      }
      v /= dd;
      aa /= dd;
      t2 = (mul(y, v, aa) + aa) % aa;
      if (C * t2 + D < tc) t2 += (tc - D - C * t2 + C * aa - 1) / (C * aa) * aa;
      tc = t2 * C + D;
      tk = tk / dd * C;
    }
  }
  int res = 1;
  for (map<int, int>::iterator it = a[1].v.begin(); it != a[1].v.end(); it++)
    if (it->second) {
      res = 1ll * res * power(it->first, it->second) % mod;
    }
  for (map<int, int>::iterator it = b[1].v.begin(); it != b[1].v.end(); it++)
    if (it->second) {
      res = 1ll * res * power(it->first, it->second * tc) % mod;
    }
  printf("%d\n", res);
}
}  // namespace same
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[i].init(x);
    b[i].init(y);
  }
  for (int i = 1; i <= n; i++) same::k[i] = trs(b[i]);
  for (int i = 2; i <= n; i++) {
    if (b[1] != b[i]) {
      for (int i = 1; i <= n; i++)
        for (map<int, int>::iterator it = b[i].v.begin(); it != b[i].v.end();
             it++)
          it->second *= same::k[i];
      unsame::chk(a[1], a[i], b[1], b[i]);
      return 0;
    }
  }
  same::work();
  return 0;
}
