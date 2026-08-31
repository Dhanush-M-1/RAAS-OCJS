#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int test, n, i, j, k, x, y, t;
  j = 0;
  for (i = 0; i < 5; i++) {
    cin >> x;
    j += x;
  }
  if (j % 5 == 0 && (j / 5 != 0))
    cout << j / 5;
  else
    cout << "-1";
}
