#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, n, res, m, x, flag;
  cin >> t;
  while (t--) {
    vector<long long> v1, v2;
    vector<long long>::iterator it;
    cin >> n >> m;
    flag = 0;
    for (long long i = 0; i < n; i++) {
      cin >> x;
      v1.push_back(x);
    }
    for (long long i = 0; i < m; i++) {
      cin >> x;
      v2.push_back(x);
    }
    for (long long i = 0; i < n; i++) {
      it = find(v2.begin(), v2.end(), v1[i]);
      if (it != v2.end()) {
        res = *it;
        flag = 1;
        break;
      }
    }
    if (flag == 1) {
      cout << "YES\n";
      cout << "1 " << res << "\n";
    } else {
      cout << "NO\n";
    }
  }
}
