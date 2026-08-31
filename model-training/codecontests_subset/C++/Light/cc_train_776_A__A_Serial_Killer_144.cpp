#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  int i;
  char name1[20], name2[20];
  char tname1[20], tname2[20];
  scanf("%s%s", name1, name2);
  cin >> n;
  for (i = 0; i < n; i++) {
    printf("%s %s\n", name1, name2);
    scanf("%s%s", tname1, tname2);
    if (strcmp(name1, tname1) == 0)
      strcpy(name1, tname2);
    else
      strcpy(name2, tname2);
  }
  printf("%s %s\n", name1, name2);
  return 0;
}
