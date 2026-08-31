#include <bits/stdc++.h>
using namespace std;
char s[200005];
int main() {
  int n;
  cin >> n;
  scanf("%s", s);
  int res1 = 0, res2 = 0;
  for (int i = 0; i <= n; i++) {
    if (s[i] == 'A') res1++;
    if (s[i] == 'I') res2++;
  }
  if (res2 == 0) {
    printf("%d", res1);
  } else if (res2 == 1) {
    printf("%d", res2);
  } else
    printf("0");
}
