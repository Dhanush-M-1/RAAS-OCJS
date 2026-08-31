#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  float res;
  cin >> a >> b >> c;
  res = ((float)(a - b) / (float)b);
  res = res * c;
  a = res;
  if (res == a)
    cout << a;
  else
    cout << (a + 1);
  return 0;
}
