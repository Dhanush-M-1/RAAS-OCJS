#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    unordered_set<int> st;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      st.insert(x);
    }
    bool flag = true;
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      if (st.find(x) != st.end() and flag) {
        flag = false;
        cout << "YES" << endl << 1 << " " << x << endl;
      }
    }
    if (flag) {
      cout << "NO" << endl;
    }
  }
}
