#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int tot = 0, co = 0;
  while (tot < a * c) {
    co++;
    if (tot >= a * c - b * c) break;
    tot += b;
  }
  cout << co - 1;
  int i;
  cin >> i;
}
