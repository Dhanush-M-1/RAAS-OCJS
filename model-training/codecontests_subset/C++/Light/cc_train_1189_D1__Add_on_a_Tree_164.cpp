#include <bits/stdc++.h>
using namespace std;
void func() {
  int n;
  cin >> n;
  vector<int> adj[n + 1];
  for (int i = 0; i < n - 1; i++) {
    int a, b;
    cin >> a >> b;
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  for (int i = 1; i <= n; i++) {
    if (adj[i].size() == 1) continue;
    if (adj[i].size() < 3) {
      cout << "NO" << endl;
      return;
    }
  }
  cout << "YES" << endl;
  return;
}
int main() {
  std::ios::sync_with_stdio(false);
  int t = 1;
  while (t--) func();
  return 0;
}
