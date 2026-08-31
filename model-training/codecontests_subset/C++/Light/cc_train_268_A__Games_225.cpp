#include <bits/stdc++.h>
using namespace std;
int main() {
  int x[30], y[30], n;
  int counter = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
  }
  for (int i = 0; i < n; i++) {
    for (int k = 0; k < n; k++) {
      if (x[i] == y[k]) {
        counter++;
      }
    }
  }
  cout << counter;
  return 0;
}
