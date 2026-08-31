#include <bits/stdc++.h>
using namespace std;
double const pi = 3.1415926536;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int k = 0, s = 0;
  for (int i = 0; i <= 1000000 / 2; i++) {
    if (a[k] == i && k < n) {
      s = a[k] - 1;
      k++;
    }
  }
  k = n - 1;
  int c = 0;
  for (int i = 1000000; i > 1000000 / 2; i--) {
    if (i == a[k] && k >= 0) {
      c = 1000000 - a[k];
      k--;
    }
  }
  cout << max(c, s);
}
