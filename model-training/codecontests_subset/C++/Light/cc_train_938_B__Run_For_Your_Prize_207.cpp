#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int c = 1000000;
  int* a = new int[n];
  for (int i = 0; i < n; ++i) cin >> a[i];
  int max_ = 0, min_ = c;
  for (int i = 0; i < n; ++i) {
    if (a[i] <= c / 2) {
      max_ = a[i];
    } else {
      min_ = a[i];
      break;
    }
  }
  cout << max(max_ - 1, c - min_) << endl;
  return 0;
}
