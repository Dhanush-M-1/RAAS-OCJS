#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0;
  cin >> a >> b;
  for (; a; a--, c++, c % b ? 0 : a++)
    ;
  return cout << c, 0;
}
