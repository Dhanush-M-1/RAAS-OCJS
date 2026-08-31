#include <bits/stdc++.h>
using namespace std;
const int N = 2e6 + 10;
int mod = 1e9 + 7;
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return res;
}
long long INV(long long a) { return power(a, mod - 2); }
mt19937 Rand(123456);
int Range(int l, int r) { return l + Rand() % (r - l + 1); }
map<long long, long long> mp;
void work(int l, int r, int k) {
  if (k == 1 || l == r) {
    ++mp[r - l + 1];
    return;
  }
  int mid = (l + r) / 2;
  work(l, mid, k - 1);
  work(mid + 1, r, k - 1);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, k;
  cin >> n >> k >> mod;
  vector<long long> inv(2 * n), inv_sum;
  for (int i = 0; i <= 2 * n - 1; i++) inv[i] = INV(i);
  inv_sum = inv;
  for (int i = 1; i <= 2 * n - 1; i++) inv_sum[i] += inv_sum[i - 1];
  for (auto& I : inv_sum) I %= mod;
  auto merge = [&](int l, int r, const vector<long long>& inv_sum) {
    long long res = (long long)l * r % mod * INV(2) % mod;
    for (int i = 1; i <= l; i++) res -= inv_sum[i + r] - inv_sum[i];
    res %= mod;
    res += mod;
    return res % mod;
  };
  work(1, n, k);
  long long res = 0;
  for (auto I : mp)
    res += (I.first * (I.first - 1) % mod * INV(4) % mod) * I.second % mod,
        res += I.second * (I.second - 1) % mod * INV(2) % mod *
               merge(I.first, I.first, inv_sum) % mod;
  for (auto I : mp)
    for (auto J : mp)
      if (I.first < J.first)
        res +=
            merge(I.first, J.first, inv_sum) * I.second % mod * J.second % mod;
  res %= mod;
  res += mod;
  res %= mod;
  cout << res;
}
