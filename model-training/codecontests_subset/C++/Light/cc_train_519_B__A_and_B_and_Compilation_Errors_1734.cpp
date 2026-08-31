#include <bits/stdc++.h>
using namespace std;
void file() {}
const int MN = 1e9 + 1e2;
const int MW = 1e3 + 5;
const int OO = 1e9 + 5;
int main() {
  file();
  int n, x, sm[3]{0};
  scanf("%d", &n);
  for (int i = 0; i < 3; ++i)
    for (int j = 0; j < n - i and scanf("%d", &x); sm[i] += x, ++j)
      ;
  printf("%d", sm[0] - sm[1]), printf("\n"), printf("%d", sm[1] - sm[2]);
  return 0;
}
