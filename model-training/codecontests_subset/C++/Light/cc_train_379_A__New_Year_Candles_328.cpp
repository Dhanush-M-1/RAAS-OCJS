#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, count = 0;
  cin >> a >> b;
  count = a;
  while (a - b >= 0) {
    int x = a / b;
    count += x;
    a = x + a % b;
  }
  cout << count << endl;
}
