#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> a(n, 0), b(n, 0);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    b[i] = a[i];
  }
  sort(b.begin(), b.end());
  int m;
  cin >> m;
  for (int i = 0; i < m; ++i) {
    int k, pos;
    cin >> k >> pos;
    int x = b[n - k];
    vector<int> c;
    for (int j = 0; j < n && c.size() < pos && k > 0; ++j) {
      if (a[j] == x) {
        --k;
        if (k > 0) x = b[n - k];
        c.push_back(a[j]);
      } else if (a[j] > x) {
        c.push_back(a[j]);
      }
    }
    cout << c[pos - 1] << endl;
  }
  return 0;
}
