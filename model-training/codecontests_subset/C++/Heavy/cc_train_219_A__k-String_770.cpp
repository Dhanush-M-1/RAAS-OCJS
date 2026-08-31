#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  string str, ans = "";
  cin >> str;
  int arr[26];
  for (int i = 0; i < 26; i++) arr[i] = 0;
  for (int i = 0; i < str.length(); i++) arr[str[i] - 'a']++;
  bool test = true;
  for (int i = 0; i < 26; i++) {
    if (arr[i] % k != 0) {
      test = false;
      break;
    }
  }
  if (!test)
    cout << -1;
  else {
    for (int i = 0; i < 26; i++) {
      if (arr[i] != 0) {
        arr[i] = arr[i] / k;
        while (arr[i] != 0) {
          ans += char(i + 'a');
          arr[i]--;
        }
      }
    }
    for (int i = 0; i < k; i++) cout << ans;
  }
  return 0;
}
