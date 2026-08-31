#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0, n, i, x;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x;
    if (x == 100)
      a++;
    else
      b++;
  }
  if (b == 0 && a % 2 == 0 && a != 0)
    cout << "YES" << endl;
  else if (a == 0 && b != 0 && b % 2 == 0)
    cout << "YES" << endl;
  else if (a % 2 == 0 && a != 0 && b != 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
