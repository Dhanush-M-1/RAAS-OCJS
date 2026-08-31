#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e9 + 7;
const long long INF = 1LL << 60;
const long long mod = 1e9 + 7;
const long double eps = 1e-8;
const long double pi = acos(-1.0);
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class Abel>
struct BIT {
 private:
  vector<Abel> node;
  long long n;
  Abel UNITY_SUM = 0;

 public:
  BIT(long long n_) {
    n = n_;
    node.resize(n, UNITY_SUM);
  }
  void add(long long a, Abel w) {
    for (long long i = a; i < n; i |= i + 1) node[i] += w;
  }
  Abel sum(long long a) {
    Abel ret = UNITY_SUM;
    for (long long i = a - 1; i >= 0; i = (i & (i + 1)) - 1) ret += node[i];
    return ret;
  }
  Abel sum(long long a, long long b) { return sum(b) - sum(a); }
  long long get(long long k) {
    ++k;
    long long res = 0;
    long long n = 1;
    while (n < (long long)node.size()) n *= 2;
    for (long long i = n / 2; i > 0; i /= 2) {
      if (res + i < (long long)node.size() && node[res + i - 1] < k) {
        k -= node[res + i - 1];
        res += i;
      }
    }
    return res;
  }
  void print() {
    for (long long i = 0; i < n; ++i) cout << sum(i, i + 1) << ",";
    cout << endl;
  }
};
void solve() {
  long long n;
  cin >> n;
  vector<long long> p(n);
  map<long long, long long> mp;
  for (long long i = 0; i < n; i++) {
    cin >> p[i];
    mp[p[i]] = i;
  }
  BIT<long long> bit(n + 1);
  BIT<long long> bit2(n + 1);
  long long now = 0;
  for (long long i = 1; i <= n; ++i) {
    long long ans = 0;
    bit.add(mp[i], 1);
    bit2.add(mp[i], mp[i]);
    long long j1 = bit.get((i + 1) / 2 - 1);
    long long j2 = j1 + 1;
    if (i & 1) {
      ans += j1 * bit.sum(0, j1) - bit2.sum(0, j1);
      ans += bit2.sum(j1 + 1, n) - j1 * bit.sum(j1 + 1, n);
      long long k = i / 2;
      ans -= k * (k + 1);
    } else {
      ans += j1 * bit.sum(0, j1) - bit2.sum(0, j1);
      ans += bit2.sum(j2 + 1, n) - j2 * bit.sum(j2 + 1, n);
      long long k = (i - 2) / 2;
      ans -= k * (k + 1);
    }
    now += bit.sum(mp[i] + 1, n);
    ans += now;
    cout << ans << " ";
  }
  cout << endl;
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  solve();
  return 0;
}
