#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
const int MAXN = 100;
const int MAXVAL = 1000000000;
const int MAXSQRTVAL = 31622;
const int MOD = 1000000007;
void print(const vector<pair<int, int> > &a) {
  printf("(");
  if (((int)(a).size()) == 0) printf("1");
  for (int i = (0); i < (((int)(a).size())); ++i) {
    if (i != 0) printf("*");
    printf("%d", a[i].first);
    if (a[i].second != 1) printf("^%d", a[i].second);
  }
  printf(")");
}
int n;
int aa[MAXN], bb[MAXN];
vector<pair<int, int> > a[MAXN], b[MAXN];
bool isp[MAXSQRTVAL + 1];
int p[MAXSQRTVAL + 1], np;
long long modpow(long long a, long long n) {
  if (n == 0) return 1;
  if (n % 2 == 1) return a * modpow(a, n - 1) % MOD;
  return modpow(a * a % MOD, n / 2);
}
vector<pair<int, int> > getpp(int x) {
  vector<pair<int, int> > ret;
  for (int i = 0; p[i] * p[i] <= x; ++i)
    if (x % p[i] == 0) {
      ret.push_back(make_pair(p[i], 1));
      x /= p[i];
      while (x % p[i] == 0) ++ret[((int)(ret).size()) - 1].second, x /= p[i];
    }
  if (x != 1) ret.push_back(make_pair(x, 1));
  return ret;
}
long long egcd(long long a, long long b, long long &n, long long &m) {
  if (b == 0) {
    n = 1, m = 0;
    return a;
  }
  long long g = egcd(b, a % b, m, n);
  m = -m - n * (a / b);
  n = -n;
  return g;
}
const int ARG = 0;
const int RES = 1;
bool _insersect(pair<long long, long long> &a, pair<long long, long long> &b,
                int mode) {
  if (a.second == 0 && b.second == 0) {
    bool ret = a.first == b.first;
    if (mode == ARG) a = b = make_pair(-1, -1);
    return ret;
  }
  if (a.second == 0) {
    bool ret = a.first >= b.first && (a.first - b.first) % b.second == 0;
    if (mode == ARG)
      a = make_pair(0, 1), b = make_pair((a.first - b.first) / b.second, 0LL);
    return ret;
  }
  if (b.second == 0) {
    bool ret = b.first >= a.first && (b.first - a.first) % a.second == 0;
    if (mode == ARG)
      a = make_pair((b.first - a.first) / a.second, 0LL), b = make_pair(0, 1);
    else
      a = b;
    return ret;
  }
  long long n, m;
  long long g = egcd(a.second, b.second, n, m);
  if ((b.first - a.first) % g != 0) return false;
  long long times = (b.first - a.first) / g;
  n *= times, m *= times;
  long long aa = a.second / g, bb = b.second / g;
  if (n < 0) {
    long long x = (-n + bb - 1) / bb;
    n += bb * x;
    m += aa * x;
  }
  if (m < 0) {
    long long x = (-m + aa - 1) / aa;
    n += bb * x;
    m += aa * x;
  }
  if (n >= bb && m >= aa) {
    long long x = min(n / bb, m / aa);
    n -= bb * x;
    m -= aa * x;
  }
  if (mode == ARG)
    a = make_pair(n, bb), b = make_pair(m, aa);
  else
    a.first += a.second * n, a.second *= bb;
  return true;
}
bool intersect(pair<long long, long long> &a, pair<long long, long long> &b,
               int mode) {
  bool ret = _insersect(a, b, mode);
  return ret;
}
bool _combine(pair<long long, long long> &n, pair<long long, long long> &m,
              const pair<long long, long long> &a,
              const pair<long long, long long> &b) {
  if (a.first == -1 && a.second == -1 && b.first == -1 && b.second == -1)
    return true;
  ;
  if (n.first == -1 && n.second == -1 && m.first == -1 && m.second == -1) {
    n = a, m = b;
    return true;
  }
  if (b.second * n.second == a.second * m.second) {
    if (n.first * b.second - m.first * a.second !=
        a.first * b.second - b.first * a.second)
      return false;
    if (n.first * m.second - m.first * n.second !=
        a.first * m.second - b.first * n.second)
      return false;
    if (n.second == 0) {
      if (a.second == 0) {
        if (n.first != a.first) return false;
        if (m.second == 0) {
          if (b.second == 0) {
            if (m.first != b.first) return false;
            n = n, m = m;
          } else {
            if (m.first - b.first < 0 || (m.first - b.first) % b.second != 0)
              return false;
            n = n, m = m;
          }
        } else {
          if (b.second == 0) {
            if (b.first - m.first < 0 || (b.first - m.first) % m.second != 0)
              return false;
            m.first = b.first;
            m.second = 0;
          } else {
            long long x = b.first - m.first;
            long long p, q, g;
            g = egcd(m.second, b.second, p, q);
            if (x % g != 0) return false;
            long long bb = b.second / g, mm = m.second / g, xx = x / g;
            p *= xx, q *= xx;
            if (p < 0) {
              long long x = (-p + bb - 1) / bb;
              p += x * bb, q += x * mm;
            }
            if (q < 0) {
              long long x = (-q + mm - 1) / mm;
              p += x * bb, q += x * mm;
            }
            if (p >= bb && q >= mm) {
              long long x = min(p / bb, q / mm);
              p -= x * bb, q -= x * mm;
            }
            m.first += p * m.second;
            m.second *= bb;
          }
        }
      } else {
        assert(m.second == 0);
        if (n.first - a.first < 0 || (n.first - a.first) % a.second != 0)
          return false;
        if (b.second == 0 && b.first != m.first) return false;
        if (b.second != 0 &&
            (m.first - b.first < 0 || (m.first - b.first) % b.second != 0))
          return false;
        n = n, m = m;
      }
    } else {
      if (a.second == 0) {
        assert(b.second == 0);
        if (a.first - n.first < 0 || (a.first - n.first) % n.second != 0)
          return false;
        if (m.second == 0 && m.first != b.first) return false;
        if (m.second != 0 &&
            (b.first - m.first < 0 || (b.first - m.first) % m.second != 0))
          return false;
        n.first = a.first;
        n.second = 0;
        m.first = b.first;
        m.second = 0;
      } else {
        long long x = a.first - n.first;
        long long p, q, g;
        g = egcd(n.second, a.second, p, q);
        if (x % g != 0) return false;
        long long aa = a.second / g, nn = n.second / g, xx = x / g;
        p *= xx, q *= xx;
        if (p < 0) {
          long long x = (-p + aa - 1) / aa;
          p += x * aa, q += x * nn;
        }
        if (q < 0) {
          long long x = (-q + nn - 1) / nn;
          p += x * aa, q += x * nn;
        }
        if (p >= aa && q >= nn) {
          long long x = min(p / aa, q / nn);
          p -= x * aa, q -= x * nn;
        }
        n.first += p * n.second;
        n.second *= aa;
        m.first += p * m.second;
        m.second *= aa;
      }
    }
  } else {
    long long num1 =
        (m.first - b.first) * a.second + (a.first - n.first) * b.second;
    long long num2 =
        (m.first - b.first) * n.second + (a.first - n.first) * m.second;
    long long den = b.second * n.second - a.second * m.second;
    if (num1 % den != 0 || num2 % den != 0) return false;
    long long p = num1 / den, q = num2 / den;
    if (p < 0 || q < 0) return false;
    n.first += p * n.second;
    n.second = 0;
    m.first += p * m.second;
    m.second = 0;
  }
  return true;
}
bool combine(pair<long long, long long> &n, pair<long long, long long> &m,
             const pair<long long, long long> &a,
             const pair<long long, long long> &b) {
  bool ret = _combine(n, m, a, b);
  return ret;
}
bool calc(const vector<pair<int, int> > &a0, const vector<pair<int, int> > &b0,
          const vector<pair<int, int> > &a1, const vector<pair<int, int> > &b1,
          pair<long long, long long> &res) {
  int i0 = 0, j0 = 0, i1 = 0, j1 = 0;
  pair<long long, long long> n = make_pair(-1, -1), m = make_pair(-1, -1);
  while (true) {
    int cur = INT_MAX;
    if (i0 < ((int)(a0).size()) && a0[i0].first < cur) cur = a0[i0].first;
    if (j0 < ((int)(b0).size()) && b0[j0].first < cur) cur = b0[j0].first;
    if (i1 < ((int)(a1).size()) && a1[i1].first < cur) cur = a1[i1].first;
    if (j1 < ((int)(b1).size()) && b1[j1].first < cur) cur = b1[j1].first;
    if (cur == INT_MAX) break;
    pair<long long, long long> a, b;
    if (i0 < ((int)(a0).size()) && a0[i0].first == cur)
      a.first = a0[i0++].second;
    if (j0 < ((int)(b0).size()) && b0[j0].first == cur)
      a.second = b0[j0++].second;
    if (i1 < ((int)(a1).size()) && a1[i1].first == cur)
      b.first = a1[i1++].second;
    if (j1 < ((int)(b1).size()) && b1[j1].first == cur)
      b.second = b1[j1++].second;
    if (!intersect(a, b, ARG)) return false;
    if (!combine(n, m, a, b)) return false;
  }
  res = n;
  return true;
}
void run() {
  for (int i = (0); i <= (MAXSQRTVAL); ++i) isp[i] = true;
  isp[0] = isp[1] = false;
  for (int i = 2; i * i <= MAXSQRTVAL; ++i)
    if (isp[i])
      for (int j = i * i; j <= MAXSQRTVAL; j += i) isp[j] = false;
  np = 0;
  for (int i = (0); i <= (MAXSQRTVAL); ++i)
    if (isp[i]) p[np++] = i;
  scanf("%d", &n);
  for (int i = (0); i < (n); ++i) scanf("%d%d", &aa[i], &bb[i]);
  for (int i = (0); i < (n); ++i) a[i] = getpp(aa[i]);
  for (int i = (0); i < (n); ++i) b[i] = getpp(bb[i]);
  pair<long long, long long> res = make_pair(0, 1);
  for (int i = (1); i < (n); ++i) {
    pair<long long, long long> cur;
    if (!calc(a[0], b[0], a[i], b[i], cur)) {
      printf("-1\n");
      return;
    }
    if (!intersect(res, cur, RES)) {
      printf("-1\n");
      return;
    }
  }
  int ret = (long long)aa[0] * modpow(bb[0], res.first) % MOD;
  printf("%d\n", ret);
}
int main() {
  run();
  return 0;
}
