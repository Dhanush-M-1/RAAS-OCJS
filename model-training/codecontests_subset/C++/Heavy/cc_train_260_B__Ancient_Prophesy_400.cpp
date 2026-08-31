#include <bits/stdc++.h>
using namespace std;
const double pi = 4.0 * atan(1.0);
const int inf = 99999999;
const signed long long INF = 0x3f3f3f3f3f3f3f3fLL;
const int maxn = 111111;
map<int, int> name;
int ansa, ansb, ansc;
char s[maxn];
bool isok(int a, int b, int c) {
  if (c < 2013 || c > 2015) return false;
  if (a < 1 || a > 31) return false;
  if (b < 1 || b > 12) return false;
  if (b == 2) {
    if (a >= 29) return false;
    return true;
  }
  if (b == 4 || b == 6 || b == 9 || b == 11) {
    if (a > 30) return false;
    return true;
  }
  return true;
}
void cop(int a, int b, int c) { ++name[c + b * 10000 + a * 1000000]; }
void check(char *s) {
  int a, b, c;
  int i;
  for (i = 0; s[i]; ++i) {
    if (s[i] == '-') break;
  }
  if (s[i] == NULL) return;
  if (isdigit(s[i - 2]) && isdigit(s[i - 1]))
    a = (s[i - 2] - '0') * 10 + s[i - 1] - '0';
  else
    return;
  if (isdigit(s[i + 1]) && isdigit(s[i + 2]) && s[i + 3] == '-')
    b = (s[i + 1] - '0') * 10 + s[i + 2] - '0';
  else
    return;
  i = i + 4;
  if (isdigit(s[i]) && isdigit(s[i + 1]) && isdigit(s[i + 2]) &&
      isdigit(s[i + 3]))
    c = (s[i] - '0') * 1000 + (s[i + 1] - '0') * 100 + (s[i + 2] - '0') * 10 +
        s[i + 3] - '0';
  else
    return;
  if (isok(a, b, c)) cop(a, b, c);
}
void doit() {
  int k = -1;
  check(s);
  int len = strlen(s);
  for (int i = 2; i < len; ++i)
    if (s[i] == '-') {
      check(s + i);
    }
  map<int, int>::iterator it;
  for (it = name.begin(); it != name.end(); ++it) {
    if (it->second > k) {
      k = it->second;
      int z = it->first;
      ansc = z % 10000;
      z /= 10000;
      ansb = z % 100;
      z /= 100;
      ansa = z;
    }
  }
  printf("%02d-%02d-%d\n", ansa, ansb, ansc);
}
int main() {
  scanf("%s", s);
  doit();
  return 0;
}
