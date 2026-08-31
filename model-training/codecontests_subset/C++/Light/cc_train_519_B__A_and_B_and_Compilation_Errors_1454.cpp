#include <bits/stdc++.h>
using namespace std;
int a[100000] = {};
int main() {
  long long b = 0, c = 0, d = 0;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> a[i];
    c += a[i];
  }
  int x = b - c;
  for (int i = 0; i < n - 2; i++) {
    cin >> a[i];
    d += a[i];
  }
  int y = c - d;
  cout << x << '\n' << y;
}
