#include <bits/stdc++.h>
using namespace std;
int n, x;
int a[100005], b[100005], c[100005];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + (n - 1));
  sort(c, c + (n - 2));
  int f = 0;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      f = a[i];
      break;
    }
  }
  if (f != 0)
    cout << f << endl;
  else
    cout << a[n - 1] << endl;
  f = 0;
  for (int i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      f = b[i];
      break;
    }
  }
  if (f == 0)
    cout << b[n - 2] << endl;
  else
    cout << f << endl;
  return 0;
}
