#include <bits/stdc++.h>
char Input[100];
int i, L, c;
char x;
int main() {
  scanf("%s", Input);
  scanf("%d", &c);
  L = strlen(Input);
  for (i = 0; i < L; i++)
    if (Input[i] <= 90) Input[i] += 32;
  for (i = 0; i < L; i++)
    if (Input[i] < (c + 97)) Input[i] -= 32;
  printf("%s\n", Input);
  return 0;
}
