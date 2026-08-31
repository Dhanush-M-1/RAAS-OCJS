#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int* h = new int[n];
  int* a = new int[n];
  for (int i(0); i < n; ++i) cin >> h[i] >> a[i];
  int t = 0;
  for (int i(0); i < n; ++i) t += count(a, a + n, h[i]);
  cout << t;
  return 0;
}
