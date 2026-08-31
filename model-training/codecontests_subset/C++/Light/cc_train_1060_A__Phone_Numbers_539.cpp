#include <bits/stdc++.h>
using namespace std;
char S[11000];
int n, Ans;
inline int Min(register int A, register int B) { return A < B ? A : B; }
int main() {
  scanf("%d%s", &n, S + 1);
  for (register int i = 1; i <= n; i++) Ans += (S[i] == '8');
  printf("%d\n", Min(n / 11, Ans));
}
