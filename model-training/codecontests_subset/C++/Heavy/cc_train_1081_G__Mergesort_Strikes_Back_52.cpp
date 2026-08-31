#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 2;
int mod, num1 = 0, num2 = 0, cnt1 = 0, cnt2 = 0, rev[N], sum[N];
void add(int &x, int y) {
  x += y;
  if (x >= mod) {
    x -= mod;
  }
}
void sub(int &x, int y) {
  x -= y;
  if (x < 0) {
    x += mod;
  }
}
int mul(int x, int y) { return (1ll * x * y) % mod; }
int binpow(int x, int y) {
  int tich = 1;
  while (y) {
    if (y & 1) {
      tich = mul(tich, x);
    }
    x = mul(x, x);
    y >>= 1;
  }
  return tich;
}
void recur(int l, int r, int dep) {
  if (dep < 2 || l == r) {
    if (!num1 || r - l + 1 == num1) {
      num1 = r - l + 1;
      cnt1++;
    } else {
      num2 = r - l + 1;
      cnt2++;
    }
    return;
  }
  recur(l, (l + r) / 2, dep - 1);
  recur((l + r) / 2 + 1, r, dep - 1);
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, i, j, k, l, dep, ans = 0;
  cin >> n >> dep >> mod;
  for (i = 1; i < N; i++) {
    rev[i] = binpow(i, mod - 2);
    sum[i] = sum[i - 1];
    add(sum[i], rev[i]);
  }
  recur(1, n, dep);
  if (num1) {
    add(ans, mul(cnt1, mul(num1, mul(num1 - 1, rev[4]))));
    j = mul(mul(cnt1, cnt1 - 1), rev[2]);
    for (i = 1; i <= num1; i++) {
      add(ans, mul(mul(rev[2], num1), j));
      sub(ans, mul((sum[i + num1] - sum[i] + mod) % mod, j));
    }
  }
  if (num2) {
    add(ans, mul(cnt2, mul(num2, mul(num2 - 1, rev[4]))));
    j = mul(mul(cnt2, cnt2 - 1), rev[2]);
    for (i = 1; i <= num2; i++) {
      add(ans, mul(mul(rev[2], num2), j));
      sub(ans, mul((sum[i + num2] - sum[i] + mod) % mod, j));
    }
  }
  if (num1 && num2) {
    j = mul(cnt1, cnt2);
    for (i = 1; i <= num1; i++) {
      add(ans, mul(mul(rev[2], num2), j));
      sub(ans, mul((sum[i + num2] - sum[i] + mod) % mod, j));
    }
  }
  cout << ans;
}
