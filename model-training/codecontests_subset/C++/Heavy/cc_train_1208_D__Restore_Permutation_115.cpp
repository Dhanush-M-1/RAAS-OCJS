#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f, N = 2e5 + 5;
inline int read() {
  int sum = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') f = -f;
    c = getchar();
  }
  while (c >= '0' && c <= '9') sum = sum * 10 + c - 48, c = getchar();
  return sum * f;
}
int n, a[N];
long long pre[N], c[N], s[N], ans[N];
bool vis[N];
void add(int x, int v) {
  for (int i = x; i <= n; i += (i & -i)) c[i] += v;
}
long long query(int x) {
  long long ans = 0;
  for (int i = x; i > 0; i -= (i & -i)) ans += c[i];
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++) pre[i] = pre[i - 1] + i - 1;
  for (int i = n; i >= 1; i--) {
    int l = 1, r = n, pos = 0;
    while (l <= r) {
      int mid = (l + r) >> 1;
      long long tmp = query(mid);
      if (pre[mid] - tmp > s[i])
        r = mid - 1;
      else if (pre[mid] - tmp == s[i] && vis[mid])
        l = mid + 1;
      else if (pre[mid] - tmp == s[i]) {
        pos = mid;
        break;
      } else
        l = mid + 1;
    }
    ans[i] = pos;
    vis[pos] = 1;
    add(pos + 1, pos);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << ' ';
  cout << '\n';
  return 0;
}
