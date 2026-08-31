#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, f = 0;
  cin >> n;
  vector<int> V[100008];
  for (int i = 0; i < n - 1; i++) {
    int u, v;
    cin >> u >> v;
    V[u].push_back(v);
    V[v].push_back(u);
  }
  for (int i = 0; i <= n; i++) {
    if (V[i].size() == 2) {
      f = 1;
      break;
    }
  }
  if (f)
    cout << "NO" << endl;
  else
    cout << "YES" << endl;
}
