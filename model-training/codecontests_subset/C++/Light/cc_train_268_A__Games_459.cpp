#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
int main() {
  int n;
  int a[120];
  int b[120];
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i] >> b[i];
  }
  int ans = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (a[i] == b[j]) ans++;
    }
  }
  cout << ans;
  return 0;
}
