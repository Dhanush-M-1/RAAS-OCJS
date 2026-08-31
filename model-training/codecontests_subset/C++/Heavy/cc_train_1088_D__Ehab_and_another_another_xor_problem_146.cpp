#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using db = long double;
using str = string;
using pi = pair<int, int>;
using pl = pair<ll, ll>;
using pd = pair<db, db>;
using vi = vector<int>;
using vb = vector<bool>;
using vl = vector<ll>;
using vd = vector<db>;
using vs = vector<str>;
using vpi = vector<pi>;
using vpl = vector<pl>;
using vpd = vector<pd>;
template <class T>
using V = vector<T>;
template <class T, size_t SZ>
using AR = array<T, SZ>;
template <class T>
using PR = pair<T, T>;
template <class T>
int lwb(V<T> &a, const T &b) {
  return int(lower_bound(begin(a), end(a), b) - begin(a));
}
const int MOD = 1e9 + 7;
const int MODD = 998244353;
const int MX = 2e5 + 5;
const ll INF = 1e18;
const db PI = acos((db)-1);
const int dx[4] = {1, 0, -1, 0}, dy[4] = {0, 1, 0, -1};
mt19937 rng((uint32_t)chrono::steady_clock::now().time_since_epoch().count());
mt19937_64 rngl(
    (uint64_t)chrono::steady_clock::now().time_since_epoch().count());
template <class T>
using pqg = priority_queue<T, vector<T>, greater<T>>;
constexpr int pct(int x) { return __builtin_popcount(x); }
constexpr int largest_bit(int x) { return x == 0 ? -1 : 31 - __builtin_clz(x); }
constexpr ll p2(ll x) { return 1LL << x; }
constexpr ll msk2(ll x) { return p2(x) - 1; }
ll cdiv(ll a, ll b) { return a / b + ((a ^ b) > 0 && a % b); }
ll fdiv(ll a, ll b) { return a / b - ((a ^ b) < 0 && a % b); }
template <class T>
bool ckmin(T &a, const T &b) {
  return b < a ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
template <class T, class U>
T fstTrue(T lo, T hi, U first) {
  hi++;
  assert(lo <= hi);
  while (lo < hi) {
    T mid = lo + (hi - lo) / 2;
    first(mid) ? hi = mid : lo = mid + 1;
  }
  return lo;
}
template <class T, class U>
T lstTrue(T lo, T hi, U first) {
  lo--;
  assert(lo <= hi);
  while (lo < hi) {
    T mid = lo + (hi - lo + 1) / 2;
    first(mid) ? lo = mid : hi = mid - 1;
  }
  return lo;
}
template <class T>
void remDup(vector<T> &v) {
  sort(begin(v), end(v));
  v.erase(unique(begin(v), end(v)), end(v));
}
template <class T, class U>
void erase(T &t, const U &u) {
  auto it = t.find(u);
  assert(it != end(t));
  t.erase(it);
}
int query(int c, int d) {
  cout << "? " << c << " " << d << endl;
  int res;
  cin >> res;
  return res;
}
void solve() {
  int a = 0, b = 0, prev = 0;
  bool both_bit_same = false;
  for (int i = (30) - 1; i >= (0); --i) {
    int unset_res;
    if (both_bit_same) {
      unset_res = prev;
    } else {
      unset_res = query(a, b);
    }
    int set_res = query(a | (1 << i), b | (1 << i));
    if (unset_res == set_res) {
      both_bit_same = true;
      prev = set_res;
      int one_or_zero = query(a | (1 << i), b);
      if (one_or_zero == -1) {
        a |= 1 << i;
        b |= 1 << i;
      }
    } else {
      both_bit_same = false;
      if (unset_res == 1) {
        a |= 1 << i;
      } else {
        b |= 1 << i;
      }
    }
  }
  cout << "! " << a << " " << b;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) solve();
  return 0;
}
