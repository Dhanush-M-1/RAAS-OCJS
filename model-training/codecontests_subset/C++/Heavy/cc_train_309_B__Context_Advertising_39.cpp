#include <bits/stdc++.h>
using namespace std;
char buf[1 << 21], *p1 = buf, *p2 = buf;
template <class T>
void read(T &x) {
  x = 0;
  int c = getchar();
  int flag = 0;
  while (c < '0' || c > '9') flag |= (c == '-'), c = getchar();
  while (c >= '0' && c <= '9')
    x = (x << 3) + (x << 1) + (c ^ 48), c = getchar();
  if (flag) x = -x;
}
template <class T>
T _max(T a, T b) {
  return b < a ? a : b;
}
template <class T>
T _min(T a, T b) {
  return a < b ? a : b;
}
template <class T>
bool checkmax(T &a, T b) {
  return a < b ? a = b, 1 : 0;
}
template <class T>
bool checkmin(T &a, T b) {
  return b < a ? a = b, 1 : 0;
}
const int N = 1000005, LOG = 20;
int n, r, c;
string s[N];
int a[N], sum[N];
int nxt[LOG + 1][N];
bool check(int idx, int mid) {
  int tot = sum[mid] - sum[idx - 1];
  tot += mid - idx;
  return tot <= c;
}
void init() {
  cin >> n >> r >> c;
  for (int i = 1; i <= n; ++i) {
    cin >> s[i];
    a[i] = (int)s[i].size();
    sum[i] = sum[i - 1] + a[i];
  }
  for (int i = 1; i <= n; ++i) {
    if (a[i] > c) {
      nxt[0][i] = i;
      continue;
    }
    int l = i, r = n, mid, best = i;
    while (l <= r) {
      mid = (l + r) >> 1;
      if (check(i, mid))
        best = mid, l = mid + 1;
      else
        r = mid - 1;
    }
    nxt[0][i] = best + 1;
  }
  for (int i = 0; i <= LOG; ++i) nxt[i][n + 1] = n + 1;
  for (int i = 1; i <= LOG; ++i) {
    for (int j = 1; j <= n; ++j) {
      nxt[i][j] = nxt[i - 1][nxt[i - 1][j]];
    }
  }
}
void print(int l, int r) {
  if (l > r) exit(0);
  for (int i = l; i < r; ++i) cout << s[i] << " ";
  cout << s[r] << endl;
}
void solve() {
  int pos = 0, Max = 0;
  for (int i = 1; i <= n; ++i) {
    if (a[i] > c) continue;
    int now = i;
    for (int j = LOG; j >= 0; --j)
      if (r >> j & 1) {
        if (nxt[j][now]) now = nxt[j][now];
        if (now > n) break;
      }
    if (now > i) --now;
    if (checkmax(Max, now - i + 1)) pos = i;
  }
  if (pos == 0) {
    for (int i = 1; i <= r; ++i) printf("\n");
    return;
  }
  int now = pos;
  for (int i = 1; i <= r; ++i) {
    print(now, nxt[0][now] - 1);
    now = nxt[0][now];
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  init();
  solve();
  return 0;
}
