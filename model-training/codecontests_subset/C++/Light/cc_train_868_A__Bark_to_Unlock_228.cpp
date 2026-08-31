#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MAXN = 1e5 + 5;
int n;
int main() {
  char s1[5], s2[5];
  scanf("%s", s1);
  scanf("%d", &n);
  bool f1, f2;
  f1 = f2 = false;
  for (int i = 0; i < n; i++) {
    scanf("%s", s2);
    if (s2[0] == s1[0] && s2[1] == s1[1]) {
      f1 = f2 = true;
    }
    if (s2[0] == s1[1]) f1 = true;
    if (s2[1] == s1[0]) f2 = true;
  }
  if (f1 && f2)
    puts("YES");
  else
    puts("NO");
  return 0;
}
