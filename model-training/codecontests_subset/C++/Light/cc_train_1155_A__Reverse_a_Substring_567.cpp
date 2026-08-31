#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  bool flag = false;
  int ans;
  for (int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      flag = true;
      ans = i;
      break;
    }
  }
  if (flag == false)
    cout << "NO";
  else {
    cout << "YES" << endl;
    cout << (ans) << " " << ans + 1;
  }
  return 0;
}
