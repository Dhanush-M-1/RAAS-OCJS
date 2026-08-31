#include <bits/stdc++.h>
using namespace std;
void debug_out() { cerr << endl; }
void clock_out() {
  cerr << "\nTime Elapsed : " << 1.0 * clock() / CLOCKS_PER_SEC << " s\n";
}
void fileio() {
  freopen("/home/dwai/Desktop/cp/input.txt", "r", stdin);
  freopen("/home/dwai/Desktop/cp/output.txt", "w", stdout);
  freopen("/home/dwai/Desktop/cp/debug.txt", "w", stderr);
}
void ofileio() {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << H;
  debug_out(T...);
}
int IT_MAX = 1 << 20;
const long long MOD = 1000000007;
const int INF = 0x3f3f3f3f;
const long long LL_INF = 0x3f3f3f3f3f3f3f3f;
const double PI = acos(-1);
const double ERR = 1e-10;
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  long long lev = 1;
  long long cnt = 0;
  vector<long long> ans;
  while (cnt < r && lev < n) {
    long long x = (n - lev) * 2;
    if (cnt + x < l) {
      lev++;
      cnt += x;
      continue;
    }
    x = lev;
    while (cnt < r && x < n) {
      cnt++;
      if (cnt >= l && cnt <= r) {
        ans.emplace_back(lev);
      }
      cnt++;
      x++;
      if (cnt >= l && cnt <= r) {
        ans.emplace_back(x);
      }
    }
    lev++;
  }
  if (++cnt <= r) {
    ans.emplace_back(1);
  }
  for (long long x : ans) cout << x << " ";
  cout << "\n";
}
int main() {
  42;
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  srand(time(NULL));
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
