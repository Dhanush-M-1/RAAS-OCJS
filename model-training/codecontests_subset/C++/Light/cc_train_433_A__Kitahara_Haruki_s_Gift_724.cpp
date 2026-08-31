#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  if (n == 1) {
    cout << "NO";
    return 0;
  }
  int cien = 0, doscien = 0;
  int contador = 0;
  for (int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
    if (temp == 100)
      cien++;
    else
      doscien++;
    contador += temp;
  }
  if (contador % 200 == 0) {
    if (doscien % 2 != 0 && cien == 0)
      cout << "NO";
    else
      cout << "YES";
  } else
    cout << "NO";
  return 0;
}
