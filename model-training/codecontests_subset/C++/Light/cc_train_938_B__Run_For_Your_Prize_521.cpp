#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[100005];
  for (int i = 1; i <= n; i++) cin >> a[i];
  sort(a + 1, a + 1 + n);
  for (int i = 1; i <= n; i++) {
    if (a[1] > 500000) {
      cout << 1000000 - a[1];
      return 0;
    }
    if (a[i] > 500000) {
      if (a[i - 1] - 1 > 1000000 - a[i])
        cout << a[i - 1] - 1;
      else
        cout << 1000000 - a[i];
      return 0;
    }
  }
  cout << a[n] - 1;
  return 0;
}
