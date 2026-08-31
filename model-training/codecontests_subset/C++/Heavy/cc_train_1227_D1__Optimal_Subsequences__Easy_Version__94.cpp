#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e12;
int main() {
  int n;
  cin >> n;
  vector<int> a(n), s;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  s = a;
  sort(s.begin(), s.end());
  int m;
  cin >> m;
  for (int i = 0; i < m; ++i) {
    int k, pos;
    cin >> k >> pos;
    int c = 0;
    vector<int> ans, st(k);
    while (c < k) {
      st[c] = s[n - 1 - c];
      ++c;
    }
    sort(st.begin(), st.end());
    for (int q = 0; q < n; ++q) {
      bool flag = false;
      for (int j = 0; j < st.size(); ++j) {
        if (a[q] == st[j]) {
          flag = true;
          st.erase(st.begin() + j);
          break;
        }
      }
      if (flag && ans.size() < k) {
        ans.push_back(a[q]);
      }
    }
    cout << ans[pos - 1] << "\n";
  }
}
