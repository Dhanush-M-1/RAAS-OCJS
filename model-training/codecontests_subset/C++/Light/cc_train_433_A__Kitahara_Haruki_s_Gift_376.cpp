#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, w, v1, v2, cont1, cont2, q, total;
  bool flag = 0;
  cin >> n;
  cont1 = cont2 = 0;
  for (int i = 0; i < n; i++) {
    cin >> w;
    if (w == 100)
      cont1++;
    else
      cont2++;
  }
  if (n == 1)
    cout << "NO";
  else {
    if (cont1 % 2 == 0) {
      if (!cont1) {
        if (cont2 % 2 == 0)
          cout << "YES";
        else
          cout << "NO";
      } else
        cout << "YES";
    } else
      cout << "NO";
  }
  cout << endl;
  return 0;
}
