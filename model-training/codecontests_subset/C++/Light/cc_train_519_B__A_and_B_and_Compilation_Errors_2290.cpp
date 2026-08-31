#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[3], k;
  cin >> n;
  fill(a, a + 3, 0);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n - i; j++) {
      cin >> k;
      a[i] += k;
    }
  }
  cout << a[0] - a[1] << endl << a[1] - a[2];
  return 0;
}
