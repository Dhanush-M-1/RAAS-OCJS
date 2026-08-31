#include <bits/stdc++.h>
using namespace std;
int main() {
  char a[3];
  int c[2] = {0}, d[2] = {0};
  cin >> a;
  int n;
  cin >> n;
  char** b = new char*[n + 1];
  for (int i = 0; i < n; i++) {
    b[i] = new char[3];
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < 2; j++) cin >> b[i][j];
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < n; j++) {
      for (int k = 0; k < 2; k++) {
        if (b[j][k] == a[i]) {
          if (i == 0) {
            c[k]++;
          } else {
            d[k]++;
          }
        }
      }
      if (b[j][0] == a[0] && b[j][1] == a[1]) {
        cout << "YES";
        return 0;
      }
    }
  }
  if (c[1] && d[0])
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
