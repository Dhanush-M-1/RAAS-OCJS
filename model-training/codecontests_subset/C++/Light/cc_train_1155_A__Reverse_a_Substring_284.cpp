#include <bits/stdc++.h>
using namespace std;
const int mod = 1000000007;
const int maxn = 5e5 + 10;
const double pi = acos(-1);
int main() {
  int n;
  string s, ss;
  cin >> n >> s;
  ss = s;
  sort(ss.begin(), ss.end());
  if (ss == s) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  int pos1 = 0;
  while (ss[pos1] == s[pos1]) pos1++;
  int pos2 = pos1 + 1;
  for (int i = pos1 + 1; i <= n - 1; ++i)
    if (s[i] <= ss[pos2]) {
      pos2 = i;
      break;
    }
  cout << pos1 + 1 << " " << pos2 + 1 << endl;
  return 0;
}
