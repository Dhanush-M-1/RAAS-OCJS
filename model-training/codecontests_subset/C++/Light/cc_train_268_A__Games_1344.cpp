#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[30][2];
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < 2; ++j) {
      cin >> a[i][j];
    }
  }
  int counter = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < n; ++j) {
      if (a[i][0] == a[j][1]) counter++;
    }
  }
  cout << counter << endl;
  return 0;
}
