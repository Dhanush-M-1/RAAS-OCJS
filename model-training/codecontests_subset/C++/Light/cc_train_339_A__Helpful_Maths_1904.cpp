#include <bits/stdc++.h>
using namespace std;
int main() {
  string s;
  cin >> s;
  int f[3] = {};
  for (long long i = 0; i < s.size(); i++) {
    if (s[i] != '+') {
      f[s[i] - '1']++;
    }
  }
  int k = 1, t = f[0] + f[1] + f[2];
  for (int i = 0; i < t; i++) {
    while (!f[k - 1]) k++;
    if (i < t - 1)
      cout << k << '+';
    else
      cout << k;
    f[k - 1]--;
  }
  return 0;
}
