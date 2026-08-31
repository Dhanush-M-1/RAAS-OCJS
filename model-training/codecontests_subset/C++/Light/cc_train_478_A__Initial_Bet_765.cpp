#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, a;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  a = c1 + c2 + c3 + c4 + c5;
  if (a > 0 && a % 5 == 0)
    cout << a / 5 << endl;
  else
    cout << "-1" << endl;
}
