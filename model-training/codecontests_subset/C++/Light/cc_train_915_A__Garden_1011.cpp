#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long n, i, j, k;
  cin >> n >> k;
  long a[n];
  for (i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  for (i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      cout << k / a[i];
      return 0;
    }
  }
  return 0;
}
