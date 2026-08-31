#include <bits/stdc++.h>
using namespace std;
map<int, int> tp;
int n, a, b, s1[5002], ct, mx;
long long s[5002][2], t[5002][2], q[3][3];
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  long long g = exgcd(b, a % b, x, y);
  long long t = x;
  x = y;
  y = t - a / b * y;
  return g;
}
int pw(int a, int p) {
  int as = 1;
  while (p) {
    if (p & 1) as = 1ll * as * a % 1000000007;
    a = 1ll * a * a % 1000000007;
    p >>= 1;
  }
  return as;
}
bool pw2(int a, int p) {
  int as = 1, vl = pw(a, p);
  while (p) {
    if (p & 1) as = 1ll * as * a;
    a = 1ll * a * a;
    p >>= 1;
  }
  return as != vl;
}
void merge() {
  int c1 = 0;
  for (int i = 1; i <= ct; i++) {
    if (s[i][1] == 0 && t[i][1] == 0) {
      if (s[i][0] != t[i][0]) {
        printf("-1\n");
        exit(0);
      };
      continue;
    }
    q[++c1][0] = s[i][1], q[c1][1] = -t[i][1], q[c1][2] = -t[i][0] + s[i][0];
    long long g = gcd(q[c1][0], q[c1][1]);
    if (q[c1][2] % g) {
      printf("-1\n");
      exit(0);
    };
    q[c1][0] /= g;
    q[c1][1] /= g;
    q[c1][2] /= g;
    if (q[c1][0] < 0) q[c1][0] *= -1, q[c1][1] *= -1, q[c1][2] *= -1;
    if (c1 == 2) {
      if (q[1][1] == 0 && q[2][1] == 0) {
        if ((q[1][2] % q[1][0]) || (q[2][2] % q[2][0]) ||
            (q[1][2] / q[1][0] != q[2][2] / q[2][0])) {
          printf("-1\n");
          exit(0);
        };
        long long asx = q[1][2] / q[1][0];
        q[1][0] = 1;
        q[1][1] = 0;
        q[1][2] = asx;
        c1--;
        continue;
      }
      if (q[1][0] == 0 && q[2][0] == 0) {
        if ((q[1][2] % q[1][1]) || (q[2][2] % q[2][1]) ||
            (q[1][2] / q[1][1] != q[2][2] / q[2][1])) {
          printf("-1\n");
          exit(0);
        };
        long long asx = q[1][2] / q[1][1];
        q[1][0] = 0;
        q[1][1] = 1;
        q[1][2] = asx;
        c1--;
        continue;
      }
      if (q[1][0] == q[2][0] && q[1][1] == q[2][1]) {
        if (q[1][2] != q[2][2]) {
          printf("-1\n");
          exit(0);
        };
        c1--;
        continue;
      }
      long long g = gcd(q[1][1], q[2][1]), s1 = q[1][1] / g, s2 = q[2][1] / g;
      long long asx, asy;
      if (q[1][1] == 0) {
        if (q[1][2] % q[1][0]) {
          printf("-1\n");
          exit(0);
        };
        asx = -q[1][2] / q[1][0];
        if ((-q[2][2] - asx * q[2][0]) % q[2][1]) {
          printf("-1\n");
          exit(0);
        };
        asy = (-q[2][2] - asx * q[2][0]) / q[2][1];
      } else if (q[2][1] == 0) {
        if (q[2][2] % q[2][0]) {
          printf("-1\n");
          exit(0);
        };
        asx = -q[2][2] / q[2][0];
        if ((-q[1][2] - asx * q[1][0]) % q[1][1]) {
          printf("-1\n");
          exit(0);
        };
        asy = (-q[1][2] - asx * q[1][0]) / q[1][1];
      } else {
        q[1][0] *= s2;
        q[1][1] *= s2;
        q[1][2] *= s2;
        q[2][0] *= s1;
        q[2][1] *= s1;
        q[2][2] *= s1;
        if (q[1][0] == q[2][0]) {
          if ((q[2][2] - q[1][2]) % (q[1][1] - q[2][1])) {
            printf("-1\n");
            exit(0);
          };
          asy = (q[2][2] - q[1][2]) / (q[1][1] - q[2][1]);
          if (q[1][0]) {
            if ((q[1][2] - asy * q[1][1]) % q[1][0]) {
              printf("-1\n");
              exit(0);
            };
            asy = (q[1][2] - asy * q[1][1]) / q[1][0];
          }
        }
        if ((q[2][2] - q[1][2]) % (q[1][0] - q[2][0])) {
          printf("-1\n");
          exit(0);
        };
        asx = (q[2][2] - q[1][2]) / (q[1][0] - q[2][0]);
        if (q[1][1]) {
          if ((-q[1][2] - asx * q[1][0]) % q[1][1]) {
            printf("-1\n");
            exit(0);
          };
          asy = (-q[1][2] - asx * q[1][0]) / q[1][1];
        } else if (q[2][1]) {
          if ((-q[2][2] - asx * q[2][0]) % q[2][1]) {
            printf("-1\n");
            exit(0);
          };
          asy = (-q[2][2] - asx * q[2][0]) / q[2][1];
        }
      }
      if (asx < 0 || asy < 0) {
        printf("-1\n");
        exit(0);
      };
      for (int j = 1; j <= ct; j++) {
        long long s1 = s[j][1] * asx + s[j][0], s2 = t[j][1] * asy + t[j][0];
        if (s1 != s2) {
          printf("-1\n");
          exit(0);
        };
        s[j][0] = s1;
        s[j][1] = 0;
      }
      return;
    }
  }
  if (!c1) return;
  long long x, y, s1;
  long long g = exgcd(q[1][0], q[1][1], x, y);
  long long f1 = q[1][0], f2 = q[1][1];
  int fg1 = f1 > 0 ? 1 : -1, fg2 = f2 > 0 ? 1 : -1;
  x *= -q[1][2] * g;
  y *= -q[1][2] * g;
  if (x < 0) s1 = -x / (f2 * fg2), x += f2 * fg2 * s1, y -= f1 * fg2 * s1;
  while (x < 0) x += f2 * fg2, y -= f1 * fg2;
  if (y < 0) s1 = -y / (f1 * fg1), y += f1 * fg1 * s1, x -= f2 * fg1 * s1;
  while (y < 0) y += f1 * fg1, x -= f2 * fg1;
  s1 = min(fg2 * f2 == 0 ? 0 : x / (fg2 * f2),
           fg1 * f1 == 0 ? 0 : y / (fg1 * f1));
  x -= fg2 * f2 * s1, y -= fg1 * f1 * s1;
  while (x >= fg2 * f2 && y >= fg1 * f1) x -= fg2 * f2, y -= fg1 * f1;
  if (x < 0) {
    printf("-1\n");
    exit(0);
  };
  for (int i = 1; i <= ct; i++)
    if (s[i][1] || t[i][1]) {
      if (s[i][1])
        s[i][0] += s[i][1] * x, s[i][1] *= f2;
      else
        s[i][0] = t[i][0] + t[i][1] * y;
      s[i][1] = t[i][1] * f1;
    }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= ct; j++) t[j][0] = t[j][1] = 0;
    scanf("%d%d", &a, &b);
    mx = max(mx, a);
    for (int j = 2; j <= 4e4; j++)
      if (a % j == 0 || b % j == 0) {
        if (!tp[j]) tp[j] = ++ct, s1[ct] = j;
        int s11 = 0, s21 = 0;
        while (a % j == 0) a /= j, s11++;
        while (b % j == 0) b /= j, s21++;
        t[tp[j]][0] = s11, t[tp[j]][1] = s21;
      }
    if (a > 1 && b > 1 && a == b) {
      if (!tp[a]) tp[a] = ++ct, s1[ct] = a;
      t[tp[a]][0] = 1, t[tp[a]][1] = 1;
    } else if (a > 1) {
      if (!tp[a]) tp[a] = ++ct, s1[ct] = a;
      t[tp[a]][0] = 1, t[tp[a]][1] = 0;
    } else if (b > 1) {
      if (!tp[b]) tp[b] = ++ct, s1[ct] = b;
      t[tp[b]][0] = 0, t[tp[b]][1] = 1;
    }
    if (i == 1)
      swap(s, t);
    else
      merge();
  }
  int as = 1, fg = 0;
  for (int i = 1; i <= ct; i++)
    fg |= (1ll * as * pw(s1[i], s[i][0] % (1000000007 - 1)) % 1000000007 !=
           1ll * as * pw(s1[i], s[i][0] % (1000000007 - 1))) |
          (s[i][0] >= 1000000007) | pw2(s1[i], s[i][0] % (1000000007 - 1)),
        as = 1ll * as * pw(s1[i], s[i][0] % (1000000007 - 1)) % 1000000007;
  while (as < mx && !fg) {
    for (int i = 1; i <= ct; i++)
      fg |= (1ll * as * pw(s1[i], s[i][1] % (1000000007 - 1)) % 1000000007 !=
             1ll * as * pw(s1[i], s[i][1] % (1000000007 - 1))),
          as = 1ll * as * pw(s1[i], s[i][1] % (1000000007 - 1)) % 1000000007;
  }
  printf("%d\n", as);
}
