#include <bits/stdc++.h>
using namespace std;
int n, k, a[101], h;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  for (int i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      h = k / a[i];
      break;
    }
  }
  cout << h;
  return 0;
}
