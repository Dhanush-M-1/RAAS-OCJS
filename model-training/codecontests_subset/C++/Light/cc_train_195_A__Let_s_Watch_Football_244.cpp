#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n = 0, a, b, c;
  cin >> a >> b >> c;
  n = a * c / b;
  if (a * c % b != 0) n++;
  cout << n - c;
  return 0;
}
