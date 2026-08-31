#include <bits/stdc++.h>
using namespace std;
bitset<2 * 411> arr[30][411], ans[411];
char str[411];
int main() {
  int n, m, r, c;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    scanf("%s", str);
    for (int j = 0; j < m; j++) {
      arr[str[j] - 'a'][i][j] = 1;
      arr[str[j] - 'a'][i][j + m] = 1;
      ans[i][j] = 1;
    }
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; i++) {
    scanf("%s", str);
    for (int j = 0; j < c; j++) {
      if (str[j] == '?') continue;
      for (int k = 0; k < n; k++)
        ans[k] &= arr[str[j] - 'a'][(k + i) % n] >> (j % m);
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) printf("%d", (int)ans[i][j]);
    printf("\n");
  }
  return 0;
}
