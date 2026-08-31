#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, cnt = 0;
  char *s = (char *)malloc(n + 1);
  scanf("%d%s", &n, s);
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') {
      cnt++;
    }
  }
  printf("%d\n", min(n / 11, cnt));
}
