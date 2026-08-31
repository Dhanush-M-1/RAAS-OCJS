#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int k;
  k = (a - b) * c;
  if (k % b == 0)
    cout << k / b << endl;
  else
    cout << (k / b) + 1 << endl;
  return 0;
}
