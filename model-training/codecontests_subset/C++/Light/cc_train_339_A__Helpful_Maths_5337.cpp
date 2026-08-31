#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[1000], b[1000], l, j = 0;
  cin >> a;
  l = strlen(a);
  for (int i = 0; i < l; i++) {
    if (a[i] > 47 && a[i] < 58) {
      b[j] = a[i];
      j++;
    }
  }
  sort(b, b + j);
  for (int i = 0; i < j; i++) {
    if (i == j - 1) {
      cout << b[i];
    } else {
      cout << b[i] << "+";
    }
  }
  return 0;
}
