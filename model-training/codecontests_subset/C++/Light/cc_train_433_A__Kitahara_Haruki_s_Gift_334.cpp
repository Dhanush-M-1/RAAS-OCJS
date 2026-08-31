#include <bits/stdc++.h>
using namespace std;
int N, v[105], i, S1, S2;
int main() {
  scanf("%d", &N);
  for (i = 1; i <= N; i++) scanf("%d", &v[i]);
  sort(v + 1, v + N + 1);
  for (i = N; i; i--) {
    if (S1 < S2)
      S1 += v[i];
    else
      S2 += v[i];
  }
  if (S1 == S2)
    printf("YES");
  else
    printf("NO");
  return 0;
}
