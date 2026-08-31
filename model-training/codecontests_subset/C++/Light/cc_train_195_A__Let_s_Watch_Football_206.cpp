#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, required, secnds;
  cin >> a >> b >> c;
  required = a * c;
  if (required % b == 0)
    secnds = required / b;
  else
    secnds = (required / b) + 1;
  cout << secnds - c;
  return 0;
}
