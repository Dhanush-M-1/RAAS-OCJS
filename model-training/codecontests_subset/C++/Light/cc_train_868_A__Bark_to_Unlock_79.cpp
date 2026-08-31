#include <bits/stdc++.h>
const int N = 1005;
using namespace std;
int n;
char str[N];
char s[N][N];
char tmp[N];
int main() {
  cin >> str;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      strcpy(tmp, s[i]);
      strcat(tmp, s[j]);
      if (strstr(tmp, str)) {
        cout << "YES" << endl;
        return 0;
      }
    }
  cout << "NO";
  return 0;
}
