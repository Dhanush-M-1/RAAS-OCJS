#include <bits/stdc++.h>
using namespace std;
const long long int MOD = 1000000007;
long long int modpow(long long int a, long long int b, long long int mod) {
  long long int res = 1;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a;
    res %= mod;
    a = a * a;
    a %= mod;
  }
  return res;
}
long long int p(long long int a, long long int b) {
  long long int res = 1;
  for (; b; b >>= 1) {
    if (b & 1) res = res * a;
    a = a * a;
  }
  return res;
}
void testcases() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> a(n);
  for (long long int i = (long long int)0; i < (long long int)n; ++i)
    cin >> a[i];
  set<pair<long long int, long long int>> meme;
  for (long long int i = (long long int)0; i < (long long int)k; ++i) {
    long long int x;
    long long int y;
    cin >> x >> y;
    meme.insert({x, y});
  }
  set<long long int> hold;
  long long int ans = 0;
  for (long long int i = (long long int)n - 2; i >= (long long int)0; --i) {
    if (meme.find({a[i], a[n - 1]}) == meme.end()) {
      hold.insert(a[i]);
      continue;
    } else {
      long long int flag = 1;
      for (long long int j : hold) {
        if (meme.find({a[i], j}) == meme.end()) {
          flag = 0;
          break;
        }
      }
      if (!flag) {
        hold.insert(a[i]);
        continue;
      }
      ans++;
    }
  }
  cout << ans << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  t = 1;
  while (t--) testcases();
}
