#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, i, j;
  string str;
  string ans = "";
  cin >> k;
  cin >> str;
  int arr[26] = {0};
  for (i = 0; i < str.length(); i++) arr[str[i] - 'a']++;
  for (i = 0; i < 26; i++) {
    if (arr[i] != 0) {
      if (arr[i] % k == 0) {
        for (j = 0; j < arr[i] / k; j++) ans += 'a' + i;
      } else {
        ans = "-1";
        break;
      }
    }
  }
  if (ans == "-1")
    cout << ans << endl;
  else {
    for (i = 0; i < k; i++) cout << ans;
    cout << endl;
  }
  return 0;
}
