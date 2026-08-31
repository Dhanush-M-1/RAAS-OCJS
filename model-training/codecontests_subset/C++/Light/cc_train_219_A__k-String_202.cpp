#include <bits/stdc++.h>
using namespace std;
int k, mark[40];
string s, s1;
int main() {
  cin >> k >> s;
  for (int i = 0; i < s.size(); i++) mark[(int)s[i] - 'a']++;
  for (int i = 0; i < 26; i++) {
    if (mark[i] % k != 0) return cout << -1, 0;
    if (mark[i] > 0)
      for (int j = 0; j < (mark[i] / k); j++) s1 += (char)i + 'a';
  }
  for (int i = 0; i < k; i++) cout << s1;
  return 0;
}
