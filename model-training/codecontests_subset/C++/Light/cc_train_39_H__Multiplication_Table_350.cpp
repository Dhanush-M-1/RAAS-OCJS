#include <bits/stdc++.h>
#pragma comment(linker, "/stack:640000000")
using namespace std;
const int NMAX = 110, base = 1000 * 1000 * 1000, INF = 1000 * 1000 * 1000;
const long double eps = 1e-9, PI = 3.1415926535897932384626433832795;
int k;
string f(int v) {
  string t = "";
  while (v > 0) {
    t += char(v % k + 48);
    v /= k;
  }
  reverse(t.begin(), t.end());
  return t;
}
int main() {
  cin >> k;
  for (int i = 1; i <= (int)(k - 1); i++) {
    for (int j = 1; j <= (int)(k - 1); j++) {
      int mult = i * j;
      cout << f(mult) << ' ';
    }
    cout << endl;
  }
  return 0;
}
