#include <bits/stdc++.h>
using namespace std;
int local;
void solve() {
  int n, m;
  cin >> n >> m;
  vector<int> ar1(n), ar2(m);
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    ar1[i] = x;
  }
  for (int i = 0; i < m; i++) {
    int x;
    cin >> x;
    ar2[i] = x;
  }
  int ct = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (ar1[i] == ar2[j]) {
        cout << "YES" << endl;
        cout << 1 << " " << ar1[i] << endl;
        return;
      }
    }
  }
  cout << "NO" << endl;
}
int main(void) {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  local = 1;
  if (local) {
    int tc;
    cin >> tc;
    while (tc--) solve();
  } else
    solve();
  return 0;
}
