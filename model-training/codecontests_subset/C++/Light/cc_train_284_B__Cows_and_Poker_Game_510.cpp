#include <bits/stdc++.h>
using namespace std;
long long LLMAX = 9223372036854775807LL;
const int maxn = 1000 + 10;
char str[200000 + 100];
int main() {
  int ans = 0, n;
  int cnt[3] = {0};
  scanf("%d\n", &n);
  gets(str);
  for (int i = 0; i < n; ++i) {
    if (str[i] == 'A')
      cnt[0]++;
    else if (str[i] == 'F')
      cnt[1]++;
    else
      cnt[2]++;
  }
  if (cnt[2] > 0) {
    if (cnt[2] == 1)
      puts("1");
    else
      puts("0");
  } else
    printf("%d\n", cnt[0]);
}
