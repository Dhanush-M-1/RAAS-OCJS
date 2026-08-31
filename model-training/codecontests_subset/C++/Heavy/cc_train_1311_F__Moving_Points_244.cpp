#include <bits/stdc++.h>
using namespace std;
struct BIT {
  vector<long long int> bit;
  int n;
  BIT(long long int N) {
    n = N;
    bit.assign(n + 1, 0);
  }
  void add(int idx, int delta) {
    while (idx <= n) {
      bit[idx] += delta;
      idx += (idx & -idx);
    }
  }
  long long int sum(int idx) {
    long long int res = 0;
    while (idx > 0) {
      res += bit[idx];
      idx -= (idx & -idx);
    }
    return res;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int> > p(n);
  for (auto &i : p) cin >> i.first;
  for (auto &i : p) cin >> i.second;
  sort(p.begin(), p.end());
  vector<int> v;
  for (auto i : p) v.push_back(i.second);
  sort(v.begin(), v.end());
  map<int, int> mp;
  int cnt = 0;
  for (auto i : v) mp[i] = ++cnt;
  for (auto &i : p) i.second = mp[i.second];
  long long int ans = 0;
  BIT tree1(n), tree2(n);
  for (auto i : p) {
    long long int cnt = tree1.sum(i.second);
    long long int sum_x = tree2.sum(i.second);
    ans += cnt * i.first - sum_x;
    tree1.add(i.second, 1);
    tree2.add(i.second, i.first);
  }
  cout << ans << '\n';
}
