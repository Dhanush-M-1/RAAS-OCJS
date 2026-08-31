#include <bits/stdc++.h>
using namespace std;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count() *
               ((uint64_t) new char | 1));
long long get_random_int(long long a, long long b) {
  return uniform_int_distribution<long long>(a, b)(rng);
}
int main() {
  ios_base::sync_with_stdio(false);
  cout << fixed;
  cout.precision(10);
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnt8 = 0;
  int cntr = 0;
  for (int i = 0; i < n; ++i) {
    if (s[i] == '8') {
      cnt8++;
    } else {
      cntr++;
    }
  }
  int res = 0;
  for (int i = cnt8; i >= 0; --i) {
    res = max(res, min(i, cntr / 10));
    cntr++;
  }
  cout << res;
  return 0;
}
