#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int d = 0;
  while (a != 0) {
    a--;
    d++;
    if (d % b == 0) {
      d++;
    }
  }
  cout << d;
}
