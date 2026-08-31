#include <bits/stdc++.h>
using namespace std;
int v[100001];
int main() {
  int n, p(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> v[i];
    if (v[i] <= 500000) {
      p = i;
    }
  }
  int x = v[p] - 1, y(0);
  if (p < n - 1) {
    y = 1000000 - v[p + 1];
  }
  if (v[p] > 500000) {
    cout << 1000000 - v[p] << "\n";
    return 0;
  }
  cout << max(x, y);
  return 0;
}
