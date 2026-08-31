#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n][2], i, j;
  for (i = 0; i < n; i++) {
    for (j = 0; j < 2; j++) cin >> a[i][j];
  }
  int c = 0;
  for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i][0] == a[j][1]) c++;
      if (a[i][1] == a[j][0]) c++;
    }
  }
  cout << c << endl;
  return 0;
}
