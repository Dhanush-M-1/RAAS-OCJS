#include <bits/stdc++.h>
using namespace std;
int main() {
  float a, b, c;
  while (cin >> a >> b >> c) {
    float i = 0.0;
    for (; i < a * c / b - c; i += 1)
      ;
    cout << i << endl;
  }
  return 0;
}
