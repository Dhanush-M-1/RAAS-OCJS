#include <bits/stdc++.h>
using namespace std;
int k;
void calc(int x) {
  string s = " ";
  while (x) {
    s = char('0' + x % k) + s;
    x /= k;
  }
  cout << s;
}
int main() {
  cin >> k;
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) calc(i * j);
    cout << endl;
  }
}
