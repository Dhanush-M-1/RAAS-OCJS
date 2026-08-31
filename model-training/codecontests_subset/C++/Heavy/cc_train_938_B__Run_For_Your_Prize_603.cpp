#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
void task_solver() {
  long long n;
  while (cin >> n) {
    vector<long long> a(n);
    for (long long i = 0; i < n; i++) cin >> a[i];
    long long ans1 = 0, ans2 = 0;
    long long right = 1e6, left = 1;
    sort((a).begin(), (a).end());
    for (long long i = 0; i < n; i++) {
      if (a[i] <= 500000) {
        ans1 = a[i];
        left = a[i];
      } else {
        ans2 = max(1000000 - a[i], ans2);
        right = a[i];
      }
    }
    cout << max(ans1 - 1, ans2) << endl;
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  task_solver();
  return 0;
}
