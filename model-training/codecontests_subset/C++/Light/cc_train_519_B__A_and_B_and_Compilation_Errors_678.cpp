#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, b = 0, c = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    a += x;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    b += x;
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    c += x;
  }
  cout << a - b << endl << b - c;
  return 0;
}
