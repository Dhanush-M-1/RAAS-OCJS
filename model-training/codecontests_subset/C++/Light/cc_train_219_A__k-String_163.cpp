#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, n, i, arr[27];
  char s[1001];
  cin >> k;
  cin >> s;
  n = strlen(s);
  for (i = 0; i <= 26; i++) arr[i] = 0;
  for (i = 0; i < n; i++) arr[s[i] - 'a']++;
  for (i = 0; i < 26; i++)
    if (arr[i] % k) {
      cout << -1 << endl;
      return 0;
    }
  int j, ki = 0;
  for (i = 0; i < 26; i++) {
    for (j = 0; j < (arr[i] / k); j++) s[ki++] = 'a' + i;
  }
  s[ki] = '\0';
  for (i = 0; i < k; i++) cout << s;
  cout << endl;
  return 0;
}
