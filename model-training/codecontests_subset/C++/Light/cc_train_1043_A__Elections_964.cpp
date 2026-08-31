#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; i++) cin >> v[i];
  int k = 2 * accumulate(v.begin(), v.end(), 0);
  k = k / n + 1;
  cout << max(k, *max_element(v.begin(), v.end())) << "\n";
}
