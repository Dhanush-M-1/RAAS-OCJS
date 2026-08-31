#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    while (b >= 1 && c >= 2) {
      b -= 1;
      c -= 2;
      sum += 3;
    }
    while (a >= 1 && b >= 2) {
      a -= 1;
      b -= 2;
      sum += 3;
    }
    std::cout << sum << std::endl;
  }
  return 0;
}
