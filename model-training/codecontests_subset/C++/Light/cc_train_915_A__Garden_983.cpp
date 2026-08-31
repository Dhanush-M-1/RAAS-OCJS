#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int arra[n];
  for (int i = 0; i < n; i++) {
    cin >> arra[i];
  }
  sort(arra, arra + n);
  for (int i = n - 1; i >= 0; i--) {
    if (k % arra[i] == 0) {
      cout << k / arra[i];
      return 0;
    }
  }
}
