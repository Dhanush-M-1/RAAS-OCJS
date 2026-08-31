#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int s = a * c;
  int ss = b * c;
  s -= ss;
  if (s < 0)
    cout << 0;
  else if (s % b == 0)
    cout << s / b;
  else
    cout << s / b + 1;
}
