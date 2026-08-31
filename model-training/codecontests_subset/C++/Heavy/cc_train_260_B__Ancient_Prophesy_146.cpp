#include <bits/stdc++.h>
using namespace std;
struct Node {
  int y, m, d;
  Node(int y = 0, int m = 0, int d = 0) : y(y), m(m), d(d) {}
  bool operator<(const Node &b) const {
    if (y != b.y) return y < b.y;
    if (m != b.m) return m < b.m;
    return d < b.d;
  }
  void out() { printf("%02d-%02d-%04d\n", d, m, y); }
};
const int b[8] = {0, 1, 3, 4, 6, 7, 8, 9};
const int f[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
char s[200005];
map<Node, int> mp;
inline int val(char c) { return c - '0'; }
inline int day(char *a) { return val(a[0]) * 10 + val(a[1]); }
inline int month(char *a) { return val(a[0]) * 10 + val(a[1]); }
inline int year(char *a) { return day(a) * 100 + day(a + 2); }
void gao(char *a) {
  int y, m, d;
  for (int i = 0; i < 8; ++i)
    if (!isdigit(a[b[i]])) return;
  if (a[2] != '-' || a[5] != '-') return;
  d = day(a);
  m = month(a + 3);
  if (m < 1 || m > 12) return;
  if (d < 1 || d > f[m]) return;
  y = year(a + 6);
  if (y < 2013 || y > 2015) return;
  ++mp[Node(y, m, d)];
}
int main() {
  scanf("%s", s);
  int n = strlen(s);
  for (int i = 0; i + 10 <= n; ++i) gao(s + i);
  Node ans;
  int cnt = -1;
  for (map<Node, int>::iterator it = mp.begin(); it != mp.end(); ++it)
    if (it->second > cnt) {
      cnt = it->second;
      ans = it->first;
    }
  ans.out();
  return 0;
}
