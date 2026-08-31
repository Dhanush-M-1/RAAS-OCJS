#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 50;
char s[N];
int main() {
  int n;
  scanf("%d%s", &n, &s);
  for (int i = 1; i < n; i++) {
    if (s[i - 1] > s[i]) {
      puts("YES");
      printf("%d %d", i, i + 1);
      exit(0);
    }
  }
  puts("NO");
  return 0;
}
