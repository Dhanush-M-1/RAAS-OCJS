#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(rand());
long long inf = 1e9;
long long mod = 1e9 + 7;
long long big_inf = 1e18;
signed main() {
  ios_base::sync_with_stdio(false);
  long long n;
  cin >> n;
  vector<long long> a(n);
  set<pair<long long, long long> > s1;
  long long s2_size = 0;
  vector<long long> set_val(n);
  long long my_sum = 0;
  for (long long i = 0; i < n; ++i) {
    cin >> a[i];
    long long r = i + 1 - a[i];
    set_val[i] = r;
    if (r < 0)
      s1.insert({r, i});
    else
      s2_size++;
    my_sum += abs(i + 1 - a[i]);
  }
  long long j = n - 1;
  long long ans = my_sum;
  long long ans_num = 0;
  for (long long i = 0; i < n - 1; ++i) {
    my_sum -= abs(n - a[j]);
    my_sum += abs(1 - a[j]);
    my_sum -= s1.size();
    my_sum += s2_size - 1;
    if (my_sum < ans) {
      ans = my_sum;
      ans_num = i + 1;
    }
    while (s1.size() && s1.rbegin()->first + i + 1 >= 0) {
      s2_size++;
      s1.erase(*s1.rbegin());
    }
    if (a[j] > 1) {
      s2_size--;
      s1.insert({1 - a[j] - i - 1, j});
    }
    --j;
  }
  cout << ans << " " << ans_num;
  return 0;
}
