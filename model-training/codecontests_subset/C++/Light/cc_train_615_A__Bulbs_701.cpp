#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  bool bulbs[m + 1];
  for (int i = 0; i <= m; i++) bulbs[i] = false;
  int count = 0;
  for (int i = 0, x; i < n; i++) {
    cin >> x;
    for (int j = 0, y; j < x; j++) {
      cin >> y;
      if (!bulbs[y]) count++;
      bulbs[y] = true;
    }
  }
  if (count == m)
    cout << "YES";
  else
    cout << "NO";
}
