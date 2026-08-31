#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int tc = 1; tc <= t; tc++) {
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];
    int i = 0, j = 1, k = n - 1;
    if (v[i] + v[j] > v[k])
      cout << -1 << endl;
    else {
      cout << i + 1 << " " << j + 1 << " " << k + 1 << endl;
    }
  }
}
