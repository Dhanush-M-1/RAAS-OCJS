#include <bits/stdc++.h>
using namespace std;
long long divi = 1;
int main() {
  long long n;
  cin >> n;
  long long i = 2;
  int c = 0;
  long long nn = n;
  while (i * i <= n) {
    while (n % i == 0) {
      if (c < 2) {
        divi *= i;
      }
      n = n / i;
      c++;
    }
    i++;
  }
  if (n != nn && n > 1) {
    if (c < 2) {
      divi *= n;
    }
    c++;
  }
  if (c <= 0) {
    cout << 1 << endl;
    cout << 0 << endl;
  } else if (c > 2) {
    cout << 1 << endl;
    cout << divi << endl;
  } else {
    cout << 2 << endl;
  }
  return 0;
}
