#include <bits/stdc++.h>
using namespace std;
int a, b, kq, i;
int main() {
  cin >> a >> b;
  while (a) {
    a--;
    kq++;
    i++;
    if (i == b) {
      a++;
      i = 0;
    }
  }
  cout << kq;
  return 0;
}
