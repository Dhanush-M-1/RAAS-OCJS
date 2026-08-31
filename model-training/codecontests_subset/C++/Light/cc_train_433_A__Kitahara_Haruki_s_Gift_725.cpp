#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  int nc = 0;
  int nd = 0;
  for (int i = 0; i < t; i++) {
    int w;
    cin >> w;
    if (w == 100) {
      nc++;
    } else {
      nd++;
    }
  }
  if ((nc % 2 == 0 && nd % 2 == 0) || (nc % 2 == 0 && nd % 2 != 0 && nc != 0)) {
    cout << "YES";
  } else {
    cout << "NO";
  }
  return 0;
}
