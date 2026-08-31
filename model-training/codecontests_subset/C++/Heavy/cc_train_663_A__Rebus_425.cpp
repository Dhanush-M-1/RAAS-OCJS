#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch = 1;
  vector<int> v;
  v.push_back(1);
  while (ch != '=') {
    scanf(" %c", &ch);
    if (ch == '?') continue;
    if (ch == '+') v.push_back(1);
    if (ch == '-') v.push_back(-1);
  }
  int n;
  scanf("%d", &n);
  int men = 0, mai = 0;
  for (int i = 0; i < v.size(); i++) {
    if (v[i] == 1)
      men++, mai += n;
    else
      men -= n, mai--;
  };
  if (men > n || mai < n) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n");
  for (int i = 0; i < v.size(); i++) {
    if (i) {
      if (v[i] == 1)
        printf(" + ");
      else
        printf(" - ");
    }
    int dif = mai - n;
    int u = min(dif, n - 1);
    mai -= u;
    if (v[i] == 1)
      printf("%d", n - u);
    else
      printf("%d", 1 + u);
  }
  printf(" = %d\n", n);
}
