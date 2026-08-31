#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  int q = 1;
  cin >> k;
  int a[k - 1][k - 1];
  for (int i = 0; i < k - 1; i++) {
    for (int j = 0; j < k - 1; j++) {
      a[i][j] = j * q + q;
      if (a[i][j] >= k) {
        a[i][j] = (a[i][j] / k) * 10 + (a[i][j] % k);
      }
      cout << a[i][j] << " ";
    }
    q++;
    cout << endl;
  }
  return 0;
}
