#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, w, countl = 0, countr = 0;
  cin >> n;
  for (n; n > 0; n--) {
    cin >> w;
    if (w == 100)
      countl++;
    else
      countr++;
  }
  if ((countl == 0 && countr % 2 != 0) || (countr == 0 && countl % 2 != 0))
    cout << "NO";
  else if (countl % 2 == 0 && countr % 2 == 0)
    cout << "YES";
  else {
    countr %= 2;
    countl %= 2;
    if (countr != 0 && countl == 0)
      cout << "YES";
    else
      cout << "NO";
  }
  return 0;
}
