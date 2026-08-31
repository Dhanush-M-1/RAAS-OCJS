#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a;
  cin >> b;
  cin >> c;
  int s = a * c;
  s += (b - 1);
  s /= b;
  cout << s - c << endl;
  return 0;
}
