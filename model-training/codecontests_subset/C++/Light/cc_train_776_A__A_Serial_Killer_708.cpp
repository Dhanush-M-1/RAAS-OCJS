#include <bits/stdc++.h>
char s1[22], s2[22], ns1[22], ns2[22];
int main() {
  int n, len1, len2, nlen1, nlen2;
  scanf("%s %s %d", s1, s2, &n);
  len1 = strlen(s1);
  len2 = strlen(s2);
  printf("%s %s\n", s1, s2);
  for (int i = 0; i < n; i++) {
    scanf("%s %s", ns1, ns2);
    nlen1 = strlen(ns1);
    nlen2 = strlen(ns2);
    if (len1 == nlen1) {
      bool sta = 1;
      for (int i = 0; i < len1; i++) {
        if (s1[i] != ns1[i]) {
          sta = 0;
          break;
        }
      }
      if (sta) {
        printf("%s %s\n", s2, ns2);
        for (int i = 0; i <= len1; i++) s1[i] = 0;
        for (int i = 0; i <= nlen2; i++) s1[i] = ns2[i];
        len1 = nlen2;
        continue;
      }
    }
    if (len2 == nlen1) {
      bool sta = 1;
      for (int i = 0; i < len2; i++) {
        if (s2[i] != ns1[i]) {
          sta = 0;
          break;
        }
      }
      if (sta) {
        printf("%s %s\n", s1, ns2);
        for (int i = 0; i <= len2; i++) s2[i] = 0;
        for (int i = 0; i <= nlen2; i++) s2[i] = ns2[i];
        len2 = nlen2;
        continue;
      }
    }
  }
  return 0;
}
