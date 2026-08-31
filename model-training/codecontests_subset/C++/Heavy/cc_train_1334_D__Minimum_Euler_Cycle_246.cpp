#include <bits/stdc++.h>
using namespace std;
long long l, r, curr = 1, n;
vector<long long> ans;
void rec(long long x) {
  if (x == n) {
    if (l <= curr && r >= curr) ans.push_back(1);
    return;
  }
  if (curr > r) return;
  if (curr + 2 * (n - x) - 1 < l) {
    curr += 2 * (n - x);
    rec(x + 1);
    return;
  }
  long long ptr = x + 1;
  for (int i = 0; i < 2 * (n - x); i++) {
    if (l <= curr && r >= curr) {
      if (i % 2 == 0)
        ans.push_back(x);
      else
        ans.push_back(ptr);
    }
    if (i % 2 == 1) ++ptr;
    ++curr;
  }
  rec(x + 1);
}
void solve() {
  cin >> n >> l >> r;
  curr = 1;
  ans.clear();
  rec(1);
  for (int i = 0; i < ans.size(); i++) cout << ans[i] << " ";
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  ;
  cin.tie(NULL);
  int zz;
  cin >> zz;
  for (int zzz = 1; zzz <= zz; zzz++) {
    solve();
  }
  return 0;
}
