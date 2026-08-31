#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
int main() {
  long long res;
  int a, b, c;
  cin >> a >> b >> c;
  int l = ceil(double(a * c) / double(b) - double(c));
  if (l < 0)
    cout << "0";
  else
    cout << l;
  return 0;
}
