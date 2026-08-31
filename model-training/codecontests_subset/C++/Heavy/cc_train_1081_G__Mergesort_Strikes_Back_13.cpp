#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -1;
  for (; isdigit(c); c = getchar()) x = x * 10 + c - '0';
  return x * f;
}
const int MAXN = 100010;
const int INF = 2147483600;
long long Mod;
int N, K, Q;
int mn = 100000;
long long inv[MAXN << 1], sm[MAXN << 1];
long long cnt[MAXN << 1];
long long ans;
inline void div(int l, int r, int x) {
  if (x == 1 || l == r) {
    mn = min(mn, r - l + 1);
    ++cnt[r - l + 1];
    return;
  }
  int mid = (l + r) >> 1;
  div(l, mid, x - 1);
  div(mid + 1, r, x - 1);
}
inline void calc(int x) {
  (ans += cnt[x] * x % Mod * (x - 1) % Mod * inv[4] % Mod) %= Mod;
}
int main() {
  N = read(), K = read(), Mod = read();
  div(1, N, K);
  inv[1] = 1;
  for (int i = 2; i <= 2 * N + 2; i++)
    inv[i] = (Mod - (Mod / i) * inv[Mod % i] % Mod) % Mod;
  for (int i = 1; i <= 2 * N + 2; i++) sm[i] = (sm[i - 1] + inv[i]) % Mod;
  calc(mn);
  calc(mn + 1);
  for (int i = 1; i <= mn; i++) {
    (ans += inv[2] * cnt[mn] % Mod * (cnt[mn] - 1) % Mod * inv[2] % Mod * (mn) %
            Mod) %= Mod;
    ans = (ans -
           cnt[mn] % Mod * (cnt[mn] - 1) % Mod * inv[2] % Mod *
               ((sm[mn + i] - sm[i] + Mod) % Mod) % Mod +
           Mod) %
          Mod;
    (ans += inv[2] * cnt[mn] % Mod * cnt[mn + 1] % Mod * (mn + 1) % Mod) %= Mod;
    ans = (ans -
           cnt[mn] * cnt[mn + 1] % Mod *
               ((sm[mn + i + 1] - sm[i] + Mod) % Mod) % Mod +
           Mod) %
          Mod;
    (ans += inv[2] * cnt[mn + 1] % Mod * (cnt[mn + 1] - 1) % Mod * inv[2] %
            Mod * (mn + 1) % Mod) %= Mod;
    ans = (ans -
           cnt[mn + 1] % Mod * (cnt[mn + 1] - 1) % Mod * inv[2] % Mod *
               ((sm[mn + i + 1] - sm[i] + Mod) % Mod) % Mod +
           Mod) %
          Mod;
  }
  int i = mn + 1;
  (ans += inv[2] * cnt[mn + 1] % Mod * (cnt[mn + 1] - 1) % Mod * inv[2] % Mod *
          (mn + 1) % Mod) %= Mod;
  ans = (ans -
         cnt[mn + 1] % Mod * (cnt[mn + 1] - 1) % Mod * inv[2] % Mod *
             ((sm[mn + i + 1] - sm[i] + Mod) % Mod) % Mod +
         Mod) %
        Mod;
  cout << ans << endl;
  return 0;
}
