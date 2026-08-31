#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    set<int> s;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      s.insert(x);
    }
    bool is_no = true;
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      if (s.count(x) && is_no) {
        cout << "YES" << endl;
        cout << 1 << " " << x << endl;
        is_no = false;
      }
    }
    if (is_no) {
      cout << "NO" << endl;
    }
  }
  return 0;
}
