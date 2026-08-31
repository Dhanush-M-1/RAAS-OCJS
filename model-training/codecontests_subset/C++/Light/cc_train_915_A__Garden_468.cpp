#include <bits/stdc++.h>
using namespace std;
long long mod(long long a) {
  if (a < 0)
    return -1 * a;
  else
    return a;
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> v(n, 0);
  for (int i = 0; i < n; i++) cin >> v[i];
  sort(v.begin(), v.end());
  for (int i = n - 1; i >= 0; i--) {
    if (k % v[i] == 0) {
      cout << k / v[i] << endl;
      break;
    }
  }
}
