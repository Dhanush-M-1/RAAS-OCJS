#include <bits/stdc++.h>
using namespace std;
string s;
int dem[5]{0};
int main() {
  cin >> s;
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '+')
      dem[0]++;
    else
      dem[s[i] - '0']++;
  for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= dem[i]; j++) {
      cout << i;
      if (dem[0] > 0) {
        cout << "+";
        dem[0]--;
      }
    }
  }
  return 0;
}
