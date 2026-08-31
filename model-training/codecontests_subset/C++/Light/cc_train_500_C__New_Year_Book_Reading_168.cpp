#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int a[n], b[m];
  int i, j, k, l;
  for (i = 0; i < n; i++) cin >> a[i];
  vector<int> v;
  for (i = 0; i < m; i++) {
    cin >> j;
    b[i] = j;
    if (v.size() != 0) {
      if (find(v.begin(), v.end(), j) == v.end()) v.push_back(j);
    } else
      v.push_back(j);
  }
  stack<int> s, st;
  for (i = v.size() - 1; i >= 0; i--) {
    s.push(v[i]);
  }
  int ans = 0;
  for (i = 0; i < m; i++) {
    while (s.top() != b[i]) {
      ans += a[s.top() - 1];
      st.push(s.top());
      s.pop();
    }
    int p = s.top();
    s.pop();
    while (st.size() != 0) {
      s.push(st.top());
      st.pop();
    }
    s.push(p);
  }
  cout << ans;
}
