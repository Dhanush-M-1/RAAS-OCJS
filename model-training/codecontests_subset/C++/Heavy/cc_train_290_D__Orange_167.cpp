#include <bits/stdc++.h>
using namespace std;
inline long long readInt() {
  register int c = getchar();
  long long x = 0, neg = 0;
  for (; ((c < 48 || c > 57) && c != '-'); c = getchar())
    ;
  if (c == '-') {
    neg = 1;
    c = getchar();
  }
  for (; c > 47 && c < 58; c = getchar()) x = (x << 1) + (x << 3) + c - 48;
  return (neg) ? -x : x;
}
inline void printInt(long long x) {
  char pri[30];
  int i = 0;
  if (x < 0) {
    putchar('-');
    x = -x;
  }
  do {
    pri[i++] = (x % 10) + 48;
    x /= 10;
  } while (x != 0);
  for (int j = (i - 1); j > (0 - 1); j -= 1) putchar(pri[j]);
}
void solve() {
  string s;
  int n;
  cin >> s >> n;
  for (char *i = &s[0]; *i; i++) {
    if (*i < 'a') *i += 'a' - 'A';
    if (*i < n + 97) *i += 'A' - 'a';
  }
  cout << s << endl;
}
int main() {
  if (0) {
    double _time = clock();
    freopen("input.txt", "r", stdin);
    solve();
    printf("%0.4f sec\n", (clock() - _time) / CLOCKS_PER_SEC);
    return 0;
  }
  solve();
  return 0;
}
