#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  int a[1001];
  int mx = -1;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    if ((a[i] <= k) && (k % a[i] == 0)) {
      mx = max(a[i], mx);
    }
  }
  cout << k / mx << endl;
}
