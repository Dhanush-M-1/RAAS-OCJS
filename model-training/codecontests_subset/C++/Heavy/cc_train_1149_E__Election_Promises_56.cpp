#include <bits/stdc++.h>
using namespace std;
inline void read(int &x) {
  int v = 0, f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = v * 10 + c - '0';
  while (isdigit(c = getchar())) v = v * 10 + c - '0';
  x = v * f;
}
inline void read(long long &x) {
  long long v = 0ll, f = 1ll;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = v * 10 + c - '0';
  while (isdigit(c = getchar())) v = v * 10 + c - '0';
  x = v * f;
}
inline void readc(char &x) {
  char c;
  while ((c = getchar()) == ' ')
    ;
  x = c;
}
inline void writes(string s) { puts(s.c_str()); }
inline void writeln() { writes(""); }
inline void writei(int x) {
  if (x < 0) {
    putchar('-');
    x = abs(x);
  }
  if (!x) putchar('0');
  char a[25];
  int top = 0;
  while (x) {
    a[++top] = (x % 10) + '0';
    x /= 10;
  }
  while (top) {
    putchar(a[top]);
    top--;
  }
}
inline void writell(long long x) {
  if (x < 0) {
    putchar('-');
    x = abs(x);
  }
  if (!x) putchar('0');
  char a[25];
  int top = 0;
  while (x) {
    a[++top] = (x % 10) + '0';
    x /= 10;
  }
  while (top) {
    putchar(a[top]);
    top--;
  }
}
int n, m, i, j, a[200005], f[200005], s[200005], vis[200005], ti, mx;
vector<int> e[200005];
int dfs(int x);
void mex(int x) {
  for (__typeof((e[x]).begin()) it = (e[x]).begin(); it != (e[x]).end(); it++)
    dfs(*it);
  ti++;
  for (__typeof((e[x]).begin()) it = (e[x]).begin(); it != (e[x]).end(); it++)
    vis[dfs(*it)] = ti;
  for (f[x] = 0; vis[f[x]] == ti; f[x]++)
    ;
}
int dfs(int x) {
  if (f[x] != -1) return f[x];
  mex(x);
  return f[x];
}
void solve(int x) {
  a[x] ^= s[mx];
  s[mx] = 0;
  for (__typeof((e[x]).begin()) it = (e[x]).begin(); it != (e[x]).end(); it++) {
    a[*it] ^= s[f[*it]];
    s[f[*it]] = 0;
  }
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) printf("%d ", a[i]);
}
int main() {
  read(n);
  read(m);
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) read(a[i]);
  for (((i)) = (1); ((i)) <= ((m)); ((i))++) {
    int x, y;
    read(x);
    read(y);
    e[x].push_back(y);
  }
  memset(f, -1, sizeof(f));
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    mx = max(mx, dfs(i));
    s[dfs(i)] ^= a[i];
  }
  while (mx >= 0) {
    for (((i)) = (1); ((i)) <= ((n)); ((i))++)
      if (f[i] == mx && (s[mx] ^ a[i]) < a[i]) {
        puts("WIN");
        solve(i);
        return 0;
      }
    mx--;
  }
  {
    cout << "LOSE";
    return 0;
  }
  return 0;
}
