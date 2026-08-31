#include <bits/stdc++.h>
using namespace std;
int k;
void base(int x) {
  int s = 0, i = 1;
  while (x != 0) {
    s = s + i * (x % k);
    x = x / k;
    i *= 10;
  }
  cout << s;
}
int main() {
  cin >> k;
  for (int i = 1; i <= k - 1; ++i) {
    for (int j = 1; j <= k - 1; ++j) {
      base(i * j);
      cout << " ";
    }
    cout << "\n";
  }
}
