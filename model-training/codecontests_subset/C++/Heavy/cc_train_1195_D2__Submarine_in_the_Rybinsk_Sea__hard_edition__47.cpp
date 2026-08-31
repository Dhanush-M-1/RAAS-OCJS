#include <bits/stdc++.h>
using namespace std;
int const INF = (int)1e9 + 1e3;
long long const INFL = (long long)1e18 + 1e6;
mt19937 tw(chrono::high_resolution_clock::now().time_since_epoch().count());
uniform_int_distribution<long long> ll_distr;
long long rnd(long long a, long long b) {
  return ll_distr(tw) % (b - a + 1) + a;
}
const int MOD = 998244353;
void add(int& a, int b) {
  a += b;
  if (a >= MOD) {
    a -= MOD;
  }
}
int sum(int a, int b) {
  add(a, b);
  return a;
}
int mult(int a, int b) { return (long long)a * b % MOD; }
int f(vector<int> const& a, int l) {
  int res = 0;
  int p = 1;
  for (int i = 0; i < max(((int)a.size()), l); ++i) {
    if (i < l) {
      p = mult(p, 10);
    }
    if (i < ((int)a.size())) {
      add(res, mult(a[i], p));
      p = mult(p, 10);
    }
  }
  return res;
}
int f(int l, vector<int> const& b) {
  int res = 0;
  int p = 1;
  for (int i = 0; i < max(l, ((int)b.size())); ++i) {
    if (i < ((int)b.size())) {
      add(res, mult(b[i], p));
      p = mult(p, 10);
    }
    if (i < l) {
      p = mult(p, 10);
    }
  }
  return res;
}
void solve() {
  int n;
  cin >> n;
  vector<int> arr;
  const int MAXL = 11;
  vector<int> of_len(MAXL);
  for (int i = 0; i < n; ++i) {
    int num;
    cin >> num;
    arr.push_back(num);
    int l = 0;
    int tmp = num;
    while (tmp) {
      ++l;
      tmp /= 10;
    }
    of_len[l]++;
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    vector<int> digits;
    int tmp = arr[i];
    while (tmp) {
      digits.push_back(tmp % 10);
      tmp /= 10;
    }
    for (int l = 1; l < MAXL; ++l) {
      int sum = f(digits, l);
      add(ans, mult(sum, of_len[l]));
      sum = f(l, digits);
      add(ans, mult(sum, of_len[l]));
    }
  }
  cout << ans << "\n";
}
int main() {
  cout << setprecision(15) << fixed;
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int test_count = 1;
  for (int test = 1; test <= test_count; ++test) {
    solve();
  }
}
