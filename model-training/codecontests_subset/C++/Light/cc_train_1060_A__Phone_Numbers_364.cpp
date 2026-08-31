#include <bits/stdc++.h>
using namespace std;
int n;
string s;
int main() {
  cin >> n;
  cin >> s;
  int ans = 0;
  int k = 0;
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '8') k++;
  int res = n / 11;
  ans = min(k, res);
  cout << ans;
}
