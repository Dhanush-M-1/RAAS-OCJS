#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> pre(n + 1);
    for (int i = 1; i <= n; i++) {
      pre[i] = pre[i - 1] + 2 * (n - i);
    }
    pre[n]++;
    for (long long i = l; i <= r; i++) {
      int pos = lower_bound(pre.begin(), pre.end(), i) - pre.begin();
      if (pos == n)
        cout << "1"
             << " ";
      else {
        long long j = i - pre[pos - 1];
        if (j % 2 == 1)
          cout << pos << " ";
        else
          cout << (j / 2 + pos) << " ";
      }
    }
    cout << endl;
  }
  return 0;
}
