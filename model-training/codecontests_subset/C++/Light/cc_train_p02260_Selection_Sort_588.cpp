#include <algorithm>
#include <cstdio>

static const size_t N_MAX = 100;

int main() {
  size_t N;
  int A[N_MAX];
  scanf("%zu", &N);
  for (size_t i = 0; i < N; i++)
    scanf("%d", &A[i]);
  int c = 0;
  for (size_t i = 0; i < N - 1; i++) {
    auto m = std::min_element(A + i, A + N);
    if (A[i] != *m) {
      std::swap(A[i], *m);
      c++;
    }
  }
  for (size_t i = 0; i < N - 1; i++)
    printf("%d ", A[i]);
  printf("%d\n", A[N-1]);
  printf("%d\n", c);
  return 0;
}