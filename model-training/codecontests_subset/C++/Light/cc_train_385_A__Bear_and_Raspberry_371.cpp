#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int max = a[0] - a[1];
  for (int i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] > max) {
      max = a[i] - a[i + 1];
    }
  }
  if (max - c > 0) {
    cout << max - c;
  } else
    cout << "0";
  return 0;
}
