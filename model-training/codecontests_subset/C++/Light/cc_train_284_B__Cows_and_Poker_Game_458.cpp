#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  char s[200001];
  scanf("%s", s);
  int countA = 0, countI = 0;
  for (int i = 0; s[i]; i++) {
    if (s[i] == 'A')
      countA++;
    else if (s[i] == 'I')
      countI++;
  }
  int ans = 0;
  if (countI == 1)
    printf("%d\n", countI);
  else if (!countI)
    printf("%d\n", countA);
  else
    printf("%d\n", ans);
  return 0;
}
