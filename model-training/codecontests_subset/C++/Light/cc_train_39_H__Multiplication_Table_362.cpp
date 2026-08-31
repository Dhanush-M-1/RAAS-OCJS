#include <bits/stdc++.h>
using namespace std;
string co(int n, int t) {
  string s = "";
  while (t >= 1) {
    s += (t % n) + 48;
    t = t / n;
  }
  int l = s.length();
  reverse(s.begin(), s.end());
  return s;
}
int main() {
  int n, i, j;
  cin >> n;
  for (i = 1; i <= n - 1; i++) {
    for (j = 1; j <= n - 1; j++) {
      int t = i * j;
      if (t <= n - 1)
        cout << t << " ";
      else {
        cout << co(n, t) << " ";
      }
    }
    cout << endl;
  }
  return 0;
}
