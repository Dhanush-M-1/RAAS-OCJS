#include <bits/stdc++.h>
using namespace std;
int a[26];
int main() {
  int k;
  cin >> k;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); i++) a[s[i] - 'a']++;
  bool poss = true;
  for (int i = 0; i < 26; i++) {
    if (a[i] % k != 0) {
      poss = false;
      break;
    }
  }
  if (poss) {
    for (int i = 0; i < k; i++)
      for (int j = 0; j < 26; j++)
        if (a[j] != 0)
          for (int q = 0; q < a[j] / k; q++) cout << (char)(j + 'a');
    cout << endl;
  } else
    cout << "-1" << endl;
  return 0;
}
