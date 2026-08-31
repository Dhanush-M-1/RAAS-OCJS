#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, tmp;
  cin >> a >> b;
  int cnt = 0;
  tmp = a;
  while (a > 0) {
    cnt++;
    a--;
    if (tmp - a == b) {
      a++;
      tmp = a;
    }
  }
  cout << cnt;
}
