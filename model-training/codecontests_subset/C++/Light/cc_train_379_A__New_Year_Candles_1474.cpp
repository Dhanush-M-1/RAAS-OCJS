#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, b, hr;
  cin >> n >> b;
  hr = n;
  while (n >= b) {
    int c = n % b;
    n = n / b;
    hr = hr + n;
    n = n + c;
  }
  cout << hr << endl;
  return 0;
}
