#include <bits/stdc++.h>
using namespace std;
struct custom_hash {
  static uint64_t splitmix64(uint64_t x) {
    x += 0x9e3779b97f4a7c15;
    x = (x ^ (x >> 30)) * 0xbf58476d1ce4e5b9;
    x = (x ^ (x >> 27)) * 0x94d049bb133111eb;
    return x ^ (x >> 31);
  }
  size_t operator()(uint64_t x) const {
    static const uint64_t FIXED_RANDOM =
        chrono::steady_clock::now().time_since_epoch().count();
    return splitmix64(x + FIXED_RANDOM);
  }
};
const long long MOD = 1e9 + 7;
const long long INF = 1e9 + 8;
const double pi = 3.14159265359;
long long binpow(long long a, long long b, long long m) {
  a %= m;
  long long res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % m;
    a = a * a % m;
    b >>= 1;
  }
  return res;
}
long long inverse(long long x) { return binpow(x, MOD - 2, MOD); }
void solve() {
  long long n;
  cin >> n;
  string arr[n];
  for (long long i = 0; i < n; i++) cin >> arr[i];
  long long x1 = (arr[1][0] - '0');
  long long x2 = (arr[0][1] - '0');
  long long y1 = (arr[n - 1][n - 2] - '0');
  long long y2 = (arr[n - 2][n - 1] - '0');
  vector<pair<long long, long long> > ans;
  if (x1 == x2 && y1 == y2) {
    if (x1 == y1) {
      ans.push_back(make_pair(2, 1));
      ans.push_back(make_pair(1, 2));
    }
  } else if (x1 == x2 && y1 != y2) {
    if (x1 == y1)
      ans.push_back(make_pair(n, n - 1));
    else
      ans.push_back(make_pair(n - 1, n));
  } else if (x1 != x2 && y1 == y2) {
    if (x1 == y1)
      ans.push_back(make_pair(2, 1));
    else
      ans.push_back(make_pair(1, 2));
  } else if (x1 != x2 && y1 != y2) {
    if (x1 == y1) {
      ans.push_back(make_pair(2, 1));
      ans.push_back(make_pair(n - 1, n));
    } else {
      ans.push_back(make_pair(2, 1));
      ans.push_back(make_pair(n, n - 1));
    }
  }
  cout << ans.size() << endl;
  if (ans.size() == 0) {
    return;
  }
  for (long long i = 0; i < ans.size(); i++)
    cout << ans[i].first << " " << ans[i].second << endl;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  long long t;
  cin >> t;
  while (t--) solve();
  cerr << "Time elapsed : " << 1.0 * clock() / CLOCKS_PER_SEC << " sec \n ";
}
