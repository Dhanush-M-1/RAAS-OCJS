#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[30][2], k;
  cin >> n;
  k = 0;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < 2; j++) cin >> a[i][j];
  for (int i = 0; i < n; i++) {
    for (int z = 0; z < n; z++)
      if (a[i][0] == a[z][1]) k++;
  }
  cout << k;
  return 0;
}
