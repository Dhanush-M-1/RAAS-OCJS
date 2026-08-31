#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, s{};
  while (~scanf("%d", &x)) s += x;
  if (s % 5 || s == 0)
    puts("-1");
  else
    printf("%d\n", s / 5);
}
