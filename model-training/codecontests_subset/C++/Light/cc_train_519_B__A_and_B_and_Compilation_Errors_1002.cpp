#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, k;
  scanf("%d", &n);
  int a[n], b[n - 1], c[n - 2], x[2];
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, a + n);
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
  }
  sort(b, b + n - 1);
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &c[i]);
  }
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (b[i] != c[i]) {
      cout << b[i];
      break;
    }
  }
}
