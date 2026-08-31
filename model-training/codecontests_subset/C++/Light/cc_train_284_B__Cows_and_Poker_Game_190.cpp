#include <bits/stdc++.h>
using namespace std;
char s[300005];
int main(int argc, char* argv[]) {
  std::ios::sync_with_stdio(false);
  int n;
  scanf("%d", &n);
  scanf("%s", s);
  int num_i = 0, num_a = 0;
  bool flag_i = false;
  for (int i = 0; i < n; i++) {
    if (s[i] == 'I') {
      flag_i = true;
      num_i++;
    }
    if (s[i] == 'A') num_a++;
  }
  if (flag_i) {
    if (num_i > 1) num_i = 0;
    printf("%d\n", num_i);
  } else
    printf("%d\n", num_a);
  return 0;
}
