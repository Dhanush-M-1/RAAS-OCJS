#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int counter = a;
  int rem, quo;
  while (a >= b) {
    rem = a % b;
    quo = a / b;
    a = quo + rem;
    counter += quo;
  }
  cout << counter;
  return 0;
}
