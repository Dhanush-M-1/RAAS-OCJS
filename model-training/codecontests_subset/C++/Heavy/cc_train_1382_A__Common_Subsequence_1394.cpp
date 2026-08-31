#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    int k = -1;
    int i = 0, j = 0;
    do {
      if (a[i] == b[j]) {
        k = a[i];
        break;
      }
      if (a[i] > b[j]) {
        j++;
      } else {
        i++;
      }
    } while (i < n && j < m);
    if (k == -1) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl << 1 << " " << k << endl;
    }
  }
}
