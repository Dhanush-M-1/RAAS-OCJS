#include <bits/stdc++.h>
using namespace std;
struct pp {
  int a, b;
};
pp pt[111];
int n, fac[211111], num_fac, num, num_row, aa[2111][102], bb[2111][102];
long long now_ex[111];
const int mod = 1e9 + 7;
bool vis[111];
long long x, y, d, now_a, now_b, ep[2111];
int ans;
void gcd(long long a, long long n) {
  long long temp;
  if (n == 0) {
    d = a;
    x = 1;
    y = 0;
    return;
  }
  gcd(n, a % n);
  temp = x;
  x = y;
  y = temp - (a / n) * y;
}
int power(int a, long long n) {
  int res;
  if (n == 0) return 1;
  res = power(a, n / 2);
  res = (int)((long long)res * (long long)res % mod);
  if (n % 2) res = (int)((long long)res * (long long)a % mod);
  return res;
}
int main() {
  int i, j, s, p, q, tmp, a, b, v1, v2;
  bool add;
  scanf("%d", &n);
  num_fac = 0;
  for (i = 0; i < n; i++) {
    scanf("%d%d", &pt[i].a, &pt[i].b);
    for (s = 0; s < 2; s++) {
      a = pt[i].a;
      if (s == 1) a = pt[i].b;
      for (j = 2; j * j <= a; j++) {
        if (a % j == 0) {
          fac[num_fac++] = j;
          while (a % j == 0) a /= j;
        }
      }
      if (a > 1) fac[num_fac++] = a;
    }
  }
  sort(fac, fac + num_fac);
  num = 0;
  for (i = 0; i < num_fac; i++) {
    if (num == 0 || fac[num - 1] != fac[i]) fac[num++] = fac[i];
  }
  num_fac = num;
  memset(now_ex, -1, sizeof(now_ex));
  num_row = 0;
  memset(aa, 0, sizeof(aa));
  memset(bb, 0, sizeof(bb));
  for (i = 0; i < num_fac; i++) {
    for (j = 0; j < n; j++) {
      a = pt[j].a;
      while (a % fac[i] == 0) {
        a /= fac[i];
        bb[num_row][j]++;
      }
      b = pt[j].b;
      while (b % fac[i] == 0) {
        b /= fac[i];
        aa[num_row][j]++;
      }
    }
    for (j = 0; j < n; j++) {
      for (s = 0; s < n; s++) {
        if (aa[num_row][s] == 0 && aa[num_row][j] != 0) {
          a = aa[num_row][j];
          b = bb[num_row][s] - bb[num_row][j];
          if (b % a != 0 || b < 0) {
            puts("-1");
            return 0;
          }
          v1 = b / a;
          if (now_ex[j] >= 0 && now_ex[j] != v1) {
            puts("-1");
            return 0;
          }
          if (now_ex[j] < 0) now_ex[j] = v1;
        }
        if (aa[num_row][s] == 0 && aa[num_row][j] == 0) {
          if (bb[num_row][s] != bb[num_row][j]) {
            puts("-1");
            return 0;
          }
        }
      }
    }
    if (num_row >= 1) {
      for (j = 0; j < n; j++) {
        for (s = 0; s < n; s++) {
          if (j == s) continue;
          if (aa[num_row][j] != 0 || aa[num_row][s] != 0) {
            for (p = num_row - 1; p >= 0; p--) {
              if (aa[p][j] != 0 || aa[p][s] != 0) break;
            }
            if (p < 0) continue;
          } else {
            if (bb[num_row][j] != bb[num_row][s]) {
              puts("-1");
              return 0;
            }
            continue;
          }
          a = aa[num_row][j] * aa[p][s] - aa[p][j] * aa[num_row][s];
          b = (bb[num_row][s] - bb[num_row][j]) * aa[p][s] -
              (bb[p][s] - bb[p][j]) * aa[num_row][s];
          if ((a == 0 && b != 0) || (a != 0 && b % a != 0) ||
              (a != 0 && b / a < 0)) {
            puts("-1");
            return 0;
          }
          if (a != 0) {
            v1 = b / a;
            b = (bb[p][j] - bb[p][s]) * aa[num_row][j] -
                (bb[num_row][j] - bb[num_row][s]) * aa[p][j];
            if (b % a != 0 || b / a < 0) {
              puts("-1");
              return 0;
            }
            v2 = b / a;
            if ((now_ex[j] >= 0 && now_ex[j] != v1) ||
                (now_ex[s] >= 0 && now_ex[s] != v2)) {
              puts("-1");
              return 0;
            }
            if (now_ex[j] < 0) now_ex[j] = v1;
            if (now_ex[s] < 0) now_ex[s] = v2;
          }
        }
      }
    }
    num_row++;
  }
  if (now_ex[0] < 0) {
    memset(vis, false, sizeof(vis));
    for (j = 0; j < num_fac; j++) {
      now_a = 1;
      now_b = 0;
      for (i = 0; i < n; i++) {
        if (aa[j][i] == 0) continue;
        gcd(now_a, aa[j][i]);
        now_b = bb[j][i] - now_b;
        if (now_b % d != 0) {
          puts("-1");
          return 0;
        }
        x = (long long)x * (long long)(now_b / d) % (aa[j][i] / d);
        if (x < 0) x += aa[j][i];
        now_b = bb[j][i] - now_b;
        now_b = (x * now_a + now_b) % (now_a * (aa[j][i] / d));
        now_a = now_a * (aa[j][i] / d);
      }
      for (i = 0; i < n; i++) {
        while (now_b < bb[j][i]) now_b += now_a;
      }
      ep[j] = now_b;
    }
  } else {
    memset(ep, 0, sizeof(ep));
    for (j = 0; j < num_fac; j++) {
      for (i = 0; i < n; i++) {
        if (now_ex[i] >= 0) {
          ep[j] = now_ex[i] * aa[j][i] + bb[j][i];
          break;
        }
      }
    }
  }
  ans = 1;
  for (i = 0; i < num_fac; i++)
    ans = (int)((long long)ans * (long long)power(fac[i], ep[i]) % mod);
  printf("%d\n", ans);
  return 0;
}
