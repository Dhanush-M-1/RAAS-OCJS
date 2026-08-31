#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, i, d = 0;
  cin >> a >> b;
  c = (a / b);
  i = c + (a % b);
  while (i >= b) {
    d = (i / b) + d;
    i = (i / b) + (i % b);
  }
  cout << a + c + d;
}
