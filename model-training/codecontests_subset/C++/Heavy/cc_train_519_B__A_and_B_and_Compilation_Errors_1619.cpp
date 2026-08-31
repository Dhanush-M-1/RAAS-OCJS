#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  int b[n - 1];
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  sort(b, b + n - 1);
  int c[n - 2];
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(c, c + n - 2);
  int flag = 0;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      flag = 1;
      cout << a[i] << endl;
      break;
    }
  }
  if (!flag) {
    cout << a[n - 1] << endl;
  }
  flag = 0;
  for (int i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      flag = 1;
      cout << b[i] << endl;
      break;
    }
  }
  if (!flag) {
    cout << b[n - 2] << endl;
  }
  return 0;
}
