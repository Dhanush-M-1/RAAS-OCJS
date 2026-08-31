#include <bits/stdc++.h>
using namespace std;
void test() {
  int n, m;
  cin >> n >> m;
  vector<int> a(n), b(m);
  for (auto &it : a) cin >> it;
  for (auto &it : b) cin >> it;
  vector<int> res;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (a[i] == b[j]) res.push_back(a[i]);
    }
  }
  if (res.size() == 0) {
    cout << "NO\n";
    return;
  } else {
    cout << "YES\n";
    cout << "1 " << res.front() << endl;
    return;
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc;
  cin >> tc;
  while (tc--) test();
  return 0;
}
