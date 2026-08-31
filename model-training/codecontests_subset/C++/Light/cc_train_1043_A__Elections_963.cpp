#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  long long s = 0, x;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) cin >> a[i], s += a[i];
  sort(a, a + n);
  x = a[n - 1];
  while (1) {
    if ((n * x - s) > s) {
      break;
    }
    x++;
  }
  cout << x;
}
