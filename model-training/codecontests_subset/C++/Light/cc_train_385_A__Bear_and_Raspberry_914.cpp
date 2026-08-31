#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, l = 0;
  cin >> n >> c;
  int a[n];
  {
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      if (i == 1) {
        l = a[0] - a[1];
      }
      if (i >= 2 && (a[i - 1] - a[i] > l)) {
        l = a[i - 1] - a[i];
      }
    }
    l = l - c;
    if (l <= 0)
      cout << "0" << endl;
    else
      cout << l;
  }
}
