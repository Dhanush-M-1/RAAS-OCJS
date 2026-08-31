#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  int s1, s2;
  bool flag = true;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      s1 = a[i];
      flag = false;
      break;
    }
  }
  if (flag) s1 = a[n - 1];
  flag = true;
  for (int i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      s2 = b[i];
      flag = false;
      break;
    }
  }
  if (flag) s2 = b[n - 2];
  cout << s1 << '\n' << s2 << '\n';
  return 0;
}
