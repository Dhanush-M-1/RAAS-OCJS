#include <bits/stdc++.h>
using namespace std;
long long n, m, i, a, b, x, y;
int main() {
  cin >> a >> b;
  while (a > 0) {
    a--;
    x++;
    if (x % b == 0) a++;
  }
  cout << x;
}
