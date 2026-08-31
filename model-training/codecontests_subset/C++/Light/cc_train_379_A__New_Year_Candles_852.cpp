#include <bits/stdc++.h>
using namespace std;
int main() {
  int total, re;
  cin >> total >> re;
  int sum = 0;
  sum += total;
  while (total >= re) {
    sum += total / re;
    total = total / re + total % re;
  }
  cout << sum << endl;
}
