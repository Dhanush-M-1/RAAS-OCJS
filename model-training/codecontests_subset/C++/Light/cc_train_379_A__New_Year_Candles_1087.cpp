#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, i;
  cin >> a >> b;
  int c = a;
  while (a >= b) {
    c++;
    a++;
    a = a - b;
  }
  i++;
  cout << c;
  return 0;
}
