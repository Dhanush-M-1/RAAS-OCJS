#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[110][2], i, j, n, c = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i][0] == a[j][1]) c++;
      if (a[i][1] == a[j][0]) c++;
    }
  }
  cout << c;
  return 0;
}
