#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios_base::sync_with_stdio(false);
  long long int t;
  cin >> t;
  while (t--) {
    map<long long int, long long int> m1;
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m], i;
    for (i = 0; i < n; i++) {
      cin >> a[i];
      m1[a[i]] = 1;
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
    }
    long long int flag = 0;
    for (i = 0; i < m; i++) {
      if (m1[b[i]] == 1) {
        flag = 1;
        cout << "YES\n";
        cout << 1 << " " << b[i] << "\n";
        break;
      }
    }
    if (flag == 0) {
      cout << "NO\n";
    }
  }
  return 0;
}
