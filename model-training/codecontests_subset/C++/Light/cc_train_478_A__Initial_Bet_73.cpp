#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, k;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  k = c1 + c2 + c3 + c4 + c5;
  if (k % 5 == 0 && k != 0) {
    cout << k / 5;
  } else
    cout << "-1";
}
