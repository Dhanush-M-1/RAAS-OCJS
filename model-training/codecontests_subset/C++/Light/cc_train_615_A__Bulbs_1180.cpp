#include <bits/stdc++.h>
using namespace std;
int n, m, x, y;
int arr[111];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    while (x--) {
      cin >> y;
      arr[y] = 1;
    }
  }
  y = 0;
  for (int i = 1; i <= m; i++) {
    y += arr[i];
  }
  if (y == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
