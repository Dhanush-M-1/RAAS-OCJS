#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n, n100 = 0, n200 = 0, i, app;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> app;
    if (app == 100)
      n100++;
    else
      n200++;
  }
  if (n100 == 0 || n200 == 0) {
    if (n100 % 2 == 0 && n200 % 2 == 0) {
      cout << "YES";
    } else {
      cout << "NO";
    }
  } else {
    int rest = abs(n100 - 2 * n200);
    if (rest % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  }
}
