#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0 && cin.tie(0) && cout.tie(0));
  ;
  int k;
  cin >> k;
  string s;
  cin >> s;
  int arr[26] = {0};
  for (int i = 0; i < s.length(); i++) {
    int j = s[i] - 97;
    ++arr[j];
  }
  for (int i = 0; i < 26; i++) {
    if (arr[i] % k != 0) {
      cout << -1;
      return 0;
    }
  }
  string ans;
  for (int i = 0; i < s.length(); i++) {
    if (i == 0) {
      int count = 0;
      for (int j = 0; j < (arr[s[i] - 97] / k); j++) {
        ans += s[i];
        ++count;
      }
    } else {
      for (int j = 0; j < ans.length(); j++) {
        if (s[i] == ans[j]) goto end;
      }
      int count = 0;
      for (int x = 0; x < (arr[s[i] - 97] / k); x++) {
        ans += s[i];
        ++count;
      }
    }
  end:
    continue;
  }
  for (int i = 0; i < k; i++) {
    for (int j = 0; j < ans.length(); j++) {
      cout << ans[j];
    }
  }
  return 0;
}
