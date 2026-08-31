#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  int flag = 0;
  string s;
  cin >> s;
  int arr[26];
  for (int i = 0; i < 26; i++) arr[i] = 0;
  for (int i = 0; i < s.length(); i++) ++arr[s[i] - 'a'];
  for (int i = 0; i < 26; i++) {
    if (arr[i] % k != 0) {
      cout << -1;
      flag = 1;
      break;
    }
  }
  int l1 = 0;
  int len = s.length();
  int flag2 = 0;
  string b = "";
  if (!flag) {
    for (int j = 0; j < k; j++)
      for (int i = 0; i < 26; i++) {
        if (arr[i] != 0) {
          int m = arr[i] / k;
          for (int q = 0; q < m; q++) b += 'a' + i;
        }
      }
    cout << b;
  }
}
