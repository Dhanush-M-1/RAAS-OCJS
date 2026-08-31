#include <bits/stdc++.h>
using namespace std;
double EPS = 1e-6;
int main() {
  int n, c, v;
  cin >> n >> c;
  vector<int> a;
  for (int i = 0; i <= n - 1; i++) {
    cin >> v;
    a.push_back(v);
  }
  int ans = 0;
  for (int i = 0; i <= n - 2; i++) {
    ans = max(ans, a[i] - a[i + 1] - c);
  }
  cout << ans;
  return 0;
}
