#include <bits/stdc++.h>
using namespace std;
char ch[60];
int main() {
  int a;
  scanf("%s", &ch);
  scanf("%d", &a);
  int len = strlen(ch);
  for (int i = 0; i < len; i++) {
    if (ch[i] >= 'A' && ch[i] <= 'Z') ch[i] = ch[i] + 32;
    if (ch[i] - 'a' < a) ch[i] = ch[i] - 32;
  }
  printf("%s\n", ch);
}
