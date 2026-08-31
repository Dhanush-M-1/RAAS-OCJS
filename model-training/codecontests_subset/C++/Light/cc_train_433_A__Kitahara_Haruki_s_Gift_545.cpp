#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  int i, j, x, n, cnt = 0, m, y, k, g, flg;
  int cn1, cn2;
  cn1 = cn2 = 0;
  cin >> n;
  int in[n + 1];
  for (i = 1; i <= n; i++) {
    cin >> in[i];
    if (in[i] == 100)
      cn1++;
    else
      cn2++;
  }
  if (cn1 % 2 == 0 && cn1 != 0)
    cout << "YES";
  else if (cn1 % 2 == 0 && cn2 % 2 == 0)
    cout << "YES";
  else
    cout << "NO";
}
