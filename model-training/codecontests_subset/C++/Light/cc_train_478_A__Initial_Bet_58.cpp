#include <bits/stdc++.h>
using namespace std;
long long c, c1, c2, c3, c4, k;
int main() {
  cin >> c >> c1 >> c2 >> c3 >> c4;
  k = c + c1 + c2 + c3 + c4;
  if (k == 0)
    cout << -1;
  else if (k % 5 == 0)
    cout << k / 5;
  else
    cout << -1;
}
