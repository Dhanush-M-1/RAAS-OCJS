#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int cnt = a;
  while (a >= b) {
    cnt += a / b;
    a = a / b + a % b;
  }
  cout << cnt << endl;
}
