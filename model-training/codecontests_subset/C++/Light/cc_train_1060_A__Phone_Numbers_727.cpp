#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  string str = "";
  cin >> str;
  int cnt8 = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == '8') cnt8++;
  }
  int ans = INT_MIN;
  for (int i = cnt8; i >= 0; i--) {
    int rem = n - i;
    if (rem >= 10 * i) {
      ans = i;
      break;
    }
  }
  cout << ans;
  return 0;
}
