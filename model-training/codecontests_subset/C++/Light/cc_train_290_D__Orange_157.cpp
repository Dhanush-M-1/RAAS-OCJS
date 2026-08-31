#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3F3F3F3F;
const int MAXN = 100001;
inline void input() {
  int n;
  char str[1001];
  scanf("%s", str);
  ;
  scanf("%d", &n);
  ;
  int k = strlen(str);
  for (int i = 0; i < k; ++i) {
    str[i] = tolower(str[i]);
    if (str[i] >= 'a' && str[i] < 'a' + n) {
      str[i] = toupper(str[i]);
      ;
    }
  }
  printf("%s\n", str);
}
int main() {
  input();
  return 0;
}
