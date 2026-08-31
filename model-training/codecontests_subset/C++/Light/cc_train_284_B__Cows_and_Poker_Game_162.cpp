#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  char x[1000000];
  cin >> n;
  int a = 0, b = 0;
  for (int i = 0; i < n; i++) {
    cin >> x[i];
    if (x[i] == 'I') {
      a++;
    } else if (x[i] == 'A') {
      b++;
    }
  }
  if (a == 0) {
    cout << b;
  }
  if (a == 1) {
    cout << 1;
  }
  if (a >= 2) {
    cout << 0;
  }
  return 0;
}
