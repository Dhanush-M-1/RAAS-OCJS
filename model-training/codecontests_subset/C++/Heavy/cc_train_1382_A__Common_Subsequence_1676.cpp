#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n], b[m];
    map<long long int, long long int> hm;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      if (hm[a[i]] == 0) hm[a[i]]++;
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
      if (hm[b[i]] == 1) hm[b[i]]++;
    }
    int flag = 1;
    for (auto i = hm.begin(); i != hm.end(); i++) {
      if (i->second > 1) {
        flag = 0;
        cout << "YES" << endl;
        cout << "1 " << i->first << endl;
        break;
      }
    }
    if (flag == 1) {
      cout << "NO" << endl;
    }
  }
  return 0;
}
