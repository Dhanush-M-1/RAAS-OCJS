#include <bits/stdc++.h>
using namespace std;
const int N = 1e2 + 7, M = 1e3 + 7, p = 1e9 + 7;
bool tag, res;
int n, a[N], b[N], p1[N];
map<int, int> q;
long long x, y;
struct node {
  long long g[M];
} f1[N], f2[N], ans1, ans2;
inline long long pows(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b & 1) ans = (ans * a) % p;
    a = (a * a) % p, b = b >> 1;
  }
  return ans;
}
inline int read() {
  int num = 0;
  char g = getchar();
  while (g < 48 || 57 < g) g = getchar();
  while (47 < g && g < 58)
    num = (num << 1) + (num << 3) + g - 48, g = getchar();
  return num;
}
inline void spilt(int u) {
  for (int i = 2; i <= sqrt(u); i++) {
    if (u % i == 0) {
      if (!q[i]) q[i] = 1, p1[++p1[0]] = i;
      while (u % i == 0) u /= i;
    }
  }
  if (u > 1) {
    if (!q[u]) q[u] = 1, p1[++p1[0]] = u;
  }
}
inline node getans(int u) {
  node w = f1[0];
  for (int i = 1; i <= p1[0]; i++)
    while (u % p1[i] == 0) w.g[i]++, u /= p1[i];
  return w;
}
inline long long gcd(long long a, long long b) {
  if (!b) return a;
  return gcd(b, a % b);
}
inline void exgcd(long long a, long long b, long long c) {
  if (b == 0) {
    x = c / a, y = 0;
    return;
  }
  exgcd(b, a % b, c);
  long long f1 = -y, f2 = -x - (a / b) * y;
  x = f1, y = f2;
}
inline void merge(node a, node b) {
  long long f1 = -1, f2 = -1;
  res = 0;
  long long wn = -1;
  for (int i = 1; i <= p1[0]; i++) {
    if (!ans2.g[i] && !b.g[i]) {
      if (ans1.g[i] != a.g[i]) {
        tag = 1;
        return;
      }
      continue;
    }
    if (!ans2.g[i]) {
      if (ans1.g[i] - a.g[i] < 0) {
        tag = 1;
        return;
      }
      f2 = (ans1.g[i] - a.g[i]) / b.g[i];
    }
    if (!b.g[i]) {
      if (a.g[i] - ans1.g[i] < 0) {
        tag = 1;
        return;
      }
      f1 = (a.g[i] - ans1.g[i]) / ans2.g[i];
    }
  }
  if (f1 != -1 || f2 != -1) {
    for (int i = 1; i <= p1[0]; i++) {
      if (ans2.g[i] && f2 != -1) {
        long long w = a.g[i] + f2 * b.g[i];
        f1 = (w - ans1.g[i]) / ans2.g[i];
      }
      if (b.g[i] && f1 != -1) {
        long long w = ans1.g[i] + f1 * ans2.g[i];
        f2 = (w - a.g[i]) / b.g[i];
      }
    }
    for (int i = 1; i <= p1[0]; i++)
      if (ans1.g[i] + ans2.g[i] * f1 != a.g[i] + b.g[i] * f2) {
        tag = 1;
        return;
      }
    for (int i = 1; i <= p1[0]; i++)
      ans1.g[i] = ans1.g[i] + f1 * ans2.g[i], ans2.g[i] = 0;
    return;
  }
  long long k1 = -1, b1 = -1, k2 = -1, b2 = -1;
  bool flg = 0;
  for (int i = 1; i <= p1[0]; i++) {
    if (!ans2.g[i] && !b.g[i]) continue;
    long long fa, fb, fc, fd;
    if (k1 == -1 && b1 == -1 && k2 == -1 && b2 == -1)
      fa = ans2.g[i], fb = b.g[i], fc = a.g[i] - ans1.g[i], fd = gcd(fa, fb);
    else
      fa = k1 * ans2.g[i], fb = k2 * b.g[i],
      fc = (b2 * b.g[i] + a.g[i]) - (b1 * ans2.g[i] + ans1.g[i]),
      fd = gcd(fa, fb);
    if (fc % fd) {
      tag = 1;
      return;
    }
    fa /= fd, fb /= fd, fc /= fd;
    exgcd(fa, fb, fc);
    if (x < 0 || y < 0) {
      long long z = max(-x / fb, -y / fa);
      x += fb * z, y += fa * z;
    }
    if (x >= fb && y >= fa) {
      long long z = min((x - fb) / fb, (y - fa) / fa);
      x -= fb * z, y -= fa * z;
    }
    while (x < 0 || y < 0) x += fb, y += fa;
    while (x >= fb && y >= fa) x -= fb, y -= fa;
    if (k1 == -1 && b1 == -1 && k2 == -1 && b2 == -1) {
      b1 = x, k1 = fb, b2 = y, k2 = fa;
      continue;
    }
    if (x != y || fa != fb) {
      if (x == y) {
        flg = 1, wn = b1 + k1 * x;
        break;
      }
      if (fa == fb) {
        tag = 1;
        return;
      }
      if ((x - y) % (fa - fb) != 0) {
        tag = 1;
        return;
      }
      wn = (x - y) / (fa - fb);
      if (wn < 0) {
        tag = 1;
        return;
      }
      wn = wn * fb + x, wn = wn * k1 + b1;
      break;
    }
    b1 = b1 + k1 * x, k1 = k1 * fa;
    b2 = b2 + k2 * x, k2 = k2 * fa;
  }
  if (wn >= 0) {
    for (int i = 1; i <= p1[0]; i++) {
      ans1.g[i] = ans1.g[i] + ans2.g[i] * wn, ans2.g[i] = 0;
    }
    return;
  }
  for (int i = 1; i <= p1[0]; i++) {
    ans1.g[i] = ans1.g[i] + ans2.g[i] * b1;
    ans2.g[i] = ans2.g[i] * k1;
  }
}
int main() {
  n = read(), tag = 0;
  for (int i = 1; i <= n; i++)
    a[i] = read(), b[i] = read(), spilt(a[i]), spilt(b[i]);
  for (int i = 1; i <= n; i++) f1[i] = getans(a[i]), f2[i] = getans(b[i]);
  ans1 = f1[1], ans2 = f2[1];
  for (int i = 2; i <= n; i++) {
    merge(f1[i], f2[i]);
    if (tag) {
      puts("-1");
      return 0;
    }
    merge(f1[i], f2[i]);
  }
  int opt = 1;
  for (int i = 1; i <= p1[0]; i++)
    opt = opt * pows(p1[i], ans1.g[i] % (p - 1)) % p;
  cout << opt << endl;
  return 0;
}
