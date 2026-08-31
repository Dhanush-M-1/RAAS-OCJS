#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, counter = 0;
  cin >> n;
  int h[50] = {}, g[50] = {};
  for (int i = 0; i < n; i++) {
    cin >> h[i] >> g[i];
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (h[i] == g[j]) {
        counter++;
      }
      if (g[i] == h[j]) {
        counter++;
      }
    }
  }
  cout << counter / 2 << endl;
  return 0;
}
double power(double x, double y) {
  double h = 1;
  for (int i = 0; i < y; i++) {
    h = h * x;
  }
  return h;
}
long long factorial(long long x) {
  long long res = 1;
  for (int i = 1; i <= x; i++) {
    res = res * i;
  }
  return res;
}
