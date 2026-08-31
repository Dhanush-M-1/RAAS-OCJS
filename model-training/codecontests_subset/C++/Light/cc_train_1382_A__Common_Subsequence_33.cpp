#include <bits/stdc++.h>
using namespace std;
bool vis[1005];
int arr[1005];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
      cin >> arr[i];
      vis[arr[i]] = 1;
    }
    int ans = -1;
    int b;
    for (int i = 0; i < m; i++) {
      cin >> b;
      if (vis[b]) ans = b;
    }
    memset(vis, 0, sizeof(vis));
    if (ans == -1)
      cout << "NO" << endl;
    else
      cout << "YES\n1 " << ans << endl;
  }
  return 0;
}
