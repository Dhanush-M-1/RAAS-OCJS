#include <bits/stdc++.h>
using namespace std;
int main(int argc, char *argv[]) {
  int n, m;
  cin >> n >> m;
  vector<int> w(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> w[i];
  }
  vector<int> r(m);
  for (int i = 0; i < m; i++) {
    cin >> r[i];
    r[i]--;
  }
  vector<int> before(n, -1);
  int ans = 0;
  for (int i = 0; i < m; i++) {
    int x = r[i];
    set<int> z;
    for (int j = before[x] + 1; j < i; j++) {
      int y = r[j];
      if (!z.count(y)) {
        ans += w[y];
        z.insert(y);
      }
    }
    before[x] = i;
  }
  cout << ans << endl;
  return 0;
}
