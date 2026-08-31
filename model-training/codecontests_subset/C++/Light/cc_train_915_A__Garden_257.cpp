#include <bits/stdc++.h>
using namespace std;
int n, k, a, b;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> b;
    if (k % b == 0 && b > a) {
      a = b;
    }
  }
  cout << k / a;
  return 0;
}
