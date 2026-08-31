#include <bits/stdc++.h>
using namespace std;
void readi(int &x) {
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
void readll(long long &x) {
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
void readc(char &x) {
  char c;
  while ((c = getchar()) == ' ')
    ;
  x = c;
}
void writes(string s) { puts(s.c_str()); }
void writeln() { writes(""); }
void writei(int x) {
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
void writell(long long x) {
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
int n, m, i, j, su[100005], mx[100005], ans, cur, a[100005];
int main() {
  ios::sync_with_stdio(false);
  ;
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = n; i; i--) {
    mx[i] = max(0, max(a[i], mx[i + 1] + a[i]));
  }
  for (i = 1; i <= n; i++) {
    mx[i] = m - mx[i];
  }
  for (i = 1; i <= n; i++) {
    if (cur > mx[i]) {
      cout << -1;
      return 0;
    }
    if (a[i]) {
      cur += a[i];
    } else {
      if (cur < 0) {
        if (mx[i] < 0) {
          cout << -1;
          return 0;
        }
        cur = mx[i];
        ans++;
      }
    }
  }
  cout << ans;
  return 0;
}
