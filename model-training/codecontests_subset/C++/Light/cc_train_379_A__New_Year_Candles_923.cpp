#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int count = 0;
  count += a;
  int rem;
  while (a >= b) {
    rem = a % b;
    a /= b;
    count += a;
    a += rem;
  }
  cout << count << endl;
  return 0;
}
