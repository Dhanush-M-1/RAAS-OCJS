#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int N = 3e5 + 10;
char str[N];
int main() {
  int len;
  scanf("%d", &len);
  scanf("%s", str);
  int maxx = str[0], flag = 0, l = 0, r;
  for (int i = 1; i < len; i++) {
    if (str[i] < maxx) {
      r = i;
      flag = 1;
      break;
    } else {
      maxx = str[i];
      l = i;
    }
  }
  if (flag)
    printf("YES\n%d %d\n", l + 1, r + 1);
  else
    printf("NO\n");
  return 0;
}
