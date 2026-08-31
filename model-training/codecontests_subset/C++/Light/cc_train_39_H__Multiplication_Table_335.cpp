#include <bits/stdc++.h>
using namespace std;
int k;
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      int res = j * i;
      res = 10 * (res / k) + (res % k);
      cout << res << " ";
    }
    cout << endl;
  }
  return 0;
}
