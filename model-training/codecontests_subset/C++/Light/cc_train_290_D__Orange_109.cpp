#include <bits/stdc++.h>
using namespace std;
char s[1005];
int n;
bool cont(char x) { return (x >= 'a' && x <= 'z'); }
int main() {
  scanf("%s", s);
  scanf("%d", &n);
  for (int i = 0; i < strlen(s); i++) {
    if (cont(s[i]) && s[i] < n + 97) {
      if (cont(s[i])) s[i] -= 32;
    }
    if (cont(s[i]) == 0 && s[i] >= n + 65) s[i] += 32;
  }
  printf("%s\n", s);
  return 0;
}
