#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int t = a;
  while (a >= b) {
    int div = (a / b);
    t += div;
    int rem = (a % b);
    a = div + rem;
  }
  cout << t << endl;
}
