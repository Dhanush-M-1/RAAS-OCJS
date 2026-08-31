#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0, hours = 0;
  cin >> a >> b;
  for (int i = 0; i < a; i++) {
    hours += 1;
    sum += 1;
    if (sum == b) {
      a += 1;
      sum = 0;
    }
  }
  cout << hours;
}
