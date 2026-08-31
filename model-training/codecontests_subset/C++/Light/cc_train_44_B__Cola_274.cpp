#include <bits/stdc++.h>
const double PI = acos(-1);
const double EPS = 1e-12;
const int MOD = 1e9 + 7;
const int INF = 1 << 30;
using namespace std;
int main() {
  int in, a, b, c;
  int cnt = 0, temp;
  cin >> in >> a >> b >> c;
  a /= 2;
  for (int i = 0; i <= a; i++) {
    for (int j = 0; j <= b; j++) {
      temp = in - i - j;
      if (temp < 0) break;
      if (temp % 2 == 0 && temp <= 2 * c) cnt++;
    }
  }
  cout << cnt << endl;
  return 0;
}
