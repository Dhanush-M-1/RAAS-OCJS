#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int total = a * c;
  while (total % b != 0) {
    total++;
  }
  for (int i = 1; i <= c; i++) {
    total -= b;
  }
  cout << total / b;
}
