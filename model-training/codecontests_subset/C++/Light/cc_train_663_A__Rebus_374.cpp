#include <bits/stdc++.h>
using namespace std;
int main() {
  int s[101], count = 1;
  s[1] = 1;
  int add = 1, sub = 0, n;
  char c;
  cin >> c;
  while (c != '=') {
    if (c == '+') {
      add++;
      s[++count] = 1;
    } else if (c == '-') {
      sub++;
      s[++count] = 0;
    }
    cin >> c;
  }
  cin >> n;
  if ((n > n * add - sub) || (n < add - n * sub)) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  int i, j, ans[count + 1];
  for (i = 1; i <= count; i++) {
    ans[i] = 1;
  }
  int total = add - sub;
  while (total < n) {
    for (i = 1; i <= count; i++) {
      if (s[i] == 0 || ans[i] == n) continue;
      while (total < n && ans[i] < n) {
        total++;
        ans[i]++;
      }
    }
  }
  while (total > n) {
    for (i = 1; i <= count; i++) {
      if (s[i] == 1 || ans[i] == n) continue;
      while (total > n && ans[i] < n) {
        total--;
        ans[i]++;
      }
    }
  }
  for (i = 1; i <= count; i++) {
    cout << ans[i] << " ";
    if (i == count) continue;
    if (s[i + 1] == 1)
      cout << "+ ";
    else
      cout << "- ";
  }
  cout << "= " << n << endl;
  return 0;
}
