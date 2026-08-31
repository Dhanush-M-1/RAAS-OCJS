#include <bits/stdc++.h>
using namespace std;
int main() {
  string p;
  int n = 0;
  int t1 = 0;
  int t2 = 0;
  cin >> p;
  cin >> n;
  string y[n];
  for (int i = 0; i < n; i++) {
    cin >> y[i];
    if (y[i] == p) {
      cout << "YES";
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    if (y[i][0] == p[1]) {
      t1++;
    }
    if (y[i][1] == p[0]) {
      t2++;
    }
  }
  if (t1 >= 1 && t2 >= 1) {
    cout << "YES";
  } else {
    cout << "NO";
  }
}
