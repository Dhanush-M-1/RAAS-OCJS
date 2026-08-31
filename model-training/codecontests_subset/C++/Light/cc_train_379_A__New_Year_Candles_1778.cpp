#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, i;
  cin >> a >> b;
  c = a;
  while ((a / b) != 0) {
    c += (a / b);
    i = a % b;
    a /= b;
    a += i;
  }
  cout << c;
}
