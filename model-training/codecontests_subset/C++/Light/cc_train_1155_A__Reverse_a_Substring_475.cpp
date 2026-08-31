#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
char str[maxn];
int main() {
  int n;
  scanf("%d", &n);
  scanf("%s", str);
  int mmax = str[0] - 'a', pos = 0, ok = 1;
  for (int i = 1; i < n; i++) {
    if (mmax < str[i] - 'a') {
      mmax = str[i] - 'a';
      pos = i;
    } else if (str[i] - 'a' < mmax) {
      printf("YES\n");
      printf("%d %d\n", pos + 1, i + 1);
      ok = 0;
      break;
    }
  }
  if (ok) printf("NO\n");
  return 0;
}
