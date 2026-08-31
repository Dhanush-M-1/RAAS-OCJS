#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
long long fast_exp(long long base, long long exp, long long mod) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % mod;
    base = (base * base) % mod;
    exp /= 2;
  }
  return res;
}
int n, k, a, b, q;
int ta[211111];
int tb[211111];
long long bita[211111];
long long flaga[211111];
long long bitb[211111];
long long flagb[211111];
void upd(long long* arr, int p, int v) {
  for (; p <= n; p += (p & (-p))) arr[p] += v;
}
long long sum(long long* arr, int b) {
  long long sm = 0;
  for (; b > 0; b -= (b & (-b))) sm += arr[b];
  return sm;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int type, d, ai;
    cin >> type;
    if (type == 1) {
      cin >> d >> ai;
      long long value = sum(bita, d) - sum(bita, d - 1);
      if (value + ai <= a && !ta[d])
        upd(bita, d, ai);
      else {
        ta[d] = 1;
        upd(bita, d, -value);
        long long fl = sum(flaga, d) - sum(flaga, d - 1);
        if (fl == 0) upd(flaga, d, 1);
      }
      value = sum(bitb, d) - sum(bitb, d - 1);
      if (value + ai <= b && !tb[d])
        upd(bitb, d, ai);
      else {
        tb[d] = 1;
        upd(bitb, d, -value);
        long long fl = sum(flagb, d) - sum(flagb, d - 1);
        if (fl == 0) upd(flagb, d, 1);
      }
    } else {
      int p;
      cin >> p;
      long long before = sum(bitb, p - 1) + b * sum(flagb, p - 1);
      long long after = sum(bita, n) - sum(bita, p + k - 1) +
                        (sum(flaga, n) - sum(flaga, p + k - 1)) * a;
      cout << (before + after) << "\n";
    }
  }
  return 0;
}
