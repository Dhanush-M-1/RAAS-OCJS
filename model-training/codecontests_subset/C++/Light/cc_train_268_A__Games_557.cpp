#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, total = 0;
  cin >> n;
  int h[n], a[n];
  for (i = 0; i < n; i++) cin >> h[i] >> a[i];
  for (i = 0; i < n; i++) {
    for (j = i + 1; j < n; j++) {
      if (a[i] == h[j]) total++;
      if (a[j] == h[i]) total++;
    }
  }
  cout << total;
  return 0;
}
