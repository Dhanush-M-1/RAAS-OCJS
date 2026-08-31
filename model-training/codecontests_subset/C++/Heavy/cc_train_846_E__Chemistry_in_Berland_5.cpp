#include <bits/stdc++.h>
using namespace std;
inline void read(int &x) {
  int v = 0, f = 1;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = (c & 15);
  while (isdigit(c = getchar())) v = (v << 1) + (v << 3) + (c & 15);
  x = v * f;
}
inline void read(long long &x) {
  long long v = 0ll, f = 1ll;
  char c = getchar();
  while (!isdigit(c) && c != '-') c = getchar();
  if (c == '-')
    f = -1;
  else
    v = (c & 15);
  while (isdigit(c = getchar())) v = (v << 1) + (v << 3) + (c & 15);
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
long long n, m, i, j, b[100005], a[100005], f[100005], x, y;
vector<pair<long long, long long> > e[100005];
long long mul(long long x, long long y) {
  x = abs(x);
  long long t = 0x1bbbbbbbbbbbbbbbll / y;
  if (t < x) return -0x1bbbbbbbbbbbbbbbll;
  return -min(0x1bbbbbbbbbbbbbbbll, x * y);
}
long long add(long long x, long long y) {
  return max(-0x1bbbbbbbbbbbbbbbll, x + y);
}
void dfs(long long x) {
  f[x] = b[x] - a[x];
  for (__typeof((e[x]).begin()) it = (e[x]).begin(); it != (e[x]).end(); it++) {
    dfs(it->first);
    if (f[it->first] < 0) {
      f[it->first] = mul(f[it->first], it->second);
    }
    f[x] = add(f[x], f[it->first]);
  }
}
int main() {
  read(n);
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    read(b[i]);
  }
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    read(a[i]);
  }
  for ((i) = (2); (i) <= (n); (i)++) {
    read(x);
    read(y);
    e[x].push_back(make_pair(i, y));
  }
  dfs(1);
  if (f[1] >= 0) {
    cout << "YES";
    return 0;
  }
  {
    cout << "NO";
    return 0;
  }
  return 0;
}
