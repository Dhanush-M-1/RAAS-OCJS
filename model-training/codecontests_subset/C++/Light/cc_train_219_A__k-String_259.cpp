#include <bits/stdc++.h>
int main() {
  char s[1001];
  int freq[26] = {};
  int i, j, k, l, z;
  scanf("%d%s", &k, s);
  l = strlen(s);
  for (i = 0; i < l; i++) {
    int b = s[i] - 'a';
    freq[b]++;
  }
  for (i = 0; i < 26; i++) {
    if ((freq[i] % k) != 0) {
      printf("-1");
      return 0;
    }
  }
  for (i = 0; i < 26; i++) {
    if (freq[i]) freq[i] = freq[i] / k;
  }
  for (z = 0; z < k; z++) {
    for (i = 0; i < 26; i++) {
      if (!freq[i]) continue;
      for (j = 0; j < freq[i]; j++) putchar('a' + i);
    }
  }
  return 0;
}
