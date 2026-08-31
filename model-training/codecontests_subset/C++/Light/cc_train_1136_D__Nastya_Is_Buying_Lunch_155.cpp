#include <bits/stdc++.h>
using namespace std;
vector<int> edge[300001];
int p[300001];
set<int> now;
bool check(int x) {
  int cnt = 0;
  for (int it : edge[x])
    if (now.find(it) != now.end()) cnt++;
  return cnt == now.size();
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1, x, y; i <= m; i++) {
    cin >> x >> y;
    edge[x].emplace_back(y);
  }
  now.insert(p[n]);
  int ans = 0;
  for (int i = n - 1; i >= 1; i--)
    if (check(p[i]))
      ans++;
    else
      now.insert(p[i]);
  cout << ans << endl;
}
