#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d\n", &n);
  char tmp;
  int cnt_A = 0;
  int cnt_I = 0;
  for (int i = 0; i < n; i++) {
    scanf("%c", &tmp);
    if (tmp == 'A') cnt_A++;
    if (tmp == 'I') cnt_I++;
  }
  if (cnt_I == 0)
    printf("%d\n", cnt_A);
  else {
    if (cnt_I > 1)
      printf("%d\n", 0);
    else
      printf("%d\n", cnt_I);
  }
  return 0;
}
