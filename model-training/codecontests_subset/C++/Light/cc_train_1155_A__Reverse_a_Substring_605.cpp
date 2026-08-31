#include <bits/stdc++.h>
using namespace std;
const int maxn = 300005;
int n;
char S[maxn];
int main() {
  scanf("%d%s", &n, S + 1);
  for (int i = 1; i < n; i++)
    if (S[i] > S[i + 1]) {
      printf("YES\n%d %d\n", i, i + 1);
      return 0;
    }
  puts("NO");
  return 0;
}
