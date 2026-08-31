#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, a[100];
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int min = 0;
  for (int i = n - 1; i >= 0; i--) {
    if (k % a[i] == 0) {
      min = a[i];
      break;
    }
  }
  cout << k / min;
}
