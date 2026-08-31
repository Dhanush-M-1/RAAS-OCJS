#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a1 = 0, a2 = 0;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100) {
      a1++;
    } else
      a2++;
  }
  if (a1 % 2 != 0) {
    cout << "NO" << endl;
  } else {
    if (a2 % 2 != 0 && a1 < 2) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
    }
  }
}
