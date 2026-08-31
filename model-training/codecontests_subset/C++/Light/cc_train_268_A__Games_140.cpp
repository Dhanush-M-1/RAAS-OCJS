#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int c = 0;
  cin >> n;
  int u[2][n];
  for (int i = 0; i < n; i++) {
    cin >> u[0][i] >> u[1][i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j && u[0][i] == u[1][j]) {
        c++;
      }
    }
  }
  cout << c;
  return 0;
}
