#include <bits/stdc++.h>
inline long long read() {
  long long x = 0;
  char ch = getchar(), w = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * w;
}
void write(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) write(x / 10);
  putchar(x % 10 + '0');
}
inline void writeln(long long x) {
  write(x);
  puts("");
}
using namespace std;
const int N = 3e5 + 666;
vector<int> G[N];
int n, siz[N];
void dfs(int x, int F) {
  siz[x] = 1;
  for (int y : G[x])
    if (y != F) {
      dfs(y, x);
      siz[x] += siz[y];
    }
}
vector<int> ans;
void del(int x, int F) {
  for (int y : G[x])
    if (y != F) {
      if (siz[y] % 2 == 0) del(y, x);
    }
  if (x) ans.push_back(x);
  for (int y : G[x])
    if (y != F) {
      if (siz[y] % 2) del(y, x);
    }
}
int main() {
  n = read();
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  for (int i = 1; i <= n; ++i) {
    int x = read();
    G[x].push_back(i);
    G[i].push_back(x);
  }
  dfs(0, 0);
  del(0, 0);
  puts("YES");
  for (int i : ans) writeln(i);
  return 0;
}
