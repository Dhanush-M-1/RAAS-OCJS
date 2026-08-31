#include <bits/stdc++.h>
using namespace std;
template <typename T, typename S>
inline bool upmin(T &a, const S &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T, typename S>
inline bool upmax(T &a, const S &b) {
  return a < b ? a = b, 1 : 0;
}
template <typename N, typename PN>
inline N flo(N a, PN b) {
  return a >= 0 ? a / b : -((-a - 1) / b) - 1;
}
template <typename N, typename PN>
inline N cei(N a, PN b) {
  return a > 0 ? (a - 1) / b + 1 : -(-a / b);
}
template <typename N>
N gcd(N a, N b) {
  return b ? gcd(b, a % b) : a;
}
inline void gn(long long &x) {
  int sg = 1;
  char c;
  while (((c = getchar()) < '0' || c > '9') && c != '-')
    ;
  c == '-' ? (sg = -1, x = 0) : (x = c - '0');
  while ((c = getchar()) >= '0' && c <= '9') x = x * 10 + c - '0';
  x *= sg;
}
inline void gn(int &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(unsigned long long &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline void gn(long double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline long long sqr(long long a) { return a * a; }
inline double sqrf(double a) { return a * a; }
const int inf = 0x3f3f3f3f;
const double eps = 1e-6;
int mo = 1000000007;
int qp(int a, long long b) {
  int n = 1;
  do {
    if (b & 1) n = 1ll * n * a % mo;
    a = 1ll * a * a % mo;
  } while (b >>= 1);
  return n;
}
struct fen {
  pair<int, int> p[66];
  int tot;
  void zuo(int a) {
    tot = 0;
    for (int i = 2; i * i <= a; i++)
      if (a % i == 0) {
        p[++tot] = make_pair(i, 0);
        while (a % i == 0) {
          p[tot].second++;
          a /= i;
        }
      }
    if (a > 1) {
      p[++tot] = make_pair(a, 1);
    }
  }
  void add(int x) {
    for (int i = (1), _ed = (tot + 1); i < _ed; i++)
      if (p[i].first == x) return;
    p[++tot] = make_pair(x, 0);
    sort(p + 1, p + 1 + tot);
  }
};
bool pok(const fen &a, const fen &b) {
  if (a.tot != b.tot) return 0;
  for (int i = (1), _ed = (a.tot + 1); i < _ed; i++)
    if (a.p[i].first != b.p[i].first) return 0;
  return 1;
}
struct node {
  int a, b;
  bool in(int x) {
    if (b == 1) {
      return a == x;
    }
    long long u = a;
    while (u <= x) {
      if (u == x) return 1;
      u *= b;
    }
    return 0;
  }
  fen pa, push_back;
  void chuli() {
    for (int i = (1), _ed = (push_back.tot + 1); i < _ed; i++)
      pa.add(push_back.p[i].first);
    for (int i = (1), _ed = (pa.tot + 1); i < _ed; i++)
      push_back.add(pa.p[i].first);
  }
} p[111];
int n;
int k;
struct ne {
  long long a[33], d[33];
} a[111];
ne jiao(ne u, ne v, int &ver) {
  ver = 1;
  long long a = 0, b = 0, c = 0;
  int bo = 0;
  for (int i = (1), _ed = (k + 1); i < _ed; i++) {
    long long C = v.a[i] - u.a[i];
    long long A = u.d[i], B = -v.d[i];
    if (A == 0 && B == 0) {
      if (C != 0) {
        ver = 0;
        return u;
      } else {
        continue;
      }
    }
    long long D = gcd(A, B);
    if (C % D != 0) {
      ver = 0;
      return u;
    }
    A /= D, B /= D, C /= D;
    if (A < 0) {
      A *= -1, B *= -1, C *= -1;
    }
    if (A == 0 && B > 0) {
      B *= -1, C *= -1;
    }
    if (!bo) {
      a = A, b = B;
      c = C;
      bo = 1;
    } else {
      if (a == A && b == B) {
        if (c != C) {
          ver = 0;
          return u;
        } else {
          continue;
        }
      } else {
        long long det = a * B - b * A;
        long long dx = c * B - b * C, dy = a * C - c * A;
        if (dx % det != 0 || dy % det != 0) {
          ver = 0;
          return u;
        }
        long long x = dx / det, y = dy / det;
        for (int j = (1), _ed = (k + 1); j < _ed; j++) {
          if (u.a[j] + x * u.d[j] != v.a[j] + y * v.d[j]) {
            ver = 0;
            return u;
          }
        }
        ne ans;
        for (int j = (1), _ed = (k + 1); j < _ed; j++)
          ans.a[j] = u.a[j] + x * u.d[j], ans.d[j] = 0;
        return ans;
      }
    }
  }
  if (bo == 0) return u;
  if (a == 0) {
    long long y = c / b;
    if (y < 0) {
      ver = 0;
      return u;
    }
    ne ans;
    for (int j = (1), _ed = (k + 1); j < _ed; j++)
      ans.a[j] = v.a[j] + y * v.d[j], ans.d[j] = 0;
    return ans;
  }
  if (b == 0) {
    long long x = c / a;
    if (x < 0) {
      ver = 0;
      return u;
    }
    ne ans;
    for (int j = (1), _ed = (k + 1); j < _ed; j++)
      ans.a[j] = u.a[j] + x * u.d[j], ans.d[j] = 0;
    return ans;
  }
  long long x, y;
  for (x = 0;; x++) {
    if ((c - a * x) % b == 0) {
      y = (c - a * x) / b;
      break;
    }
  }
  if (y < 0) {
    long long ned = cei(-y, a);
    y += ned * a;
    x -= ned * b;
  }
  ne ans;
  for (int j = (1), _ed = (k + 1); j < _ed; j++)
    ans.a[j] = u.a[j] + x * u.d[j], ans.d[j] = -b * u.d[j];
  return ans;
}
int main() {
  gn(n);
  for (int i = (1), _ed = (n + 1); i < _ed; i++) gn(p[i].a), gn(p[i].b);
  for (int i = (1), _ed = (n + 1); i < _ed; i++)
    if (p[i].b == 1) {
      int bo = 1;
      for (int j = (1), _ed = (n + 1); j < _ed; j++) bo &= p[j].in(p[i].a);
      if (bo)
        printf("%d\n", p[i].a);
      else
        printf("-1\n");
      return 0;
    }
  for (int i = (1), _ed = (n + 1); i < _ed; i++) {
    int bo = 1;
    for (int j = (1), _ed = (n + 1); j < _ed; j++) bo &= p[j].in(p[i].a);
    if (bo) {
      printf("%d\n", p[i].a);
      return 0;
    }
  }
  for (int i = (1), _ed = (n + 1); i < _ed; i++) {
    p[i].pa.zuo(p[i].a);
    p[i].push_back.zuo(p[i].b);
    p[i].chuli();
  }
  int bo = 1;
  for (int i = (1), _ed = (n + 1); i < _ed; i++) {
    if (!pok(p[i].pa, p[1].pa)) bo = 0;
  }
  if (!bo) {
    printf("-1\n");
    return 0;
  }
  ::k = p[1].pa.tot;
  for (int i = (1), _ed = (n + 1); i < _ed; i++) {
    for (int j = (1), _ed = (k + 1); j < _ed; j++) {
      a[i].a[j] = p[i].pa.p[j].second;
      a[i].d[j] = p[i].push_back.p[j].second;
    }
  }
  ne cur = a[1];
  for (int i = (2), _ed = (n + 1); i < _ed; i++) {
    int ver;
    ne ne = jiao(cur, a[i], ver);
    if (ver == 0) {
      printf("-1\n");
      return 0;
    }
    cur = ne;
  }
  int ans = 1;
  for (int i = (1), _ed = (k + 1); i < _ed; i++)
    ans = 1ll * ans * qp(p[1].pa.p[i].first, cur.a[i]) % mo;
  printf("%d\n", ans);
  return 0;
}
