#include <bits/stdc++.h>
using namespace std;
int n;
char str[1005], s[1005][1005], tmp[1005];
int main() {
  cin >> str >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      strcpy(tmp, s[i]), strcat(tmp, s[j]);
      if (strstr(tmp, str)) {
        cout << "YES";
        return 0;
      }
    }
  }
  cout << "NO";
  return 0;
}
