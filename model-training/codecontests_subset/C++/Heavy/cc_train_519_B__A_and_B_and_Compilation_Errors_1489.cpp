#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
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
  int i = 0, j = 0, k = 0;
  int p, q;
  while (i < n) {
    if (a[i] == b[j]) {
      if (b[j] == c[k]) {
        i++;
        j++;
        k++;
      } else {
        q = a[i];
        i++;
        j++;
      }
    } else {
      p = a[i];
      i++;
    }
  }
  cout << p << "\n" << q << "\n";
  return 0;
}
