#include <bits/stdc++.h>
using namespace std;
int count(int x, int* a, int s) {
  int r = 0;
  for (int i = 0; i < s; ++i) {
    if (a[i] == x) ++r;
  }
  return r;
}
int main() {
  int n, r = 0;
  cin >> n;
  int *h = new int[n], *g = new int[n];
  for (int i = 0; i < n; ++i) {
    int a, b;
    cin >> a >> b;
    r += count(a, g, i);
    r += count(b, h, i);
    h[i] = a;
    g[i] = b;
  }
  cout << r;
  return 0;
}
