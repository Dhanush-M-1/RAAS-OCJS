#include <bits/stdc++.h>
int main() {
  char inp[1000];
  int one = 0, two = 0, three = 0, plus = 0;
  scanf("%s", inp);
  for (int i = 0; i < strlen(inp); i++) {
    if (inp[i] == '1') {
      one++;
    } else if (inp[i] == '2') {
      two++;
    } else if (inp[i] == '3') {
      three++;
    } else if (inp[i] == '+') {
      plus++;
    }
  }
  for (int i = 0; i < strlen(inp); i++) {
    if (i % 2 != 0) {
      printf("+");
    } else if (one > 0) {
      printf("1");
      one--;
    } else if (two > 0) {
      printf("2");
      two--;
    } else if (three > 0) {
      printf("3");
      three--;
    }
  }
}
