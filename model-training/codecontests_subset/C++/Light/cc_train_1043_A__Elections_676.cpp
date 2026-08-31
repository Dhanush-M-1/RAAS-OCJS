#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y = 0, z = 0, j;
  vector<int> v;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    v.push_back(x);
    z += x;
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < n; i++) {
    y += (v[n - 1] - v[i]);
  }
  if (y > z)
    cout << v[n - 1];
  else {
    j = 1;
    while (y <= z) {
      v[n - 1]++;
      y += n;
      j++;
    }
    cout << v[n - 1];
  }
  return 0;
}
