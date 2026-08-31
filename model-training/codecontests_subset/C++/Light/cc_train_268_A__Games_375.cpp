#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, j, i, l;
  cin >> n;
  int x[n][2];
  for (i = 0; i < n; i++) {
    for (j = 0; j < 2; j++) {
      cin >> x[i][j];
    }
  }
  c = 0;
  for (l = 0; l < n; l++) {
    for (i = 0; i < n; i++) {
      if (x[l][0] == x[i][1]) c += 1;
    }
  }
  cout << c;
}
