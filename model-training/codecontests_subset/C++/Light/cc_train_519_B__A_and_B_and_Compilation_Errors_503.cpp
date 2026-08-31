#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n;
  long int a = 0, b = 0, c = 0;
  for (int i = 0; i < n; i++) {
    cin >> k;
    a = a + k;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> k;
    b = b + k;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> k;
    c = c + k;
  }
  cout << a - b << endl << b - c;
  return 0;
}
