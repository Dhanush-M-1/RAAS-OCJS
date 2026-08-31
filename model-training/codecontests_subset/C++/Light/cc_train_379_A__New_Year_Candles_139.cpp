#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int rem = 0;
  int hrs = 0;
  while (a > 0) {
    hrs += a;
    rem += a;
    a = rem / b;
    rem %= b;
  }
  cout << hrs << endl;
}
