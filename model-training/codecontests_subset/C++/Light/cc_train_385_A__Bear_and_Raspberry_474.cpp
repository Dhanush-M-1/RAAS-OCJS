#include <bits/stdc++.h>
using namespace std;
int main() {
  int d, cost, store = 0;
  cin >> d >> cost;
  int a[d];
  for (int i = 0; i < d; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < d - 1; i++) {
    if (a[i] - cost - a[i + 1] > 0 && (a[i] - cost - a[i + 1]) > store) {
      store = a[i] - cost - a[i + 1];
    }
  }
  cout << store;
  return 0;
}
