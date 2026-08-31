#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d ", &n);
  int i, position = -1;
  char s[n];
  for (i = 0; i < n; i++) {
    scanf("%c", &s[i]);
  }
  for (i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      position = i;
      break;
    }
  }
  if (position == -1) {
    printf("NO");
  } else {
    printf("YES\n%d %d", position + 1, position + 2);
  }
  return 0;
}
