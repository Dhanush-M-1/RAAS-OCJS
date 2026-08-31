#include <bits/stdc++.h>
using namespace std;
int ss(int a, int b) {
  int total = a;
  while (a >= b) {
    int div = a / b;
    total += div;
    int rem = a % b;
    a = div + rem;
  }
  return total;
}
int main() {
  int a, b;
  cin >> a >> b;
  cout << ss(a, b);
}
