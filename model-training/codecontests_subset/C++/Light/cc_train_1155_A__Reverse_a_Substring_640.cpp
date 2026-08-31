#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)2e5 + 100;
const int INF = 0x3f3f3f3f;
int main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int l = 0, r = 0;
  char maxx = 'a';
  for (int i = (0); i <= (n - 1); ++i) {
    if (s[i] > maxx) maxx = s[i], l = i;
    if (s[i] < maxx) {
      r = i;
      break;
    }
  }
  if (r == 0)
    puts("NO");
  else {
    puts("YES");
    printf("%d %d\n", l + 1, r + 1);
  }
}
