#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  long long l, r, len;
  cin >> n >> l >> r;
  l--, r--;
  len = (r - l + 1);
  int i = 0;
  for (; i < n; i++) {
    if ((n - i - 1) * 2 <= l) {
      l -= (n - i - 1) * 2;
      r -= (n - i - 1) * 2;
    } else {
      break;
    }
  }
  vector<int> ans;
  for (int j = l / 2 + i + 1; j < n; j++) {
    ans.push_back(i);
    ans.push_back(j);
  }
  r -= l / 2 * 2;
  l -= l / 2 * 2;
  for (i++; i < n && ans.size() <= r; i++) {
    for (int j = i + 1; j < n && ans.size() <= r; j++) {
      ans.push_back(i);
      ans.push_back(j);
    }
  }
  ans.push_back(0);
  for (int i = l; i <= r; i++) {
    cout << ans[i] + 1 << " ";
  }
  cout << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin.sync_with_stdio(0);
  cout.tie(0);
  cout.sync_with_stdio(0);
  cout.precision(9);
  int q;
  cin >> q;
  while (q--) {
    solve();
  }
  return 0;
}
