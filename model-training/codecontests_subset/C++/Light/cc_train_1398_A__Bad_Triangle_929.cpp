#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a[n];
    for (int i = 1; i <= n; i++) cin >> a[i];
    if (a[2] + a[1] > a[n])
      cout << -1 << endl;
    else
      cout << 1 << " " << 2 << " " << n << endl;
  }
}
