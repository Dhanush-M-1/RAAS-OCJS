#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n + 1], b[n + 1], c[n + 1], d[n + 1];
  for (int i = 0; i < n; ++i) {
    cin >> a[i] >> b[i] >> c[i];
    d[i] = min(c[i] / 2, b[i]);
    d[i] += (d[i] * 2);
    b[i] -= min(c[i] / 2, b[i]);
    d[i] += min(b[i] / 2, a[i]);
    d[i] += min(b[i] / 2, a[i]) * 2;
  }
  for (int i = 0; i < n; ++i) {
    cout << d[i] << endl;
  }
}
