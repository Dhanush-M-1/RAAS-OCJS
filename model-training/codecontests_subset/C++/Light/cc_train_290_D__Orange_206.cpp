#include <bits/stdc++.h>
int main() {
  char in[100];
  int a;
  scanf("%s", in);
  int len = strlen(in);
  scanf("%d", &a);
  for (int i = 0; i < len; i++) {
    if (in[i] >= 'A' && in[i] <= 'Z') in[i] = in[i] + 'a' - 'A';
    if (in[i] < a + 97) {
      in[i] = in[i] + 'A' - 'a';
    }
  }
  puts(in);
  return 0;
}
