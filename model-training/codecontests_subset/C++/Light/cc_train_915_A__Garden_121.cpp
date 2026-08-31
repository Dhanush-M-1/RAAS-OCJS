#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a[10000], c = 0, bal, hoga, ok;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  reverse(a, a + n);
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) {
      bal = k / a[i];
      cout << bal << endl;
      return 0;
    }
  }
}
