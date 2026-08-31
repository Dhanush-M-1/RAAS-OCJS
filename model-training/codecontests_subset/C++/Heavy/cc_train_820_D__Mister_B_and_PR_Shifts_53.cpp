#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18 + 239;
long long my_get(long long n, vector<long long> p, long long x) {
  long long cnt_minus = 0;
  long long cnt_plus = 0;
  vector<long long> by_step(n);
  for (long long i = 0; i < n; i++) {
    if (p[i] - i <= 0) {
      cnt_plus++;
    } else {
      cnt_minus++;
    }
    if (p[i] - i > 0) {
      by_step[p[i] - i]++;
    }
    if (p[i] - i <= 0) {
    }
  }
  long long cur = 0;
  for (long long i = 0; i < n; i++) {
    cur += abs(p[i] - i);
  }
  long long best = INF;
  long long ans = -1;
  for (long long i = 0; i < n; i++) {
    if (i > 0) {
      long long ind = (n - i);
      cur -= abs(n - p[ind]);
      cur += abs(0 - p[ind]);
    }
    if (i == x) {
      return cur;
    }
    if (cur < best) {
      best = cur;
      ans = i;
    }
    cur = cur + cnt_plus - cnt_minus;
    if (i + 1 <= n) {
      long long pos = (n - (i + 1));
      if (p[pos] != 0) {
        cnt_plus--;
        cnt_minus++;
        if (i + p[pos] + 1 < n) {
          by_step[i + p[pos] + 1]++;
        }
      }
    }
    if (i + 1 < n) {
      cnt_plus += by_step[i + 1];
      cnt_minus -= by_step[i + 1];
    }
  }
  cout << best << '\n';
  cout << ans << '\n';
  return -1;
}
long long stupid_get(long long n, vector<long long> p, long long x) {
  while (x > 0) {
    auto f = p.back();
    p.pop_back();
    p.insert(p.begin(), f);
    x--;
  }
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    ans += abs(p[i] - i);
  }
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n;
  cin >> n;
  vector<long long> p(n);
  for (auto &t : p) {
    cin >> t;
    t--;
  }
  my_get(n, p, -1);
}
