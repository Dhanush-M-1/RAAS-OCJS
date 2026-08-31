#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t) {
    int n;
    cin >> n;
    vector<int> v(n);
    for (size_t i = 0; i < n; i++) {
      cin >> v[i];
    }
    int i1, i2, i3;
    i1 = 0, i2 = 1, i3 = n - 1;
    if (v[i1] + v[i2] <= v[i3]) {
      cout << i1 + 1 << " " << i2 + 1 << " " << i3 + 1 << endl;
      t--;
      continue;
    }
    i2 = n - 2;
    if (v[i1] + v[i2] <= v[i3]) {
      cout << i1 + 1 << " " << i2 + 1 << " " << i3 + 1 << endl;
      t--;
      continue;
    }
    cout << -1 << endl;
    t--;
  }
}
