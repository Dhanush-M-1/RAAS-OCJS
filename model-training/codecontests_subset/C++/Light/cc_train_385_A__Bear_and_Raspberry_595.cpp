#include <bits/stdc++.h>
using namespace std;
int main() {
  vector<int> v(100);
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> v[i];
  int ans = 0;
  for (int i = 0; i < n - 1; i++) ans = max(ans, v[i] - c - v[i + 1]);
  cout << ans;
  return 0;
}
