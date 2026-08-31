#include <bits/stdc++.h>
using namespace std;
int n, a[11][11];
int c(int x) {
  int s = 0, p = 1;
  while (x) {
    s = s + (x % n) * p;
    x = x / n;
    p = p * 10;
  }
  return s;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++)
    for (int j = 1; j < n; j++) a[i][j] = c(i * j);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) cout << a[i][j] << " ";
    cout << endl;
  }
  return 0;
}
