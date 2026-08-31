#include <bits/stdc++.h>
using namespace std;
int r;
int g(int a, int b) {
  if (a / b < 1) return 0;
  r = a % b;
  return (a / b) + g((a / b) + r, b);
}
int main() {
  int a, b;
  cin >> a >> b;
  cout << int(a + g(a, b));
}
