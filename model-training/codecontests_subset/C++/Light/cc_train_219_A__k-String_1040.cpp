#include <bits/stdc++.h>
using namespace std;
string s;
int k, num[26];
int main() {
  cin >> k >> s;
  for (int i = 0; i < (int)s.size(); i++) num[s[i] - 'a']++;
  for (int i = 0; i < 26; i++)
    if (num[i] % k != 0) {
      cout << -1 << endl;
      return 0;
    }
  for (int i = 0; i < k; i++)
    for (int j = 0; j < 26; j++)
      for (int l = 0; l < num[j] / k; l++) cout << (char)(j + 'a');
  cout << endl;
  return 0;
}
