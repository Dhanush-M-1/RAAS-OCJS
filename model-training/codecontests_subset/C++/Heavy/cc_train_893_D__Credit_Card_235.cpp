#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5;
long long n, k;
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> k;
  long long a[n];
  for (long long i = 0; i < n; i++) cin >> a[i];
  long long curr_bank = 0, ans = 0, mini, flag = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (curr_bank < 0) {
        curr_bank = k;
        ans++;
        mini = k;
      } else {
        mini = min(mini, curr_bank);
      }
      continue;
    }
    if (curr_bank + a[i] > k) {
      if (ans == 0) {
        flag = 1;
        break;
      }
      long long diff = curr_bank + a[i] - k;
      curr_bank = k;
      mini -= diff;
      if (mini < 0) {
        flag = 1;
        break;
      }
    } else {
      curr_bank += a[i];
    }
  }
  if (flag)
    cout << -1;
  else
    cout << ans;
}
