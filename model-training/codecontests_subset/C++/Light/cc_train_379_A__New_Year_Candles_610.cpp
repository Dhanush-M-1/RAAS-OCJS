#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, w;
  cin >> a >> b;
  w = a;
  while (w >= b) {
    w = w - b + 1;
    a++;
  }
  cout << a;
  return 0;
}
