#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, ans = 0;
  cin >> n >> c;
  vector<int> v;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    v.push_back(a);
  }
  for (int i = 0; i < n - 1; i++) {
    if (v[i] - v[i + 1] - c > ans) ans = v[i] - v[i + 1] - c;
  }
  cout << ans;
  return 0;
}
