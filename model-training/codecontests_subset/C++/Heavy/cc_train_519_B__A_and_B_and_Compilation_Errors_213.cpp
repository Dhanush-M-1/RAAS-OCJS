#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  int a[n], a1[n - 1], a2[n - 1];
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (i = 0; i < n - 1; i++) {
    cin >> a1[i];
  }
  sort(a, a + n);
  sort(a1, a1 + n - 1);
  for (i = 0; i < n - 1; i++) {
    if (a[i] != a1[i]) {
      cout << a[i] << "\n";
      a2[0] = a[i];
      break;
    }
  }
  if (i == n - 1) {
    cout << a[n - 1] << "\n";
    a2[0] = a[n - 1];
  }
  for (i = 1; i < n - 1; i++) {
    cin >> a2[i];
  }
  sort(a2, a2 + n - 1);
  for (i = 0; i < n - 1; i++) {
    if (a[i] != a2[i]) {
      cout << a[i] << "\n";
      break;
    }
  }
  if (i == n - 1) {
    cout << a[n - 1] << "\n";
  }
  return 0;
}
