#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  vector<int> d(n + 1);
  for (int i = 1; i <= n - 1; ++i) {
    int u, v;
    cin >> u >> v;
    d[u]++, d[v]++;
  }
  bool ok = 1;
  for (int i = 1; i <= n; ++i) {
    if (d[i] == 2) {
      ok = 0;
      break;
    }
  }
  if (!ok) {
    cout << "no"
         << "\n";
  } else {
    cout << "yes"
         << "\n";
  }
  return 0;
}
