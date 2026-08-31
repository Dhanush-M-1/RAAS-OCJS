#include <bits/stdc++.h>
using namespace std;
map<int, int> m;
int A[100005];
int B[100005];
int C[100005];
vector<int> v;
int main() {
  int N;
  int a1, a2;
  scanf("%d", &N);
  int i;
  for (i = 0; i < N; i++) scanf("%d", A + i);
  for (i = 0; i < N - 1; i++) scanf("%d", B + i);
  for (i = 0; i < N - 2; i++) scanf("%d", C + i);
  for (i = 0; i < N - 2; i++) m[C[i]]++;
  for (i = 0; i < N - 1; i++) {
    m[B[i]]--;
    if (m[B[i]] == -1) a2 = B[i];
  }
  m[a2] = 0;
  for (i = 0; i < N - 1; i++) m[B[i]]++;
  for (i = 0; i < N; i++) {
    m[A[i]]--;
    if (m[A[i]] == -1) a1 = A[i];
  }
  printf("%d\n%d\n", a1, a2);
  return 0;
}
