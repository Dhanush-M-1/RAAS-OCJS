#include <bits/stdc++.h>
char gao[100];
int x;
int main() {
  scanf("%s", gao);
  scanf("%d", &x);
  for (int i = 0; i < strlen(gao); ++i) {
    int t;
    if (gao[i] >= 'A' && gao[i] <= 'Z')
      t = gao[i] - 'A';
    else
      t = gao[i] - 'a';
    if (t < x)
      printf("%c", t + 'A');
    else
      printf("%c", t + 'a');
  }
  puts("");
}
