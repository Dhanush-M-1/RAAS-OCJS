#include <bits/stdc++.h>
using namespace std;
string mabna(int x, int k) {
  string ans;
  while (x != 0) {
    int z = x % k;
    ans += char(z + '0');
    x /= k;
  }
  string ans2;
  for (int i = ans.size() - 1; i >= 0; i--) ans2 += ans[i];
  return ans2;
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) cout << mabna(i * j, n) << " ";
    cout << endl;
  }
}
