#include <bits/stdc++.h>
using namespace std;
int main() {
  float a, b, c;
  float x;
  cin >> a >> b >> c;
  x = ceil((a * c / b) - c);
  if (x <= 0)
    cout << x;
  else
    cout << x;
}
