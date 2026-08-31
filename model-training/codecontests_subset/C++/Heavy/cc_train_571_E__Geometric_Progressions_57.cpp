#include <bits/stdc++.h>
using namespace std;
const int N = 514;
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
long long msk(long long a, long long b, long long k, int md) {
  a %= md;
  k %= md;
  while (b) {
    if (b & 1) k = k * a % md;
    a = a * a % md;
    b >>= 1;
  }
  return k;
}
pair<int, int> a[N];
map<int, int> mp;
int n;
long long t[N], s[N], r[N], p[N],
    P[20]{0,      998244353,    1000000007, 19260817, 998244853, 1919810,
          114514, 191981011451, 1145141919, 1919810,  5141919};
bool chk(int x) {
  for (int i = (1); i <= (n); i++) {
    if (x % a[i].first) return 0;
    int y = x / a[i].first;
    while (y != 1) {
      if (y % a[i].second || a[i].second == 1) return 0;
      y /= a[i].second;
    }
  }
  return 1;
}
bool chk(int x, int i, int y) {
  int u = (i * log(a[x].second) + log(1. * a[x].first / a[y].first)) /
          log(a[y].second);
  for (int k = (max(0, u - 10)); k <= (min(1919, u + 10)); k++) {
    int ty = 1;
    for (int l = (1); l <= (10); l++) {
      int md = P[l];
      if (msk(a[x].second, i, a[x].first, md) !=
          msk(a[y].second, k, a[y].first, md)) {
        ty = 0;
        break;
      }
    }
    if (ty) return 1;
  }
  return 0;
}
void sol(int x, int y) {
  for (int i = (0); i <= (1919); i++) {
    if (chk(x, i, y)) {
      int ty = 1;
      for (int j = (1); j <= (n); j++)
        if (!chk(x, i, j)) {
          ty = 0;
          break;
        }
      if (ty) {
        printf("%lld", msk(a[x].second, i, a[x].first, 1e9 + 7));
        exit(0);
      }
    }
  }
  {
    puts("-1");
    exit(0);
  };
}
void chai(int x) {
  mp.clear();
  for (int i = 2; i <= sqrt(x); ++i)
    while (x % i == 0) x /= i, mp[i]++;
  if (x > 1) mp[x]++;
}
int main() {
  scanf("%d", &n);
  srand(time(0));
  for (int i = (1); i <= (n); i++) scanf("%d%d", &a[i].first, &a[i].second);
  sort(a + 1, a + n + 1);
  if (chk(a[n].first)) {
    printf("%d", a[n].first);
    return 0;
  }
  for (int i = (1); i <= (n); i++) {
    chai(a[i].second);
    s[i] = 1;
    for (auto& j : mp) t[i] = gcd(t[i], j.second);
    for (auto& j : mp) {
      j.second /= t[i];
      for (int k = (0); k <= (j.second - 1); k++) s[i] *= j.first;
    }
    if (s[i] != s[1]) sol(1, i);
  }
  long long md = 1, al = 0;
  for (int i = (1); i <= (n); i++) {
    r[i] = a[i].first;
    while (!(r[i] % s[i])) r[i] /= s[i], p[i]++;
    if (r[i] != r[1]) {
      puts("-1");
      exit(0);
    };
    long long x = gcd(t[i], md);
    if (al % x != p[i] % x) {
      puts("-1");
      exit(0);
    };
    while (al % t[i] != p[i] % t[i]) al += md;
    md = md / x * t[i];
    al %= md;
  }
  for (int i = (1); i <= (n); i++)
    while (al < p[i]) al += md;
  printf("%lld\n", msk(s[1], al, r[1], 1e9 + 7));
  return 0;
}
