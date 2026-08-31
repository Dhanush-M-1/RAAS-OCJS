#include <bits/stdc++.h>
using namespace std;
vector<int> p[300003];
set<int> q;
int z[300003], a[300003], ans;
int main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> a[i];
  while (m--) {
    int u, v;
    cin >> u >> v;
    p[v].push_back(u);
  }
  for (int x : p[a[n - 1]]) q.insert(x);
  for (int i = n - 2; i >= 0; i--) {
    if (q.find(a[i]) != q.end() && z[a[i]] == n - i - 2 - ans) {
      ans++;
    } else {
      for (int x : p[a[i]]) z[x]++;
    }
  }
  cout << ans;
}
