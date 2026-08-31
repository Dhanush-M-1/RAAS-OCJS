#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast,no-stack-protector")
#pragma GCC target("avx")
#pragma GCC target("sse,sse2,sse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
long long read() {
  long long x = 0;
  bool q = 0;
  char c = getchar();
  while (!isdigit(c)) q |= (c == '-'), c = getchar();
  while (isdigit(c)) x = (x << 1) + (x << 3) + c - '0', c = getchar();
  return q ? -x : x;
}
void print(long long x, char q = '\n') {
  if (x < 0) putchar('-'), x = -x;
  if (x == 0) putchar('0');
  stack<char> s;
  s.push(q);
  while (x > 0) s.push(x % 10 + '0'), x /= 10;
  while (!s.empty()) putchar(s.top()), s.pop();
}
string read_s() {
  string s;
  char c = getchar();
  while (c == ' ' || c == '\t' || c == '\n') c = getchar();
  while (c != ' ' && c != '\t' && c != '\n') s += c, c = getchar();
  return s;
}
void print_s(string s, char q = '\n') {
  for (char c : s) putchar(c);
  putchar(q);
}
char read_c() {
  char c = getchar();
  while (c == ' ' || c == '\t' || c == '\n') c = getchar();
  return c;
}
bool isVowel(char q) {
  if (q == 'a') return 1;
  if (q == 'e') return 1;
  if (q == 'i') return 1;
  if (q == 'u') return 1;
  if (q == 'o') return 1;
  return 0;
}
int a[100002];
int main() {
  int n = read();
  for (int i = 0; i < n; i++) a[i] = read();
  sort(a, a + n);
  int ans = 1e9;
  for (int i = 0; i < n - 1; i++)
    ans = min(ans, max(a[i] - 1, 1000000 - a[i + 1]));
  ans = min(ans, a[n - 1] - 1);
  ans = min(ans, 1000000 - a[0]);
  print(ans);
}
