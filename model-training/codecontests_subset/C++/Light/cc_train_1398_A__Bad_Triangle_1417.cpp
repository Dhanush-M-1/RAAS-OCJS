#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    long long int a[n];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    long long int i = 0;
    int flag = 0;
    while (i < n - 2) {
      long long int x, y, z;
      x = a[i];
      y = a[i + 1];
      z = a[n - 1];
      if (z >= x + y) {
        cout << i + 1 << " " << i + 2 << " " << n << endl;
        flag = 1;
        break;
      }
      i++;
    }
    if (flag == 0) {
      cout << "-1" << endl;
    }
  }
}
