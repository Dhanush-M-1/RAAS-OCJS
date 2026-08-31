#include <bits/stdc++.h>
using namespace std;
const long long int N = 100005;
void solve() {
  long long int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
  long long int l, r;
  cin >> n >> l >> r;
  vector<long long int> temp;
  for (i = 1; i < n; i++) {
    temp.push_back(2 * (n - i));
  }
  temp.push_back(1);
  m = temp.size();
  cnt = 1;
  for (i = 0; i < m; i++) {
    if (cnt + temp[i] > l) {
      break;
    } else {
      cnt += temp[i];
    }
  }
  i++;
  if (i > n) {
    i = 1;
  }
  j = i + 1;
  ans = 0;
  long long int cur = i;
  while (cnt <= r) {
    if (cnt == n * (n - 1) + 1) {
      cout << 1;
      break;
    }
    if (cnt >= l) {
      cout << cur << " ";
    }
    if (ans == 0) {
      cur = j;
      j++;
    } else {
      if (j == n + 1) {
        i++;
        j = i + 1;
      }
      cur = i;
    }
    ans ^= 1;
    cnt++;
  }
  cout << '\n';
  return;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
