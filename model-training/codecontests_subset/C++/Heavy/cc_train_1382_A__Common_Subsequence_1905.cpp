#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t-- > 0) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    unordered_map<long long int, long long int> map;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      map[a[i]]++;
    }
    bool boo = false;
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (int i = 0; i < m; i++) {
      if (map.find(b[i]) != map.end()) {
        boo = true;
        cout << "YES" << endl;
        cout << "1 " << b[i] << endl;
        break;
      }
    }
    if (!boo) {
      cout << "NO" << endl;
    }
  }
  return 0;
}
