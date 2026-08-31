#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m;
  cin >> n >> m;
  long long a[n + 1];
  long long pre[n + 1];
  pre[0] = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    pre[i] = pre[i - 1] + a[i];
  }
  long long max_in_pre_i_to_n[n + 1];
  max_in_pre_i_to_n[n] = pre[n];
  for (long long i = n - 1; i >= 1; i--) {
    max_in_pre_i_to_n[i] = max(pre[i], max_in_pre_i_to_n[i + 1]);
  }
  long long sum_till_here = 0;
  long long extra_deposit = 0;
  long long times = 0;
  for (long long i = 1; i <= n; i++) {
    sum_till_here += a[i];
    if (sum_till_here > m) {
      cout << "-1\n";
      return 0;
    }
    if (a[i] == 0 && sum_till_here < 0) {
      long long how_much_i_have_to_deposit = -1 * sum_till_here;
      long long next_max_value = max_in_pre_i_to_n[i] - pre[i];
      if (next_max_value > m) {
        cout << "-1\n";
        return 0;
      }
      sum_till_here = m - next_max_value;
      times++;
    }
  }
  cout << times << "\n";
}
