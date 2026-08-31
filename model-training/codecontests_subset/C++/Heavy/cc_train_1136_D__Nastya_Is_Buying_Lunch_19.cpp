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
int n, m, i, j, x, y, p[300005], f[300005], ans;
set<int> s[300005];
vector<int> all;
int main() {
  ios_base::sync_with_stdio(false);
  ;
  cin >> n >> m;
  for (((i)) = (1); ((i)) <= ((n)); ((i))++) {
    cin >> x;
    p[x] = i;
  }
  for (((i)) = (1); ((i)) <= ((m)); ((i))++) {
    cin >> x >> y;
    x = p[x];
    y = p[y];
    s[x].insert(y);
  }
  all.push_back(n);
  for (((i)) = ((n - 1)); ((i)) >= (1); ((i))--) {
    for (j = 0; j < all.size(); j++)
      if (!s[i].count(all[j])) break;
    if (j == all.size())
      ans++;
    else
      all.push_back(i);
  }
  cout << ans << endl;
  return 0;
}
