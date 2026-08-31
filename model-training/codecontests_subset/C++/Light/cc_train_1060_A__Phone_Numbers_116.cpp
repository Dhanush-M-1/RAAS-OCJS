#include <bits/stdc++.h>
int main(void) {
  int n;
  char s[100], dummy[1];
  int number = 0;
  scanf("%d", &n);
  gets(dummy);
  gets(s);
  if (strlen(s) != n) {
    printf("%d", number);
  } else {
    for (int i = 0; i < n; i++) {
      if (s[i] == '0' || s[i] == '1' || s[i] == '2' || s[i] == '3' ||
          s[i] == '4' || s[i] == '5' || s[i] == '6' || s[i] == '7' ||
          s[i] == '8' || s[i] == '9') {
        if (s[i] == '8') {
          number++;
          if (number > n / 11) {
            number--;
            break;
          }
        }
      } else
        break;
    }
    printf("%d", number);
  }
}
