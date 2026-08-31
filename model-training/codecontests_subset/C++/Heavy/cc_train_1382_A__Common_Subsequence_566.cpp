#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n];
    vector<int> v;
    int b[m];
    int g[1005] = {0};
    int h[1005] = {0};
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      g[a[i]]++;
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      h[b[i]]++;
    }
    int ct = 0;
    for (int i = 0; i < 1005; i++) {
      if (g[i] > 0 && h[i] > 0) {
        ct++;
        v.push_back(i);
      }
    }
    if (ct == 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
      if (ct == 1) {
        cout << ct << " ";
        cout << v[0] << endl;
      } else {
        cout << "1"
             << " ";
        cout << v[0] << endl;
      }
    }
  }
  return 0;
}
