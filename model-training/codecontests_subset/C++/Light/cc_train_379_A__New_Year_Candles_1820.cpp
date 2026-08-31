#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int count = 0;
  int z = 0;
  while (a > 0) {
    count++;
    a--;
    z++;
    if (z == b) {
      z = 0;
      a++;
    }
  }
  cout << count;
  return 0;
}
