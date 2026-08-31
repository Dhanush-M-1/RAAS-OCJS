#include <bits/stdc++.h>
using namespace std;
int a[101];
int main() {
  int n, c, m, i;
  m = INT_MIN;
  cin >> n >> c;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    if (i > 0 && m < a[i - 1] - a[i] - c) {
      m = a[i - 1] - a[i] - c;
    }
  }
  if (m > 0) {
    cout << m;
  } else {
    cout << 0;
  }
  return 0;
}
