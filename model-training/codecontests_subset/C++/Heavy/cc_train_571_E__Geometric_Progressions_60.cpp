#include <bits/stdc++.h>
static const long long int mod = 1000000007LL;
using vpair = std::vector<std::pair<int, int> >;
long long int gcd(long long int a, long long int b) {
  while (b != 0) {
    long long int c = a % b;
    a = b, b = c;
  }
  return a;
}
vpair factor(int v) {
  vpair res;
  for (int i = 2; i * i <= v; ++i) {
    if (v % i == 0) {
      int cnt = 0;
      while (v % i == 0) {
        ++cnt;
        v /= i;
      }
      res.emplace_back(i, cnt);
    }
  }
  if (v > 1) res.emplace_back(v, 1);
  return res;
}
std::pair<int, int> simplify(int v) {
  vpair k = factor(v);
  int g = 0;
  for (int i = 0; i < k.size(); ++i) {
    g = gcd(g, k[i].second);
  }
  int a = 1;
  for (int i = 0; i < k.size(); ++i) {
    for (int j = 0; j < k[i].second / g; ++j) a *= k[i].first;
  }
  return std::make_pair(a, g);
}
long long int exgcd(long long int a, long long int b, long long int &c,
                    long long int &d) {
  if (b == 0) {
    c = 1, d = 0;
    return a;
  }
  long long int v = exgcd(b, a % b, d, c);
  d -= c * (a / b);
  return v;
}
long long int mul2(long long int a, long long int b, long long int m) {
  long long int val = 0;
  for (int i = 63; i >= 0; --i) {
    val += val;
    if (((a >> i) & 1) == 1) val += b;
    while (val >= m) val -= m;
  }
  return val;
}
long long int mul3(long long int a, long long int b, long long int c,
                   long long int m) {
  long long int sign = 1;
  if (a < 0) sign = -sign, a = -a;
  if (b < 0) sign = -sign, b = -b;
  if (c < 0) sign = -sign, c = -c;
  return sign * mul2(mul2(a, b, m), c, m);
}
std::pair<long long int, long long int> crt(
    std::pair<long long int, long long int> a,
    std::pair<long long int, long long int> b) {
  long long int p, q;
  long long int v = exgcd(a.first, b.first, p, q);
  if (a.second % v != b.second % v) {
    return std::make_pair(0, 0);
  } else {
    long long int rem = a.second % v;
    long long int k = a.first / v * b.first / v;
    long long int s = mul3(a.second / v, b.first / v, q, k) +
                      mul3(b.second / v, a.first / v, p, k);
    s %= k;
    if (s < 0) s += k;
    return std::make_pair(k * v, s * v + rem);
  }
}
long long int qpow(long long int a, long long int b, long long int m) {
  long long int val = 1;
  for (int i = 60; i >= 0; --i) {
    val = val * val % m;
    if ((b & (1LL << i)) != 0) {
      val = val * a % m;
    }
  }
  return val;
}
typedef int ppair[2][2];
using map = std::map<int, ppair>;
void copy(ppair &a, ppair &b) { memmove(&a, &b, sizeof(ppair)); }
int n;
struct item {
  int A, B;
  int a, b;
  int oa, ob;
} v[103];
int main() {
  scanf("%d", &n);
  long long int oneans = -1;
  for (int i = 0; i < n; ++i) {
    int a, b;
    scanf("%d%d", &a, &b);
    v[i].oa = a;
    v[i].ob = b;
    std::pair<int, int> p = simplify(b);
    v[i].B = p.first;
    v[i].b = p.second;
    if (b != 1) {
      while (a % p.first == 0) {
        ++v[i].a;
        a /= p.first;
      }
      v[i].A = a;
    } else {
      oneans = a;
    }
  }
  if (oneans != -1) {
    for (int i = 0; i < n; ++i) {
      long long int temp = oneans;
      while (temp % v[i].ob == 0) {
        if (temp == v[i].oa) break;
        temp /= v[i].ob;
      }
      if (temp != v[i].oa) {
        printf("-1\n");
        return 0;
      }
    }
    printf("%I64d\n", oneans);
    return 0;
  }
  int j = 1;
  while (j < n && v[j].B == v[0].B) ++j;
  if (j == n) {
    std::pair<long long int, long long int> cur(1, 0);
    long long int min = 0;
    for (int i = 0; i < n; ++i) {
      if (v[i].A != v[0].A) {
        printf("-1\n");
        return 0;
      }
      cur = crt(cur, std::make_pair(v[i].b, v[i].a % v[i].b));
      if (cur.first == 0) {
        printf("-1\n");
        return 0;
      }
      if (v[i].b > min) min = v[i].a;
    }
    cur.second += (min - cur.second + cur.first - 1) / cur.first * cur.first;
    assert(cur.second >= min);
    assert(cur.second - cur.first < min);
    printf("%I64d\n", v[0].A * qpow(v[0].B, cur.second, mod) % mod);
  } else {
    map m;
    std::vector<std::pair<int, int> > f1 = factor(v[0].A);
    for (int i = 0; i < f1.size(); ++i) m[f1[i].first][0][0] = f1[i].second;
    std::vector<std::pair<int, int> > f2 = factor(v[0].B);
    for (int i = 0; i < f2.size(); ++i) m[f2[i].first][0][1] = f2[i].second;
    std::vector<std::pair<int, int> > f3 = factor(v[j].A);
    for (int i = 0; i < f3.size(); ++i) m[f3[i].first][1][0] = f3[i].second;
    std::vector<std::pair<int, int> > f4 = factor(v[j].B);
    for (int i = 0; i < f4.size(); ++i) m[f4[i].first][1][1] = f4[i].second;
    ppair a, b;
    int state = 0;
    for (map::iterator it = m.begin(); it != m.end(); ++it) {
      if (state == 0) {
        if (it->second[0][1] != 0 || it->second[1][1] != 0) {
          copy(a, it->second);
          state = 1;
        }
      } else {
        if ((long long int)a[0][1] * it->second[1][1] !=
            (long long int)a[1][1] * it->second[0][1]) {
          copy(b, it->second);
          state = 2;
          break;
        }
      }
    }
    assert(state == 2);
    long long int xa = ((long long int)a[1][0] - a[0][0]) * b[1][1] -
                       ((long long int)b[1][0] - b[0][0]) * a[1][1],
                  xb = (long long int)a[0][1] * b[1][1] -
                       (long long int)a[1][1] * b[0][1];
    long long int ya = ((long long int)a[0][0] - a[1][0]) * b[0][1] -
                       ((long long int)b[0][0] - b[1][0]) * a[0][1],
                  yb = -xb;
    if (xa % xb != 0 || ya % yb != 0) {
      printf("-1\n");
      return 0;
    }
    long long int x = xa / xb, y = ya / yb;
    std::map<int, int> res;
    for (map::iterator it = m.begin(); it != m.end(); ++it) {
      long long int v1 = it->second[0][0] + it->second[0][1] * x;
      long long int v2 = it->second[1][0] + it->second[1][1] * y;
      if (v1 != v2) {
        printf("-1\n");
        return 0;
      }
      res[it->first] = v1;
    }
    for (int i = 0; i < n; ++i) {
      vpair v1 = factor(v[i].A), v2 = factor(v[i].B);
      std::map<int, std::pair<int, int> > temp;
      for (int k = 0; k < v1.size(); ++k) {
        temp[v1[k].first].first = v1[k].second;
      }
      for (int k = 0; k < v2.size(); ++k) {
        temp[v2[k].first].second = v2[k].second;
      }
      for (std::map<int, int>::iterator it = res.begin(); it != res.end();
           ++it) {
        std::pair<int, int> p = temp[it->first];
        if (p.second == 0) {
          if (it->second == p.first) continue;
          printf("-1\n");
          return 0;
        }
        if ((it->second - p.first) % p.second != 0) {
          printf("-1\n");
          return 0;
        }
        int k = (it->second - p.first) / p.second;
        if (k < v[i].a || (k - v[i].a) % v[i].b != 0) {
          printf("-1\n");
          return 0;
        }
      }
    }
    long long int ans = (long long int)v[0].A * qpow(v[0].B, x, mod) % mod;
    long long int ans2 = (long long int)v[j].A * qpow(v[j].B, y, mod) % mod;
    assert(ans == ans2);
    printf("%I64d\n", ans);
  }
}
