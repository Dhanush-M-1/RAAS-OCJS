#include <bits/stdc++.h>
using namespace std;
bool lambs[101];
int main() {
  int n, m;
  cin >> n >> m;
  while (n--) {
    int x;
    cin >> x;
    while (x--) {
      int y;
      cin >> y;
      lambs[y] = true;
    }
  }
  for (int i = 1; i < m + 1; i++)
    if (lambs[i] == false) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
