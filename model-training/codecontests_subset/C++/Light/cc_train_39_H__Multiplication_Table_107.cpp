#include <bits/stdc++.h>
using namespace std;
void TO(int x, int y) {
  string s;
  while (x) {
    s += x % y + '0';
    x /= y;
  }
  for (int i = s.size() - 1; i >= 0; i--) cout << s[i];
  cout << ' ';
}
int main() {
  int k;
  cin >> k;
  for (int i = 1; i <= k - 1; i++) {
    for (int j = 1; j <= k - 1; j++) TO(i * j, k);
    cout << endl;
  }
  return 0;
}
