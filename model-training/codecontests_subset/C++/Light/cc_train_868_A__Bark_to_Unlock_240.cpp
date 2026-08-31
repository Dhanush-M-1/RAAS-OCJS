#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1000;
bool flag1[105], flag2[105];
int main() {
  memset(flag1, 0, sizeof flag1);
  memset(flag2, 0, sizeof(flag2));
  char s[10], s1[10];
  cin >> s1;
  int t;
  cin >> t;
  int k = t;
  int flag = 0;
  while (t--) {
    cin >> s;
    flag1[s[1] - 'a'] = true;
    flag2[s[0] - 'a'] = true;
    if (strcmp(s, s1) == 0) flag = 1;
  }
  if (flag1[s1[0] - 'a'] == true && flag2[s1[1] - 'a'] == true || flag == 1) {
    cout << "YES";
  } else if (strcmp(s, s1) == 0 && k == 1)
    cout << "YES";
  else
    cout << "NO";
}
