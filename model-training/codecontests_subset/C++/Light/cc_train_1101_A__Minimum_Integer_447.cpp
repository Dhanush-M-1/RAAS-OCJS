#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int t1 = 0; t1 < t; t1++) {
    int l, r, d;
    int min = 1000000000;
    cin >> l >> r >> d;
    min = (d < l) ? d : r / d * d + d;
    cout << min << endl;
  }
}
