#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, hrs = 0;
  cin >> a >> b;
  while (a > 0) {
    if (a - b >= 0) {
      hrs = b + hrs;
      a = a - b;
      a = a + 1;
    } else {
      hrs = hrs + a;
      a = a - a;
    }
  }
  cout << hrs;
  return 0;
}
