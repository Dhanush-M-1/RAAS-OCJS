#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 20;
int n;
pair<int, int> p[N];
struct node {
  long long sum, count;
  node(long long s = 0, long long c = 0) : sum(s), count(c) {}
} bit[N];
void update(int x, int delta) {
  for (; x <= n; x += x & -x) {
    auto &[sum, count] = bit[x];
    sum += delta;
    count++;
  }
}
node query(int x) {
  auto ans = node();
  for (; x > 0; x -= x & -x) {
    auto &[sum, count] = bit[x];
    ans.sum += sum;
    ans.count += count;
  }
  return ans;
}
int compress(vector<int> &v) {
  if (v.empty()) return 0;
  vector<int> s = v;
  sort(s.begin(), s.end());
  s.resize(unique(s.begin(), s.end()) - s.begin());
  int mx = 1;
  for (int &x : v) {
    x = lower_bound(s.begin(), s.end(), x) - s.begin() + 1;
    mx = max(mx, x);
  }
  return mx;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> p[i].first;
  for (int i = 0; i < n; i++) cin >> p[i].second;
  sort(p, p + n);
  vector<int> vec(n);
  for (int i = 0; i < n; i++) vec[i] = p[i].second;
  compress(vec);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    auto [sum, cnt] = query(vec[i]);
    ans += cnt * p[i].first - sum;
    update(vec[i], p[i].first);
  }
  cout << ans;
}
