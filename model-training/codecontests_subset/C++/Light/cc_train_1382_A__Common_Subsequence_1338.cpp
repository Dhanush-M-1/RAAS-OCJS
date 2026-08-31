#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n];
    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      mp[a[i]]++;
    }
    int b[m];
    int ans = -1;
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      if (mp[b[i]] > 0) {
        ans = b[i];
      }
    }
    if (ans == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << "1"
           << " " << ans << endl;
    }
  }
}
