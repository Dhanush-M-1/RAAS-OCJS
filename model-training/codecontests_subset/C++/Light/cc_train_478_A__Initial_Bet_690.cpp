#include <bits/stdc++.h>
using namespace std;
int main() {
  long long c1, c2, c3, c4, c5;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  long long x = (c1 + c2 + c3 + c4 + c5);
  if (x % 5 == 0 && x != 0)
    cout << x / 5;
  else
    cout << "-1";
}
