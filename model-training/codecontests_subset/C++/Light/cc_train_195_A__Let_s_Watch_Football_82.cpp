#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int a, b, c;
  cin >> a >> b >> c;
  if (a <= b) {
    cout << 0;
  } else {
    if (c * (a - b) % b == 0) {
      cout << c * (a - b) / b;
    } else {
      cout << c * (a - b) / b + 1;
    }
  }
}
