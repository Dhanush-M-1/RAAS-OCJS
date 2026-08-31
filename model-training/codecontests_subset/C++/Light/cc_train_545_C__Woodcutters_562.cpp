#include <bits/stdc++.h>
using namespace std;
int N;
long long X[110000], H[110000];
long long lowbond = 0;
int main() {
  scanf("%d", &N);
  int ans = 0;
  for (int i = 0; i < N; i++) {
    scanf("%I64d %I64d", &X[i], &H[i]);
  }
  for (int i = 0; i < N; i++) {
    if (i == 0 || i == N - 1)
      ans++;
    else {
      if ((X[i] - H[i] > X[i - 1]) && (X[i] - H[i] > lowbond)) {
        ans++;
      } else if (X[i] + H[i] < X[i + 1]) {
        ans++;
        lowbond = X[i] + H[i];
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
