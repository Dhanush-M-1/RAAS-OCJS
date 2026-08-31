#include <bits/stdc++.h>
using namespace std;
const long long maxn = 200010;
void solve(long long case_no) {
  long long n, l, r, st = 0;
  cin >> n >> l >> r;
  vector<long long> res;
  bool flag = false;
  for (long long i = 1; i <= n; i++) {
    if (st + res.size() >= r) break;
    if (!flag and st + 2 * (n - i) < l) {
      st += 2 * (n - i);
      continue;
    }
    flag = true;
    for (long long j = i + 1; j <= n; j++) res.push_back(i), res.push_back(j);
  }
  if (st + res.size() < r) res.push_back(1);
  l -= st + 1;
  r -= st + 1;
  for (long long i = l; i <= r; i++) cout << res[i] << " ";
  cout << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long test_cnt = 1, case_no = 1;
  cin >> test_cnt;
  while (case_no <= test_cnt) solve(case_no++);
  return 0;
}
