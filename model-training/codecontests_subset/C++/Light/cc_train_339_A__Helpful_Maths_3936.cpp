#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  int i, j = 0, n, num[200], temp;
  cin >> s;
  for (i = 0; i < s.size(); i = i + 2) {
    j = j + 1;
    if (s[i] == '1')
      num[j] = 1;
    else if (s[i] == '2')
      num[j] = 2;
    else if (s[i] == '3')
      num[j] = 3;
  }
  n = j;
  for (i = 1; i <= n - 1; i++)
    for (j = 1; j <= n - i; j++) {
      if (num[j] > num[j + 1]) {
        temp = num[j];
        num[j] = num[j + 1];
        num[j + 1] = temp;
      }
    }
  cout << num[1];
  for (i = 2; i < n; i++) cout << "+" << num[i];
  if (n != 1) cout << "+" << num[n];
}
