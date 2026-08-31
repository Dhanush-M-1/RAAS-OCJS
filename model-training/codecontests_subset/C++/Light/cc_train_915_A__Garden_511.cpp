#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  int k;
  int fac = INT_MIN;
  cin >> n >> k;
  vector<int> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    if (k % v[i] == 0 && v[i] > fac) fac = v[i];
  }
  cout << k / fac;
  return 0;
}
