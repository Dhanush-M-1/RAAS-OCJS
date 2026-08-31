#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, rem = 0, rem1 = 0;
  cin >> a >> b;
  int count = a;
  while ((a + rem) >= b) {
    rem1 = rem;
    count = count + (a + rem1) / b;
    rem = (a + rem1) % b;
    a = (a + rem1) / b;
  }
  cout << count;
  return 0;
}
