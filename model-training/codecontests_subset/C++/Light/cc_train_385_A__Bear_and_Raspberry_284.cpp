#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int t = 0;
  int j = -1;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] > t) {
      t = a[i] - a[i + 1];
      j = i;
    }
  }
  if (j == -1)
    cout << 0 << endl;
  else {
    int cost = a[j] - a[j + 1] - k;
    if (cost > 0)
      cout << cost << endl;
    else
      cout << 0 << endl;
  }
}
