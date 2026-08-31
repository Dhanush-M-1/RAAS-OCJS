#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, k;
  cin >> n >> k;
  int a[n], x = -1;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    if (k % a[i] == 0) {
      if (x < a[i]) x = a[i];
    }
  }
  cout << k / x;
  return 0;
}
