#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, x, arr[101] = {0}, y;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> y;
      arr[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (arr[i] == 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
