#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int s = a;
  while (a >= b) {
    s = s + (a / b);
    a = a / b + (a % b);
  }
  cout << s << endl;
}
