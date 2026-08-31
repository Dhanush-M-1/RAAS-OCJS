#include <bits/stdc++.h>
using namespace std;
const int MaxN = 2000;
int b[MaxN];
int w[MaxN];
int n, m;
bool f[MaxN];
int s[MaxN], top = 0;
int main(void) {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", w + i);
  for (int i = 1; i <= m; ++i) scanf("%d", b + i);
  for (int i = 1; i <= m; ++i) {
    if (!f[b[i]]) s[top++] = b[i];
    f[b[i]] = true;
  }
  reverse(s, s + top);
  long long ans = 0;
  for (int i = 1; i <= m; ++i) {
    long long temp = 0;
    int j;
    for (j = top - 1; j >= 0; --j) {
      if (b[i] == s[j]) break;
      temp += w[s[j]];
    }
    for (int k = j; k < top - 1; ++k) s[k] = s[k + 1];
    s[top - 1] = b[i];
    ans += temp;
  }
  cout << ans << endl;
  return 0;
}
