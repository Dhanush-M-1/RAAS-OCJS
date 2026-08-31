#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  vector<int> v(n), vb(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  int ma = 0;
  for (int i = 0; i < n - 1; i++) {
    vb[i] = v[i] - v[i + 1];
    ma = max(ma, vb[i]);
  }
  if (ma <= 0 || (ma - c) <= 0)
    cout << 0 << '\n';
  else
    cout << ma - c << "\n";
}
