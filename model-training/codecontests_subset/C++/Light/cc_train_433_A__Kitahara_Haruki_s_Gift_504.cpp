#include <bits/stdc++.h>
long int n200, n100;
long int i, j;
using namespace std;
int main() {
  long int n;
  cin >> n;
  long int i, x;
  for (i = 1; i <= n; i++) {
    cin >> x;
    if (x == 100)
      n100++;
    else
      n200++;
  }
  if (n100 % 2 == 0)
    if (n200 % 2 == 0) {
      cout << "YES";
      return 0;
    } else if (n100 >= 2) {
      cout << "YES";
      return 0;
    } else {
      cout << "NO";
      return 0;
    }
  else {
    cout << "NO";
    return 0;
  }
}
