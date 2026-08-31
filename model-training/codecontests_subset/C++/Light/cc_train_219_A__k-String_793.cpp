#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  scanf("%d", &k);
  string s;
  cin >> s;
  if (k == 1) {
    cout << s;
    return 0;
  }
  int n = s.size();
  int a[26] = {0};
  for (int i = 0; i < n; i++) a[s[i] - 'a']++;
  for (int i = 0; i < 26; i++) {
    if (a[i] % k != 0) {
      cout << -1;
      return 0;
    }
  }
  string str = "";
  for (int i = 0; i < 26; i++) {
    if (a[i])
      for (int j = 0; j < a[i] / k; j++) str += ('a' + i);
  }
  for (int i = 0; i < k; i++) cout << str;
  return 0;
}
