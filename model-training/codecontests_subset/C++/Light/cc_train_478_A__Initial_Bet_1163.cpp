#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  int s = (c1 + c2 + c3 + c4 + c5) / 5;
  if (5 * s == c1 + c2 + c3 + c4 + c5 && (c1 + c2 + c3 + c4 + c5) != 0)
    cout << s;
  else
    cout << "-1";
  return 0;
}
