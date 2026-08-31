#include <bits/stdc++.h>
using namespace std;
int a[512], b[1024];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> a[i];
  int ans = 0;
  for (int i = 0; i < m; i++) {
    cin >> b[i];
    int now = 0;
    set<int> st;
    for (int j = i - 1; j >= 0 && b[i] != b[j]; j--) {
      if (st.find(b[j]) == st.end()) now += a[b[j]];
      st.insert(b[j]);
    }
    ans += now;
  }
  cout << ans << endl;
  return 0;
}
