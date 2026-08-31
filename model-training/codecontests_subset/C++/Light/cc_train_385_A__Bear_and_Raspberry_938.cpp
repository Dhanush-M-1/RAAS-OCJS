#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int maxdiff = k;
  for (int i = 1; i < n; i++) {
    int diff = a[i - 1] - a[i];
    if (diff > maxdiff) {
      maxdiff = diff;
    }
  }
  cout << maxdiff - k;
  return 0;
}
