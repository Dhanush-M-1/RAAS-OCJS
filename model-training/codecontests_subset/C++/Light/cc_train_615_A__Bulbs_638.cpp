#include <bits/stdc++.h>
using namespace std;
int n = 0;
int m = 0;
int a[110][110];
int x;
int b[110];
int main() {
  cin >> n;
  cin >> m;
  for (int i = 1; i <= m; i++) {
    b[i] = i;
  }
  for (int i = 0; i < n; ++i) {
    cin >> a[i][0];
    for (int j = 1; j <= a[i][0]; j++) {
      cin >> a[i][j];
      b[a[i][j]] = 0;
    }
  }
  for (int i = 1; i <= m; ++i) {
    if (b[i] == 0) {
      x++;
    }
  }
  if (x == m) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
