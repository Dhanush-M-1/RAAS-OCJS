#include <bits/stdc++.h>
using namespace std;
int k;
string iomap[10][10];
string chan(int x) {
  string ans = "";
  while (x) {
    ans += (char)((x % k) + '0');
    x /= k;
  }
  reverse(ans.begin(), ans.end());
  return ans;
}
int main() {
  cin >> k;
  for (int i = 1; i <= k - 1; i++) {
    for (int j = 1; j <= k - 1; j++) {
      int tmp = i * j;
      iomap[i][j] = chan(tmp);
    }
  }
  for (int i = 1; i <= k - 1; i++) {
    for (int j = 1; j <= k - 1; j++) cout << iomap[i][j] << " ";
    cout << endl;
  }
  return 0;
}
