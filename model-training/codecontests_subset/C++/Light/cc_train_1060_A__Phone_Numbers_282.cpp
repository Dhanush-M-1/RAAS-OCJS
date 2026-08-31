#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  string str;
  cin >> str;
  int i, ans = 0;
  for (i = 0; i < t; i++) {
    if (str.at(i) == '8') ans++;
  }
  int k = t / 11;
  if (ans > k || ans == k)
    cout << k << endl;
  else
    cout << ans << endl;
  return 0;
}
