#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int KINF = 0x3f3f3f3f;
int main() {
  ios::sync_with_stdio(false);
  int _;
  cin >> _;
  while (_--) {
    int n, m;
    cin >> n >> m;
    int mp[1010];
    memset(mp, 0, sizeof mp);
    bool flag = false;
    for (int i = 0; i < n; ++i) {
      int num;
      cin >> num;
      mp[num]++;
    }
    for (int i = 0; i < m; ++i) {
      int num;
      cin >> num;
      if (mp[num] > 0 && !flag) {
        cout << "YES" << endl;
        cout << 1 << " " << num << endl;
        flag = true;
      }
    }
    if (!flag) cout << "NO" << endl;
  }
  return 0;
}
