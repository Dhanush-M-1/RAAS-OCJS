#include <bits/stdc++.h>
using namespace std;
inline long long Getint() {
  char ch = getchar();
  long long x = 0, fh = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') fh = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    (x *= 10) += ch ^ 48;
    ch = getchar();
  }
  return fh * x;
}
const int N = 200005;
int n, h;
long long mod, fc[N], fiv[N], inv[N], sm[N];
int su[N];
struct nod {
  int a, l;
  nod(int x = 0, int y = 0) {
    a = x;
    l = y;
  }
};
vector<nod> a;
inline long long Solve(int l1, int l2) {
  long long Ans = 1ll * l1 * l2 % mod * inv[2] % mod;
  for (int i = 1; i <= l1; i++) (Ans += sm[i] - sm[i + l2] + mod) %= mod;
  return (Ans % mod + mod) % mod;
}
void Build(int l, int r, int h) {
  if (h == 1) {
    su[r - l + 1]++;
    return;
  }
  if (l == r) {
    su[1]++;
    return;
  }
  int mid = l + r >> 1;
  Build(l, mid, h - 1);
  Build(mid + 1, r, h - 1);
}
int main() {
  n = Getint();
  h = Getint();
  mod = Getint();
  fc[0] = fc[1] = fiv[0] = fiv[1] = inv[0] = inv[1] = 1;
  for (int i = 2; i <= N - 1; i++) {
    fc[i] = fc[i - 1] * i % mod;
    inv[i] = (mod - mod / i) * inv[mod % i] % mod;
    fiv[i] = fiv[i - 1] * inv[i] % mod;
  }
  for (int i = 1; i <= N - 1; i++) {
    sm[i] = (sm[i - 1] + inv[i]) % mod;
  }
  Build(1, n, h);
  long long Ans = 0;
  for (int i = 1; i <= n; i++) {
    if (!su[i]) continue;
    a.push_back(nod(su[i], i));
    (Ans += 1ll * su[i] * i % mod * (i - 1) % mod * inv[4]) %= mod;
  }
  for (int i = 0; i <= int(a.size()) - 1; i++) {
    (Ans += 1ll * a[i].a * (a[i].a - 1) % mod * inv[2] % mod *
            Solve(a[i].l, a[i].l)) %= mod;
    for (int j = i + 1; j <= int(a.size()) - 1; j++) {
      (Ans += 1ll * a[i].a * a[j].a % mod * Solve(a[i].l, a[j].l)) %= mod;
    }
  }
  cout << Ans % mod << '\n';
  return 0;
}
