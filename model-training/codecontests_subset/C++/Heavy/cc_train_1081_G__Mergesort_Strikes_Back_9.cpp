#include <bits/stdc++.h>
using namespace std;
int p;
int Pow(int a, int b) {
  int ans = 1;
  for (; b; b >>= 1, a = 1ll * a * a % p) {
    if (b & 1) ans = 1ll * ans * a % p;
  }
  return ans;
}
int solve(int a, int b) {
  if (a <= 0 || b <= 0) return 0;
  int ans = 0;
  for (int sm = 2; sm <= a + b; sm++)
    ans = (1ll * (min(a, sm - 1) - max(1, sm - b) + 1) * (sm - 2) % p *
               Pow(2 * sm, p - 2) % p +
           1ll * ans) %
          p;
  return ans;
}
int C(int n) { return (1ll * n * (n - 1) / 2) % p; }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k >> p;
  int iv = (p + 1) / 2;
  pair<int, int> A = {n, 1}, B = {0, 0};
  while (--k) {
    if (A.first & 1) {
      B = {(A.first / 2) + 1, A.second};
      A.first /= 2;
      break;
    }
    A.first /= 2, A.second *= 2;
  }
  if (k != 0) {
    while (--k) {
      if (A.first & 1) {
        B.first /= 2, B.second = 2 * B.second + A.second;
        A.first /= 2;
      } else {
        A.first /= 2, A.second = 2 * A.second + B.second;
        B.first = (B.first + 1) / 2;
      }
    }
  }
  int ans = 0;
  ans = (1ll * C(A.first) * iv % p * A.second + 1ll * ans) % p;
  ans = (1ll * C(B.first) * iv % p * B.second + 1ll * ans) % p;
  ans = (1ll * C(A.second) * solve(A.first, A.first) + 1ll * ans) % p;
  ans = (1ll * C(B.second) * solve(B.first, B.first) + 1ll * ans) % p;
  ans =
      (1ll * A.second * B.second % p * solve(A.first, B.first) + 1ll * ans) % p;
  return cout << ans << endl, 0;
}
