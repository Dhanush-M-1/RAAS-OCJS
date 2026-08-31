#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9, dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
int n;
int f(int x, int base) {
  string s;
  int a = x;
  while (a) {
    s += char(a % base + '0');
    a /= base;
  }
  int ans = 0;
  for (int i = s.size() - 1; i >= 0; i--) ans = ans * 10 + int(s[i] - '0');
  return ans;
}
int main() {
  cin >> n;
  for (int i = 1; i < n; i++, cout << '\n')
    for (int j = 1; j < n; j++) {
      int x = f(i * j, n);
      if (j > 1) {
        if (x < 10)
          cout << "  ";
        else
          cout << ' ';
      }
      cout << x;
    }
  return 0;
}
