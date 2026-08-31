#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int x = c * a - c * b;
  int y = x / b;
  if (y * b < x) y++;
  cout << y << endl;
  return 0;
}
