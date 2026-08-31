#include <bits/stdc++.h>
using namespace std;
long long int t, n, i, j, x, m;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> t;
  while (t--) {
    cin >> n >> m;
    vector<long long int> a;
    vector<long long int> b;
    long long int flag = 0;
    for (i = 0; i < n; i++) {
      cin >> x;
      a.push_back(x);
    }
    for (i = 0; i < m; i++) {
      cin >> x;
      b.push_back(x);
    }
    std::vector<long long int>::iterator u;
    std::vector<long long int>::iterator it;
    for (it = a.begin(); it != a.end(); it++) {
      u = std::find(b.begin(), b.end(), *it);
      if (u != b.end()) {
        cout << "YES" << endl;
        cout << 1 << " " << *it << endl;
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      cout << "NO" << endl;
    }
  }
  return 0;
}
