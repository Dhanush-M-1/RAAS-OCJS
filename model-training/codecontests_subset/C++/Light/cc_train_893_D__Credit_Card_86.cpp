#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m;
  cin >> n >> m;
  long long a[n + 1];
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
  }
  long long extra_money = 0;
  long long times = 0;
  long long sum_till_here = 0;
  for (long long i = 1; i <= n; i++) {
    sum_till_here += a[i];
    if (sum_till_here > m) {
      if (times == 0) {
        cout << "-1\n";
        return 0;
      } else {
        long long diff = sum_till_here - m;
        sum_till_here = m;
        extra_money -= diff;
        if (extra_money < 0) {
          cout << "-1\n";
          return 0;
        }
      }
    }
    if (a[i] == 0) {
      if (sum_till_here < 0) {
        extra_money = m;
        sum_till_here = m;
        times++;
      } else {
        extra_money = min(extra_money, sum_till_here);
      }
    }
  }
  cout << times << "\n";
}
