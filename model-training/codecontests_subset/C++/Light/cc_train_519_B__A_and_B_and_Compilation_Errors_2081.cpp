#include <bits/stdc++.h>
using namespace std;
int a[1000000], b[1000000], c[1000000];
int main() {
  int n, ans1, ans2;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      ans1 = a[i];
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (b[i] != c[i]) {
      ans2 = b[i];
      break;
    }
  }
  cout << ans1 << endl << ans2;
}
