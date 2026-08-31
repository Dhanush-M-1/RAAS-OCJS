#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005;
int n;
int Max1, Max2;
int main(int argc, char const *argv[]) {
  scanf("%d", &n);
  int Pos;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &Pos);
    if (Pos <= 500000) {
      Max1 = max(Max1, Pos - 1);
    } else {
      Max2 = max(Max2, 1000000 - Pos);
    }
  }
  printf("%d\n", max(Max1, Max2));
  return 0;
}
