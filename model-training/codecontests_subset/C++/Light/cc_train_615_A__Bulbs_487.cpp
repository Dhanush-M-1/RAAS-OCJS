#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, c, o[100];
  cin >> n >> m;
  int m1[100];
  for (int i = 1; i <= m; i++) {
    m1[i - 1] = i;
  }
  for (int i = 0; i < n; i++) {
    cin >> c;
    int s = m;
    for (int j = 0; j < c; j++) {
      cin >> o[j];
    }
    for (int j = 0; j < m; j++) {
      for (int k = 0; k < c; k++) {
        if (m1[j] == o[k]) {
          m1[j] = 0;
          k = c;
        }
      }
    }
  }
  int flag = 0;
  for (int i = 0; i < m; i++) {
    if (m1[i] != 0) flag = 1;
  }
  if (flag == 1)
    cout << "NO";
  else
    cout << "YES";
}
