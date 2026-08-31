#include <bits/stdc++.h>
using namespace std;
int N;
char S[105];
int main() {
  scanf("%d", &N);
  scanf("%s", S);
  int cnt = 0;
  for (int i = 0; i < N; i++)
    if (S[i] == '8') cnt++;
  printf("%d", min(cnt, N / 11));
  return 0;
}
