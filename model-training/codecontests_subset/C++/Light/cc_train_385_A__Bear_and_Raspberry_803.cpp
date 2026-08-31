#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int n, c;
  cin >> n >> c;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
  }
  int max_diff = INT_MIN;
  for (int i = 0; i < n - 1; i++) {
    if (v[i] - v[i + 1] > max_diff) max_diff = v[i] - v[i + 1];
  }
  int profit = max_diff - c;
  if (profit > 0)
    cout << profit << "\n";
  else
    cout << 0 << "\n";
  return 0;
}
