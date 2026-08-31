#include <bits/stdc++.h>
using namespace std;
bool test_cases_exist = false;
class FenwickTree {
 public:
  vector<long long int> tree;
  long long int n;
  FenwickTree(long long int n) {
    this->n = n;
    tree.resize(n + 5);
  }
  void update(long long int ind, long long int delta) {
    while (ind <= n) {
      tree[ind] += delta;
      ind += ind & -ind;
    }
  }
  long long int query(long long int ind) {
    long long int res = 0;
    while (ind >= 1) {
      res += tree[ind];
      ind -= ind & -ind;
    }
    return res;
  }
};
void solve() {
  long long int n;
  cin >> n;
  vector<pair<long long int, long long int>> pnt(n);
  for (auto &z : pnt) cin >> z.first;
  for (auto &z : pnt) cin >> z.second;
  vector<long long int> speed;
  for (auto &z : pnt) speed.push_back(z.second);
  sort(pnt.begin(), pnt.end());
  sort(speed.begin(), speed.end());
  long long int ans = 0;
  vector<FenwickTree> ft(2, {n});
  for (auto z : pnt) {
    int pos = lower_bound(speed.begin(), speed.end(), z.second) - speed.begin();
    ans += ft[0].query(pos + 1) * z.first;
    ans -= ft[1].query(pos + 1);
    ft[0].update(pos + 1, 1);
    ft[1].update(pos + 1, z.first);
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  if (test_cases_exist) cin >> t;
  while (t--) solve();
}
