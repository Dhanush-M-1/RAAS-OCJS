#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, cou = 0, a[30][2];
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i][0] >> a[i][1];
  for (i = 0; i < n - 1; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i][0] == a[j][1]) cou++;
      if (a[j][0] == a[i][1]) cou++;
    }
  }
  cout << cou << endl;
  return 0;
}
