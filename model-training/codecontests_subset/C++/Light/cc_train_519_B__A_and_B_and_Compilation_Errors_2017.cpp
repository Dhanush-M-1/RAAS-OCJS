#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  scanf("%d", &n);
  int a = 0, b = 0, c = 0, x;
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    a = a ^ x;
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    b = b ^ x;
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    c = c ^ x;
  }
  cout << (a ^ b) << endl << (b ^ c) << endl;
  return 0;
}
