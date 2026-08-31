#include <bits/stdc++.h>
using namespace std;
int N, M, W[1000], B[1000], last[1000];
bool used[1000];
int main() {
  for (int i = (0); i < (1000); i++) last[i] = -1;
  scanf("%d", &(N));
  scanf("%d", &(M));
  for (int i = (0); i < (N); i++) scanf("%d", &(W[i]));
  for (int i = (0); i < (M); i++) scanf("%d", &(B[i]));
  for (int i = (0); i < (M); i++) B[i]--;
  long long ttotal = 0;
  for (int i = (0); i < (M); i++) {
    long long total = 0;
    for (int j = (0); j < (N); j++) used[j] = false;
    for (int j = (0); j < (i); j++)
      if (j > last[B[i]]) used[B[j]] = true;
    for (int j = (0); j < (N); j++)
      if (used[j]) total += W[j];
    last[B[i]] = i;
    ttotal += total;
  }
  printf("%lld\n", ttotal);
}
