#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, res = 0;
  cin >> a >> b;
  res = a + a / b;
  for (int i = a + 1; i <= res; i++) {
    res += i % b == 0;
  }
  cout << res;
}
