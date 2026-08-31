#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b >> c;
  int t;
  t = (a - b) * c / b;
  t += ((a - b) * c % b == 0) ? 0 : 1;
  cout << t << '\n';
  return 0;
}
