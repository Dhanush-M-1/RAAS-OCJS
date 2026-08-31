#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, one, two;
  while (cin >> n) {
    one = 0;
    two = 0;
    while (n--) {
      cin >> x;
      if (x == 100)
        one++;
      else
        two++;
    }
    if (two % 2 == 0 && one % 2 == 0)
      cout << "YES" << endl;
    else if (two % 2 == 1 && one % 2 == 0 && one >= 2)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
