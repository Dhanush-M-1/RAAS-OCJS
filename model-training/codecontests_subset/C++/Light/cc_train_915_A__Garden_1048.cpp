#include <bits/stdc++.h>
using namespace std;
int a[10000];
int main() {
  int n, k, ma = 0;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    int x;
    cin >> x;
    if (k % x == 0)
      if (x > ma) ma = x;
  }
  cout << k / ma;
}
