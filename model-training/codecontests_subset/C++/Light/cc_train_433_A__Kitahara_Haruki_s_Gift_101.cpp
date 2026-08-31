#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int o = 0, t = 0;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (x == 100)
      o++;
    else
      t++;
  }
  if (t == n || o == n) {
    puts(n & 1 ? "NO" : "YES");
  } else if (t & 1 && o) {
    t %= 2;
    o -= 2 * t;
    puts(o < 0 || o & 1 ? "NO" : "YES");
  } else {
    puts(o & 1 ? "NO" : "YES");
  }
  return 0;
}
