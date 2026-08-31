#include <bits/stdc++.h>
int main() {
  int k;
  scanf("%d", &k);
  char c;
  scanf("%c", &c);
  char string[1001];
  gets(string);
  int letter[26];
  int m = 0;
  for (int i = 0; i < 26; i++) {
    letter[i] = 0;
  }
  int a = strlen(string);
  for (int i = 0; i < a; i++) {
    letter[string[i] - 97]++;
  }
  for (int i = 0; i < 26; i++) {
    if (letter[i] != 0) {
      if (letter[i] % k == 0) {
        continue;
      } else {
        printf("-1");
        return 0;
      }
    }
  }
  for (int o = 0; o < k; o++) {
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < (letter[i] / k); j++) {
        printf("%c", i + 'a');
      }
    }
  }
  return 0;
}
