#include <bits/stdc++.h>
using namespace std;
void i_f_o() {
  ios_base::sync_with_stdio(NULL);
  cin.tie(NULL);
  cout.tie(NULL);
}
int32_t main() {
  int n;
  cin >> n;
  int a[n], b[n];
  int ans = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> b[i];
  }
  for (int i = 0; i < n; i++) {
    int temp = a[i];
    for (int j = 0; j < n; j++) {
      if (temp == b[j]) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
