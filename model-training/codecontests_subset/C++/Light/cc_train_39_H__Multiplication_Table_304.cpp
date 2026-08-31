#include <bits/stdc++.h>
using namespace std;
int n;
int a[10][10];
int j(int b) { return b == 0 ? 0 : j(b / n) * 10 + b % n; }
int main() {
  cin >> n;
  int t = n - 1;
  for (int i = 0; i < t; i++)
    for (int x = 0; x < t; x++) {
      a[i][x] = j((i + 1) * (x + 1));
      cout << a[i][x];
      if (x == t - 1)
        cout << endl;
      else
        cout << " ";
    }
  return 0;
}
