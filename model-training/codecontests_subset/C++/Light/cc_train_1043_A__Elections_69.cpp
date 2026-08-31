#include <bits/stdc++.h>
using namespace std;
int N, S, ANS;
int main() {
  scanf("%d", &N);
  for (int i = 0, x; i < N; i++) {
    scanf("%d", &x);
    S += x, ANS = max(ANS, x);
  }
  while (ANS * N - S <= S) ANS++;
  printf("%d\n", ANS);
}
