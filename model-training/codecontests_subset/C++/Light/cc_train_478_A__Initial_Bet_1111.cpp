#include <bits/stdc++.h>
using namespace std;
int main() {
  int c = 0;
  int tmp = 0;
  for (int i = 0; i < 5; i++) {
    scanf("%d", &tmp);
    c += tmp;
  }
  printf("%d\n", c == 0 || c % 5 != 0 ? -1 : c / 5);
}
