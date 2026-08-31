#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n];
    int b[m];
    vector<int> v;
    unordered_map<int, int> ans;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      ans[a[i]]++;
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      if (ans[b[i]] >= 1) {
        v.push_back(b[i]);
      }
    }
    if (v.size() == 0) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
      cout << 1 << " " << v[0] << endl;
    }
  }
}
