#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tc;
  cin >> tc;
  while (tc--) {
    int n;
    cin >> n;
    int a[n + 5];
    for (int i = 1; i <= n; i++) cin >> a[i];
    if (a[1] + a[2] <= a[n]) {
      cout << 1 << " " << 2 << " " << n << endl;
    } else {
      cout << "-1" << endl;
    }
  }
  return 0;
}
