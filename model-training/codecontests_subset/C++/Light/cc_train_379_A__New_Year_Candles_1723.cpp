#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, t = 0, n = 0;
  cin >> a >> b;
  while (a > 0) {
    a--;
    t++;
    if (t % b == 0) t++;
  }
  cout << t;
  return 0;
}
