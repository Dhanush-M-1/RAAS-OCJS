#include <bits/stdc++.h>
using namespace std;
int main() {
  char mat[3];
  scanf("%s", mat);
  int n;
  scanf("%d", &n);
  char a[n][3];
  for (int i = 0; i < n; i++) scanf("%s", a[i]);
  bool flag = 0;
  for (int i = 0; i < n; i++) {
    if (a[i][0] == mat[0] && a[i][1] == mat[1] ||
        a[i][0] == mat[1] && a[i][1] == mat[0])
      flag = 1;
    for (int j = 0; j < n; j++) {
      if (a[i][1] == mat[0] && a[j][0] == mat[1]) flag = 1;
    }
  }
  if (flag)
    cout << "YES";
  else
    cout << "NO";
}
