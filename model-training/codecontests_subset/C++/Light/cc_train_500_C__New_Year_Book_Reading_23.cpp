#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9 + 10;
const int MOD = (int)1e9 + 7;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  set<int> s;
  vector<int> lift;
  int n, m, ans = 0;
  cin >> n >> m;
  vector<int> weight(n), days(m);
  for (int i = 0; i < n; i++) cin >> weight[i];
  for (int i = 0; i < m; i++) cin >> days[i];
  stack<int> revOrder, order;
  for (int i = 0; i < m; i++) {
    if (s.count(days[i])) continue;
    revOrder.push(days[i]);
    s.insert(days[i]);
  }
  while (revOrder.size()) order.push(revOrder.top()), revOrder.pop();
  for (int i = 0; i < m; i++) {
    while (order.top() != days[i])
      lift.push_back(order.top()), ans += weight[order.top() - 1], order.pop();
    order.pop();
    for (int i = lift.size() - 1; i >= 0; i--) order.push(lift[i]);
    order.push(days[i]);
    lift.clear();
  }
  cout << ans;
  return 0;
}
