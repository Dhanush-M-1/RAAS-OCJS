#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int a[n];
  int max = INT_MIN;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] > max) {
      max = a[i] - a[i + 1];
    }
  }
  if (max - c < 0) {
    cout << 0;
  } else
    cout << max - c;
  return 0;
}
