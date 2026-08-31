#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  while (cin >> a >> b >> c) {
    int i;
    for (i = 0; i < a * c / b; ++i)
      if (c * a <= (c + i) * b) break;
    cout << i << endl;
  }
}
