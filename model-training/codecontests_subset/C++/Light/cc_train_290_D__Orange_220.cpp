#include <bits/stdc++.h>
using namespace std;
char upper(char c) {
  if ('A' <= c and c <= 'Z') return c;
  return c - 'a' + 'A';
}
char lower(char c) {
  if ('a' <= c and c <= 'z') return c;
  return c - 'A' + 'a';
}
char str[64];
int aux;
int main() {
  scanf("%s", str);
  string s = str;
  scanf("%d", &aux);
  for (int i = 0; i < (int)s.size(); i++) s[i] = lower(s[i]);
  for (int i = 0; i < (int)s.size(); i++) {
    char p = s[i];
    if ((int)p < aux + 97)
      printf("%c", upper(p));
    else
      printf("%c", lower(p));
  }
  printf("\n");
  return 0;
}
