#include <bits/stdc++.h>
using namespace std;
const int N = 40000 + 10;
const int maxn = 100 + 10;
const int MOD = 1000000007;
const int DEBUG = 0;
inline int inc(int a, int b) {
  return (a + b >= MOD) ? (a + b - MOD) : (a + b);
}
inline int dec(int a, int b) { return (a >= b) ? (a - b) : (a + MOD - b); }
inline int mul(int a, int b) { return 1LL * a * b % MOD; }
inline int power(int x, long long k) {
  int tmp = 1;
  while (k) {
    if (k & 1) tmp = mul(tmp, x);
    x = mul(x, x);
    k >>= 1;
  }
  return tmp;
}
long long gcd(long long a, long long b) { return (!b) ? (a) : (gcd(b, a % b)); }
int n, pcnt, p[N];
bool isp[N];
inline void prepare(int N) {
  isp[0] = isp[1] = 1;
  for (int i = 2; i <= N; i++) {
    if (!isp[i]) p[++pcnt] = i;
    for (int j = 1; j <= pcnt && i * p[j] <= N; j++) {
      isp[i * p[j]] = 1;
      if (i % p[j] == 0) break;
    }
  }
}
struct data {
  pair<int, long long> pri[4050];
  int cnt;
  inline void input() {
    int x;
    scanf("%d", &x);
    cnt = 0;
    for (int i = 1; i <= pcnt && x >= p[i]; i++) {
      if (x % p[i]) continue;
      pair<int, long long> now = make_pair(p[i], 0);
      while (x % p[i] == 0) {
        now.second++;
        x /= p[i];
      }
      cnt++;
      pri[cnt] = now;
    }
    if (x > 1) pri[++cnt] = make_pair(x, 1);
  }
  inline pair<int, long long> query(int x) {
    for (int i = 1; i <= cnt; i++)
      if (pri[i].first == x) return pri[i];
    return make_pair(x, 0);
  }
} a[maxn], b[maxn];
int lis[N], tot;
inline void init(data a) {
  for (int i = 1; i <= a.cnt; i++) lis[++tot] = a.pri[i].first;
}
pair<int, long long> A1[N], A2[N], B1[N], B2[N];
inline int get_x(long long A, long long B, long long C, long long a,
                 long long b, long long c, long long &x1, long long &x2) {
  while (a) {
    long long tmp = A / a;
    A -= tmp * a;
    B -= tmp * b;
    C -= tmp * c;
    swap(A, a);
    swap(B, b);
    swap(C, c);
  }
  if (abs(c) % abs(b)) return 0;
  x2 = -c / b;
  if (x2 < 0) return 0;
  if (abs(B * x2 + C) % A) return 0;
  x1 = (-B * x2 - C) / A;
  if (x1 < 0) return 0;
  return 1;
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  long long g = exgcd(b, a % b, y, x);
  y -= a / b * x;
  return g;
}
inline int merge(int x, int y) {
  tot = 0;
  init(a[x]);
  init(a[y]);
  init(b[x]);
  init(b[y]);
  sort(lis + 1, lis + tot + 1);
  tot = unique(lis + 1, lis + tot + 1) - lis - 1;
  for (int i = 1; i <= tot; i++) A1[i] = a[x].query(lis[i]);
  for (int i = 1; i <= tot; i++) A2[i] = a[y].query(lis[i]);
  for (int i = 1; i <= tot; i++) B1[i] = b[x].query(lis[i]);
  for (int i = 1; i <= tot; i++) B2[i] = b[y].query(lis[i]);
  long long A, B, C, x1, x2;
  int flag = 0;
  A = B = C = x1 = x2 = 0;
  for (int i = 1; i <= tot; i++) {
    long long a = B1[i].second, b = -B2[i].second,
              c = A1[i].second - A2[i].second;
    if (DEBUG) printf("a b c %d %d %d\n", a, b, c);
    if (a == 0 && b == 0) {
      if (c == 0) continue;
      return 0;
    }
    long long g = gcd(a, gcd(-b, abs(c)));
    a /= g, b /= g, c /= g;
    if (!b && (c % a || -c / a < 0)) return 0;
    if (!A && !B && !C) {
      A = a;
      B = b;
      C = c;
      continue;
    }
    if (A * b == a * B && A * c == a * C) continue;
    if (A * b == a * B && A * c != a * C) return 0;
    if (!get_x(A, B, C, a, b, c, x1, x2)) return 0;
    flag = 1;
    break;
  }
  if (flag) {
    for (int i = 1; i <= tot; i++) {
      long long a = B1[i].second, b = -B2[i].second,
                c = A1[i].second - A2[i].second;
      if (a * x1 + b * x2 + c) return 0;
      A1[i].second += x1 * B1[i].second;
      B1[i].second = 0;
    }
    for (int i = 1; i <= tot; i++) a[x].pri[i] = A1[i], b[x].pri[i] = B1[i];
    a[x].cnt = b[x].cnt = tot;
    return 1;
  }
  long long g = exgcd(A, B, x1, x2);
  if (C % g) return 0;
  x1 *= -C / g, x2 *= -C / g;
  long long t1 = abs(B / g), t2 = abs(A / g);
  if (C > 0 || !t2) {
    x1 = (x1 % t1 + t1) % t1;
    if (B)
      x2 = (-C - A * x1) / B;
    else
      x2 = 0;
  } else {
    x2 = (x2 % t2 + t2) % t2;
    if (A)
      x1 = (-C - B * x2) / A;
    else
      x1 = 0;
  }
  for (int i = 1; i <= tot; i++) {
    A1[i].second += B1[i].second * x1;
    B1[i].second *= t1;
  }
  for (int i = 1; i <= tot; i++) a[x].pri[i] = A1[i], b[x].pri[i] = B1[i];
  a[x].cnt = b[x].cnt = tot;
  return 1;
}
int main() {
  prepare(40000);
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) a[i].input(), b[i].input();
  int bo = 1;
  for (int i = 2; i <= n && bo; i++) {
    bo &= merge(1, i);
  }
  if (!bo) {
    puts("-1");
    return 0;
  }
  int Ans = 1;
  for (int i = 1; i <= a[1].cnt; i++) {
    Ans = mul(Ans, power(a[1].pri[i].first, a[1].pri[i].second));
  }
  printf("%d\n", Ans);
  return 0;
}
