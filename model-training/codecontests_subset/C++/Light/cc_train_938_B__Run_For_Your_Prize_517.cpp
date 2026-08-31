#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, q, mn, ml, mr;
  cin >> n;
  vector<int> a(1000000);
  ml = 0;
  mr = 0;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n; i++) {
    if (a[i] - 1 < 1000000 - a[i]) {
      if (a[i] - 1 > ml) ml = a[i] - 1;
    } else if (1000000 - a[i] > mr)
      mr = 1000000 - a[i];
  }
  cout << max(ml, mr);
}
