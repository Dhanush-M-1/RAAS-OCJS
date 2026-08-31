#include <bits/stdc++.h>
using namespace std;
int N, A[200005];
int main() {
  scanf("%d", &N);
  long long int X1, X2, X3;
  X1 = X2 = X3 = 0;
  for (int i = 1; i <= N; i++) {
    cin >> X2;
    X1 = X1 ^ X2;
  }
  X2 = 0;
  for (int i = 1; i < N; i++) {
    cin >> X3;
    X2 = X2 ^ X3;
  }
  X3 = 0;
  printf("%lld\n", X1 ^ X2);
  for (int i = 2; i < N; i++) {
    cin >> X1;
    X3 = X3 ^ X1;
  }
  printf("%lld\n", X2 ^ X3);
  return 0;
}
