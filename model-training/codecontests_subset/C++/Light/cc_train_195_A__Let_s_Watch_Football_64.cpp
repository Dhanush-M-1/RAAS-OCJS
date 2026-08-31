#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  for (int t = 0; t <= 1000000; ++t) {
    if (t * b >= a * c) {
      cout << t - c << '\n';
      return 0;
    }
  }
}
