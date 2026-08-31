#include <bits/stdc++.h>
using namespace std;
int t, n, m, a;
bool f1[1005], f2[1005];
int main() {
  cin >> t;
  while (t--) {
    cin >> n >> m;
    memset(f1, 0, sizeof(f1));
    memset(f2, 0, sizeof(f2));
    for (int i = 1; i <= n; i++) cin >> a, f1[a] = 1;
    for (int i = 1; i <= m; i++) cin >> a, f2[a] = 1;
    bool flag = 0;
    for (int i = 0; i <= 1000; i++) {
      if (f1[i] == 1 && f2[i] == 1) {
        cout << "YES" << endl << 1 << " " << i << endl;
        flag = 1;
        break;
      }
    }
    if (flag == 0) cout << "NO" << endl;
  }
}
