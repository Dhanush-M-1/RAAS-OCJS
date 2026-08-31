#include<bits/stdc++.h>

using namespace std;

int main()
{
  int X, K, Q;
  int R[100001];


  scanf("%d %d", &X, &K);
  for(int i = 1; i <= K; i++) scanf("%d", &R[i]);
  scanf("%d", &Q);

  R[0] = 0;
  R[K + 1] = 1 << 30;

  int tail = 1;
  int low = 0, high = X;
  int latte = 0, malta = X;

  while(Q--) {
    int T, A;
    scanf("%d %d", &T, &A);
    while(R[tail] <= T) {
      auto beet = R[tail] - R[tail - 1];
      auto delta = beet * (tail % 2 == 0 ? 1 : -1);
      if(tail % 2 == 0) high -= max(0, malta + delta - X);
      else low += max(0, -(latte + delta));
      latte = min(X, max(0, latte + delta));
      malta = min(X, max(0, malta + delta));
      ++tail;
    }
    auto beet = T - R[tail - 1];
    auto delta = beet * (tail % 2 == 0 ? 1 : -1);
    if(low <= A && A <= high) printf("%d\n", min(X, max(0, latte + delta + (A - low))));
    else if(A < low) printf("%d\n", min(X, max(0, latte + delta)));
    else printf("%d\n", min(X, max(0, malta + delta)));
  }

}