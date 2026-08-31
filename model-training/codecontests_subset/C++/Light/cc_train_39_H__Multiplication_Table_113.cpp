#include <bits/stdc++.h>
using namespace std;
void print(int x, int b) {
  if (x) {
    print(x / b, b);
    printf("%d", x % b);
  }
}
int main() {
  int k;
  cin >> k;
  for (int i = (1); i <= (k - 1); ++i)
    for (int j = (1); j <= (k - 1); ++j)
      print(i * j, k), printf("%c", j == k - 1 ? '\n' : ' ');
  return 0;
}
