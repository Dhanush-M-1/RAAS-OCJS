#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[30][2], t = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> a[i][j];
    }
  }
  for (int r = 0; r < n; r++) {
    for (int k = 0; k < n; k++) {
      if (a[r][0] == a[k][1]) t++;
    }
  }
  cout << t;
  return 0;
}
