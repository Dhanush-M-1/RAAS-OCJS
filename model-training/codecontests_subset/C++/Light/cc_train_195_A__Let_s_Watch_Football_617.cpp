#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int q = a * c / b;
  if (q * b != a * c) {
    q++;
  }
  cout << q - c;
  return 0;
}
