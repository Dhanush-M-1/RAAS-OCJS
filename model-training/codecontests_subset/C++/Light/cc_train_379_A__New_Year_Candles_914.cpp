#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, t = 0, k = 0;
  cin >> a;
  cin >> b;
  while (a) {
    a--;
    t++;
    k++;
    if (t == b) {
      a++;
      t = 0;
    }
  }
  cout << k;
  cin >> a;
}
