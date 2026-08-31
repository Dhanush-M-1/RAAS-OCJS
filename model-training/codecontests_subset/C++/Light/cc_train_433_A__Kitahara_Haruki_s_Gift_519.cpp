#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x = 0, y = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (a == 100)
      x++;
    else if (a == 200)
      y++;
  }
  if (x % 2 != 0 && y % 2 != 0)
    cout << "NO";
  else if (x % 2 != 0 && y % 2 == 0)
    cout << "NO";
  else if (x % 2 == 0 && y % 2 != 0 && x != 0)
    cout << "YES";
  else if (x % 2 == 0 && y % 2 == 0)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
