#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c, diff = 0, max = 0, a[100];
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    diff = a[i] - a[i + 1];
    if (diff > max) {
      max = diff;
    }
  }
  if (max - c >= 0) {
    cout << max - c;
  } else {
    cout << 0;
  }
  return 0;
}
