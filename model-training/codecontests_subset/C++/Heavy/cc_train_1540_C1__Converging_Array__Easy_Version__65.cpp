#include <bits/stdc++.h>

using namespace std;
#define sz(a) (int)(a).size()
#define rep(i, a, b) for (int i = (a), _b = (b); i < _b; ++i)
#define debug(a) cerr << #a << ": " << (a) << '\n';
#define debug_arr(a, n) { cerr << #a << " "; rep(i, 0, n) cerr << a[i] << " \n"[(i + 1) == n]; }
#define debug_two(a, b) cerr << #a << ": " << (a) << ", " << #b << ": " << (b) << '\n';

template <typename num_t>
inline void add_mod(num_t& a, const long long& b, const int& m) { a = (a + b) % m; if (a < 0) a += m; }
template <typename num_t>
inline bool update_max(num_t& a, const num_t& b) { return a < b ? a = b, true : false; }
template <typename num_t>
inline bool update_min(num_t& a, const num_t& b) { return a > b ? a = b, true : false; }
template <typename num_t>
num_t gcd(num_t lhs, num_t rhs) { return !lhs ? rhs : gcd(rhs % lhs, lhs); }
template <typename num_t>
num_t pw(num_t n, num_t k, num_t mod) {
  num_t res = 1; for (; k > 0; k >>= 1) { if (k & 1) res = 1ll * res * n % mod; n = 1ll * n * n % mod; } return res;
}
int invserse(int n, int mod) {
  return pw(n, mod - 2, mod);
}

typedef long long int64;
const int mod = 1e9 + 7;

void solve() {
  int n;
  cin >> n;
  vector<int> c(n); rep(i, 0, n) cin >> c[i];
  vector<int> b(n, 0);
  rep(i, 1, n) { 
    cin >> b[i];
    b[i] += b[i - 1];
  }
  vector<int> sum_b(n, 0);
  rep(i, 0, n) {
    sum_b[i] = b[i];
    if (i) sum_b[i] += sum_b[i - 1];
  }

  const int base = 10000;

  int q = 0; cin >> q;
  while (q-- > 0) {
    int x; cin >> x;
    if (x > c[0]) {
      cout << 0; return;
    }
    vector<int> pre, cur;
    cur.assign(base * 2 + 1, 0);
    rep(val, max(0, x), c[0] + 1) {
      cur[val + base] = 1;
    }
    rep(i, 1, sz(cur)) cur[i] += cur[i - 1];

    rep(i, 1, n) {
      pre = cur;
      fill_n(cur.begin(), sz(cur), 0);

      rep(sum, 0, sz(cur)) if (sum - base - sum_b[i] >= (i + 1) * x) {
        cur[sum] = pre[sum];
        if (sum - c[i] - 1 >= 0) {
          add_mod(cur[sum], -pre[sum - c[i] - 1], mod);
        }
      }

      rep(sum, 1, sz(cur)) add_mod(cur[sum], cur[sum - 1], mod);
    }

    cout << cur.back() << '\n';
  }
}

int main() {
  ios_base::sync_with_stdio(0); cin.tie(0);
#ifdef _LOCAL_
  freopen("in.txt", "r", stdin);
#endif
  const bool multiple_test = false;
  int test = 1;
  if (multiple_test)
    cin >> test;

  for(int i = 0; i < test; ++i) {
    //printf("Case #%d: ", i + 1);
    solve();
  }
#ifdef _LOCAL_
  cerr << "\n" << 1.0 * clock() / CLOCKS_PER_SEC << "\n";
#endif
}
