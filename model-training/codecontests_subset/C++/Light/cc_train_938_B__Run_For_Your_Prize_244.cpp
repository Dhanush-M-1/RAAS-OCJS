#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  vector<long long int> v(n);
  for (long long int i = 0; i < n; i++) {
    cin >> v[i];
  }
  long long int ans = -1;
  for (long long int i = 0; i < n; i++) {
    v[i] = min(v[i] - 1, 1000000 - v[i]);
    ans = max(ans, v[i]);
  }
  cout << ans << endl;
  return 0;
}
