#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T abs(T t) {
  return t < 0 ? -t : t;
}
const long long modn = 1000000007;
inline long long mod(long long x) { return x % modn; }
int main() {
  char s1[15], s2[15], s[15];
  int n;
  scanf("%s %s %d", s1, s2, &n);
  printf("%s %s\n", s1, s2);
  for (int i = 0; i < n; i++) {
    scanf("%s", s);
    if (!strcmp(s, s1))
      scanf("%s", s1);
    else
      scanf("%s", s2);
    printf("%s %s\n", s1, s2);
  }
  return 0;
}
