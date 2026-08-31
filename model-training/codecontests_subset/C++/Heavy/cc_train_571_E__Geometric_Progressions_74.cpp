#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
long long Pow(long long a, long long k) {
  long long ret = 1;
  while (k) {
    if (k & 1) ret = ret * a % 1000000007;
    a = a * a % 1000000007;
    k >>= 1;
  }
  return ret;
}
void Exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1, y = 0;
    return;
  }
  Exgcd(b, a % b, y, x);
  y -= (a / b) * x;
}
long long Inv(long long x, long long m) {
  long long t1, t2;
  Exgcd(x, m, t1, t2);
  return (t1 % m + m) % m;
}
map<int, int> S;
int P[2005], cnt;
bool vis[2005];
int a[105][2005], b[105][2005];
bool Checkans(int n, int x, long long d) {
  int ans = 1;
  for (int i = 1; i <= cnt; i++) {
    long long v = a[x][i] + b[x][i] * d;
    for (int j = 1; j <= n; j++)
      if (b[j][i]) {
        if (v < a[j][i] || (v - a[j][i]) % b[j][i] != 0) return 0;
      } else if (a[j][i] != v)
        return 0;
    ans = ans * Pow(P[i], v) % 1000000007;
  }
  printf("%d\n", ans);
  return 1;
}
int Check(int n) {
  for (int i = 1; i <= cnt; i++) {
    int id = 0;
    for (int j = 1; j <= n; j++)
      if (!b[j][i]) id = j;
    if (!id) continue;
    vis[i] = 1;
    for (int j = 1; j <= n; j++)
      if (b[j][i]) {
        int v = a[id][i] - a[j][i];
        if (v % b[j][i] != 0) return 0;
        v /= b[j][i];
        if (v < 0) return 0;
        if (Checkans(n, j, v)) return 2;
        return 0;
      } else if (a[j][i] != a[id][i])
        return 0;
  }
  int id = 1;
  while (id <= cnt && vis[id]) id++;
  if (id > cnt)
    if (Checkans(n, 1, 0)) return 2;
  for (int i = id + 1; i <= cnt; i++)
    if (!vis[i]) {
      for (int j = 2; j <= n; j++) {
        int u = a[j][id] - a[1][id], v = a[j][i] - a[1][i];
        if (b[1][id] * b[j][i] != b[1][i] * b[j][id]) {
          int t1 = b[1][id] * b[j][i] - b[1][i] * b[j][id];
          int t2 = u * b[j][i] - v * b[j][id];
          if (t2 % t1) return 0;
          t2 /= t1;
          if (t2 < 0) return 0;
          if (Checkans(n, 1, t2)) return 2;
        } else if (b[1][id] * v != b[1][i] * u)
          return 0;
      }
    }
  return 1;
}
bool Solve(int n) {
  int id = 1;
  while (id <= cnt && vis[id]) id++;
  long long s = a[1][id] % b[1][id], w = b[1][id];
  for (int i = 2; i <= n; i++) {
    long long u = a[i][id] % b[i][id], v = b[i][id];
    long long d = gcd(w, v);
    if ((u - s) % d) return 0;
    long long p = w / d, q = v / d, r = (u - s) / d;
    long long x = (Inv(p, q) * r % q + q) % q;
    s = w * x + s;
    w = lcm(w, v);
  }
  for (int i = 1; i <= n; i++)
    while (s < a[i][id]) s += w;
  return Checkans(n, 1, (s - a[1][id]) / b[1][id]);
}
void Getfact(int x, int *A) {
  int t = x;
  for (int i = 2; i * i <= t; i++)
    if (x % i == 0) {
      if (!S.count(i)) {
        S[i] = ++cnt;
        P[cnt] = i;
      }
      int u = S[i];
      while (x % i == 0) {
        A[u]++;
        x /= i;
      }
    }
  if (x > 1) {
    if (!S.count(x)) {
      S[x] = ++cnt;
      P[cnt] = x;
    }
    int u = S[x];
    A[u] = 1;
  }
}
int n;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    Getfact(x, a[i]);
    Getfact(y, b[i]);
  }
  int x = Check(n);
  if (!x) {
    puts("-1");
    return 0;
  }
  if (x == 2) return 0;
  if (!Solve(n)) {
    puts("-1");
    return 0;
  }
}
