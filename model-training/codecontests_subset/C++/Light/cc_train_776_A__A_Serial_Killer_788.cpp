#include <bits/stdc++.h>
using namespace std;
void Main() {
  int sz = 0;
  char ch[4][20];
  scanf("%s%s", ch[0], ch[1]);
  int n;
  scanf("%d", &n);
  while (n--) {
    printf("%s %s\n", ch[0], ch[1]);
    scanf("%s%s", ch[2], ch[3]);
    if (strcmp(ch[2], ch[1]) == 0) {
      memcpy(ch[1], ch[3], sizeof(ch[3]));
    } else if (strcmp(ch[2], ch[0]) == 0) {
      memcpy(ch[0], ch[3], sizeof(ch[3]));
    }
  }
  printf("%s %s\n", ch[0], ch[1]);
}
int main(int argc, char const *argv[]) {
  Main();
  return 0;
}
