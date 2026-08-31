#include <bits/stdc++.h>
using namespace std;
int main() {
  char pass[3], str[100][3];
  scanf("%s", pass);
  int n, i, j, flag = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    scanf("%s", str[i]);
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if ((str[i][0] == pass[0] && str[i][1] == pass[1]) ||
          (str[i][1] == pass[0] && str[j][0] == pass[1])) {
        cout << "YES";
        flag++;
        break;
      }
    }
    if (flag != 0) break;
  }
  if (flag == 0) cout << "NO";
  return 0;
}
