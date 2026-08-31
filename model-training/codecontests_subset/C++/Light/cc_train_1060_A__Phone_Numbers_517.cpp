#include <bits/stdc++.h>
using namespace std;
char S[105];
int main() {
  int N, M, i, j, k, ans = 0;
  scanf("%d", &N);
  scanf("%s", S);
  for (i = 0; i < N; i++) {
    ans += ((S[i] - '0') == 8);
  }
  printf("%d\n", min(ans, N / 11));
  return 0;
}
