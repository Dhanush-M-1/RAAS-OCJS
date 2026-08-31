#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> n;
  cin >> s;
  int cnt = 0;
  for (int k = 0; k < n; k++)
    if (s[k] == '8') cnt++;
  cout << min(cnt, n / 11);
  return 0;
}
