#include <bits/stdc++.h>
int main(void) {
  int N;
  scanf("%i", &N);
  int A = 0;
  int F = 0;
  int I = 0;
  char c;
  int i;
  scanf("%c", &c);
  for (i = 0; i < N; i++) {
    scanf("%c", &c);
    if (c == 'A')
      A++;
    else if (c == 'F')
      F++;
    else if (c == 'I')
      I++;
  }
  if (I == 0) {
    printf("%i\n", A);
    return 0;
  }
  if (I == 1) {
    printf("1\n");
    return 0;
  }
  printf("0\n");
  return 0;
}
