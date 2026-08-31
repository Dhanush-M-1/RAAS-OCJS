#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int s = a;
  int q = 0;
  for (int i = 0;; i++) {
    s += (a + q) / b;
    int w = q;
    q = (a + q) % b;
    a = (a + w) / b;
    if (a + q < b) {
      break;
    }
  }
  cout << s;
  return 0;
}
