#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  map<char, int> mapper;
  char str[200010];
  scanf("%d", &n);
  scanf("%s", str);
  for (int i = 0; i < n; i++) {
    mapper[str[i]]++;
  }
  if (mapper['I'] == 0) {
    printf("%d", mapper['A']);
  } else if (mapper['I'] == 1)
    printf("1");
  else
    printf("0");
  return 0;
}
