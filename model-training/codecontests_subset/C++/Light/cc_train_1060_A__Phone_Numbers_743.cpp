#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 7;
const int INF = 1 << 30;
const int mod = 1e9 + 7;
char s[maxn];
void solve() {
  int n, cnt = 0;
  scanf("%d%s", &n, s);
  int len = strlen(s);
  for (int i = 0; i < len; i++) {
    if (s[i] == '8') {
      ++cnt;
    }
  }
  printf("%d\n", min(n / 11, cnt));
  return;
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
