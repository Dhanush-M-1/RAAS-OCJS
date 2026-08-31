#include <bits/stdc++.h>
const int INF = 1e9;
const long long lINF = 1e18;
const double EPS = 1e-12;
using namespace std;
const int N = 111;
int n;
int a[N], b[N];
map<int, long long> pa[N], push_back[N];
const int MOD = 1e9 + 7;
void makenotcollinear(int i, int p1, int p2) {
  long long x1 = pa[0][p1], y1 = pa[0][p2];
  long long dx1 = push_back[0][p1], dy1 = push_back[0][p2];
  long long x2 = pa[i][p1], y2 = pa[i][p2];
  long long dx2 = push_back[i][p1], dy2 = push_back[i][p2];
  long long normx = -dy2, normy = dx2;
  long long want = (x2 - x1) * normx + (y2 - y1) * normy;
  long long step = dx1 * normx + dy1 * normy;
  assert(step != 0);
  long long mult = want / step;
  for (auto j : push_back[i]) {
    pa[0][j.first] += push_back[0][j.first] * mult;
  }
}
int power(int a, long long p) {
  int res = 1;
  for (; p; p >>= 1) {
    if (p & 1) {
      res = (res * 1ll * a) % MOD;
    }
    a = (a * 1ll * a) % MOD;
  }
  return res;
}
long long prod(long long a, long long b, long long curmod) {
  long long res = 0;
  bool flag = false;
  if (b < 0) {
    b = -b;
    flag = true;
  }
  for (; b; b >>= 1) {
    if (b & 1) {
      res = (res + a) % curmod;
    }
    a = a * 2 % curmod;
  }
  if (flag) {
    res = -res;
  }
  return res;
}
long long gcdExt(long long a, long long b, long long& M, long long& N) {
  if (b == 0) {
    M = 1;
    N = 0;
    return a;
  } else {
    long long k = a / b;
    long long res = gcdExt(b, a - k * b, M, N);
    swap(M, N);
    N -= k * M;
    return res;
  }
}
void solve() {
  bool ok = true;
  for (int i = 1; i < n && ok; i++) {
    vector<int> primes;
    for (auto j : pa[0]) {
      primes.push_back(j.first);
    }
    for (auto j : pa[i]) {
      primes.push_back(j.first);
    }
    for (auto j : push_back[i]) {
      primes.push_back(j.first);
    }
    long long mult = -1;
    for (auto j : primes) {
      long long want = pa[0][j];
      long long have = pa[i][j];
      if (push_back[i][j] == 0) {
        if (have != want) {
          ok = false;
          break;
        }
      } else {
        if (mult != -1) {
          if (mult * push_back[i][j] + have != want) {
            ok = false;
            break;
          }
        } else {
          mult = (want - have) / push_back[i][j];
          if (mult < 0 || mult * push_back[i][j] + have != want) {
            ok = false;
            break;
          }
        }
      }
    }
  }
  if (ok) {
    int ans = 1;
    for (auto i : pa[0]) {
      ans = ans * 1ll * power(i.first, i.second) % MOD;
    }
    printf("%d\n", ans);
  } else {
    printf("-1\n");
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", a + i, b + i);
    if (b[i] != 1) {
      swap(a[i], a[0]);
      swap(b[i], b[0]);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 2; j * j <= a[i]; j++) {
      while (a[i] % j == 0) {
        a[i] /= j;
        pa[i][j]++;
      }
    }
    if (a[i] > 1) {
      pa[i][a[i]]++;
    }
    for (int j = 2; j * j <= b[i]; j++) {
      while (b[i] % j == 0) {
        b[i] /= j;
        push_back[i][j]++;
      }
    }
    if (b[i] > 1) {
      push_back[i][b[i]]++;
    }
  }
  int p1 = 2, p1cnt = 0;
  for (auto i : push_back[0]) {
    if (i.second != 0) {
      p1 = i.first;
      p1cnt = i.second;
    }
  }
  bool collinear = true;
  for (int i = 1; i < n; i++) {
    int cur = push_back[i][p1];
    for (auto j : push_back[i]) {
      if (push_back[0][j.first] * cur != j.second * p1cnt) {
        makenotcollinear(i, p1, j.first);
        collinear = false;
      }
    }
    for (auto j : push_back[0]) {
      if (j.second * cur != push_back[i][j.first] * p1cnt) {
        makenotcollinear(i, p1, j.first);
        collinear = false;
      }
    }
  }
  if (!collinear) {
    solve();
  } else {
    long long a = pa[0][p1];
    long long b = push_back[0][p1];
    if (b == 0) {
      solve();
    } else {
      a %= b;
      bool ok = true;
      for (int i = 1; i < n; i++) {
        long long c = push_back[i][p1];
        if (c == 0) {
          if (a != pa[i][p1] % b) {
            ok = false;
            break;
          } else {
            a = pa[i][p1];
            continue;
          }
        }
        long long M, N;
        long long g = gcdExt(b, c, M, N);
        long long d = pa[i][p1];
        if (a % g != d % g) {
          ok = false;
          break;
        }
        long long lcm = b / g * c;
        long long na = prod(M, b, lcm);
        na = prod(na, (d % c - a % c) / g, lcm);
        na += a;
        na %= lcm;
        if (na < 0) {
          na += lcm;
        }
        a = na;
        b = lcm;
      }
      if (!ok) {
        printf("-1\n");
      } else {
        for (int i = 0; i < n; i++) {
          while (pa[i][p1] > a) {
            a += push_back[i][p1];
          }
        }
        long long add = (a - pa[0][p1]) / push_back[0][p1];
        for (auto& i : pa[0]) {
          i.second += push_back[0][i.first] * add;
        }
        solve();
      }
    }
  }
  return 0;
}
