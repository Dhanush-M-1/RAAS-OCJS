#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  char c = getchar();
  long long f = 1, x = 0;
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 1) + (x << 3) + (c ^ '0');
    c = getchar();
  }
  return x * f;
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
char s[3];
char b[3];
int main() {
  scanf("%s", s + 1);
  long long flag = 0;
  long long ff = 0, f = 0, fff = 0;
  long long n = read();
  for (int i = 1; i <= n; i++) {
    memset(b, '\0', sizeof(b));
    scanf("%s", b + 1);
    if (b[1] == s[1] && b[2] == s[2]) {
      fff = 1;
    }
    if (b[1] == s[2] && b[2] == s[1]) {
      flag = 1;
    }
    if (b[2] == s[1]) {
      f = 1;
    }
    if (b[1] == s[2]) {
      ff = 1;
    }
  }
  if (flag != 0 || ff + f == 2 || fff == 1) {
    printf("YES\n");
  } else {
    printf("NO\n");
  }
  return 0;
}
