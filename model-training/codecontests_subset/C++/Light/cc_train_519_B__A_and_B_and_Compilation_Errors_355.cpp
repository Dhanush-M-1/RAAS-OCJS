#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int a[n], b[n], c[n], one, two;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a, a + n);
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &b[i]);
  }
  b[n - 1] = 0;
  sort(b, b + (n - 1));
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &c[i]);
  }
  c[n - 2] = 0;
  c[n - 1] = 0;
  sort(c, c + (n - 2));
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      one = a[i];
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (c[i] != b[i]) {
      two = b[i];
      break;
    }
  }
  cout << one << endl << two;
}
