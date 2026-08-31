#include <bits/stdc++.h>
int convert(int input, int radix) {
  int output = 0;
  int pow = 1;
  output += input % radix;
  input = (input - input % radix) / radix;
  output += 10 * input;
  return output;
}
void print(int n) {
  if (n < 10)
    printf(" %d", n);
  else
    printf("%d", n);
}
int main() {
  int radix;
  scanf("%d", &radix);
  for (int i = 1; i < radix; i++) {
    for (int j = 1; j < radix; j++) {
      if (j == 1)
        printf("%d ", convert(i * j, radix));
      else {
        print(convert(i * j, radix));
        if (j < radix - 1) printf(" ");
      }
    }
    printf("\n");
  }
  return 0;
}
