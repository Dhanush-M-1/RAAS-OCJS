#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007, N = 1e5 + 5, M = 1e5 + 5, INF = 0x3f3f3f3f;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    if (l == r && l == n * (n - 1) + 1) {
      cout << 1 << endl;
      continue;
    }
    int nowx = 1, nowy = 2;
    long long sum = 0;
    while (sum < l) {
      sum += 2 * (n - nowx);
      ++nowx;
    }
    --nowx;
    sum -= 2 * (n - nowx);
    ++sum;
    vector<int> ans;
    nowy = nowx + 1;
    int di = 1;
    int cnt = sum;
    while (sum <= r) {
      if (di)
        ans.push_back(nowx);
      else {
        ans.push_back(nowy);
        ++nowy;
        if (nowy > n) {
          nowx++;
          nowy = nowx + 1;
          if (nowx > n) nowx = 1;
        }
      }
      ++sum;
      di ^= 1;
    }
    if (r == n * (n - 1) + 1) ans[ans.size() - 1] = 1;
    cout << ans[l - cnt];
    for (long long i = l - cnt + 1; i <= r - cnt; ++i) cout << ' ' << ans[i];
    cout << endl;
  }
  return 0;
}
