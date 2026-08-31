#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  int a[100100];
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (int i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      cout << k / a[i] << endl;
      break;
    }
  }
  return 0;
}
