#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, ans = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < n; i++)
    if (s[i] == '8') ans++;
  cout << min(ans, n / 11);
  return 0;
}
