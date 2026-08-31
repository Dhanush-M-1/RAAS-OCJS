#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, i = 0;
  cin >> a >> b;
  int c = a;
  while (c > 0) {
    i++;
    c--;
    if (i % b == 0) {
      c++;
    }
  }
  cout << i;
}
