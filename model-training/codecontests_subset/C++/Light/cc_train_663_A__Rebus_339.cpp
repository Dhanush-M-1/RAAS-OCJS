#include <bits/stdc++.h>
using namespace std;
int n;
vector<char> sign;
int main() {
  int pos = 1;
  int neg = 0;
  sign.push_back('+');
  scanf("%*c ");
  while (true) {
    char c;
    scanf("%c ", &c);
    if (c == '=') break;
    if (c == '+') pos += 1;
    if (c == '-') neg += 1;
    sign.push_back(c);
    scanf("%*c ");
  }
  scanf("%d", &n);
  if (n < (pos * 1 - neg * n) || (pos * n - neg) < n) {
    printf("Impossible");
    return 0;
  }
  printf("Possible\n");
  int ext = (pos * n - neg) - n;
  bool first = true;
  for (char c : sign) {
    if (first) {
      first = false;
    } else {
      printf("%c ", c);
    }
    if (c == '+')
      printf("%d ", max(1, n - ext));
    else
      printf("%d ", min(n, 1 + ext));
    ext = max(0, ext - n + 1);
  }
  printf("= %d", n);
  return 0;
}
