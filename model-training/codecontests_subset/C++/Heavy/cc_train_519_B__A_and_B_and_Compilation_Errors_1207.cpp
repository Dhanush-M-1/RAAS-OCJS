#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, x, n;
  scanf("%d", &n);
  vector<int> a, b, c;
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    a.push_back(x);
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    b.push_back(x);
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    c.push_back(x);
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  x = 0;
  for (i = 0; i < n - 1; i++) {
    if (a[i] - b[i] != 0) {
      printf("%d\n", a[i]);
      x++;
      break;
    }
  }
  if (x == 0) printf("%d\n", a[n - 1]);
  x = 0;
  for (i = 0; i < n - 2; i++) {
    if (b[i] - c[i] != 0) {
      printf("%d\n", b[i]);
      x++;
      break;
    }
  }
  if (x == 0) printf("%d\n", b[n - 2]);
  return 0;
}
