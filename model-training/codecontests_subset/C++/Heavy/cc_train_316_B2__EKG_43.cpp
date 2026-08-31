#include <bits/stdc++.h>
using namespace std;
int to[2000];
char used[2000];
int a[2000];
int s;
char res[3000];
int calc(int x, char &f) {
  f = 0;
  int cnt = 1;
  if (x == s) f = 1;
  while (to[x] != -1) {
    ++cnt;
    x = to[x];
    if (x == s) {
      f = 1;
      cnt = 1;
    }
  }
  return cnt;
}
int main() {
  int n, x;
  cin >> n >> x;
  --x;
  s = x;
  for (int i = 0; i < n; ++i) to[i] = -1;
  for (int i = 0; i < n; ++i) {
    cin >> to[i];
    --to[i];
    if (to[i] >= 0) used[to[i]] = 1;
  }
  int sl = -1;
  int q = 0;
  for (int i = 0; i < n; ++i)
    if (!used[i]) {
      char f;
      int len = calc(i, f);
      if (f)
        sl = len;
      else
        a[q++] = len;
    }
  assert(sl != -1);
  res[sl] = 1;
  for (int i = 0; i < q; ++i) {
    for (int j = n; j >= 0; --j)
      if (res[j]) res[j + a[i]] = 1;
  }
  for (int i = 0; i <= n; ++i)
    if (res[i]) cout << i << ' ';
}
