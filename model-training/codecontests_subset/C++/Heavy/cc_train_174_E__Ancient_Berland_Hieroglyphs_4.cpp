#include <bits/stdc++.h>
using namespace std;
int a[2 * 1111111], b[1111111], A, B;
int pos[1111111];
int main(int argc, char *argv[]) {
  for (int i = 0; i < 1111111; i++) pos[i] = -1;
  scanf("%d%d", &A, &B);
  for (int i = 0; i < A; i++) {
    scanf("%d", a + i);
    a[A + i] = a[i];
  }
  for (int i = 0; i < B; i++) scanf("%d", b + i);
  for (int i = 0; i < B; i++) pos[b[i]] = i;
  int start = 0, end = 0, best = 0;
  while (start < A && pos[a[start]] == -1) start++;
  if (start == A) {
    printf("0\n");
    return 0;
  }
  end = start;
  bool over = false;
  while (start < A) {
    while (
        pos[a[end + 1]] != -1 &&
        ((!over &&
          (pos[a[end + 1]] > pos[a[end]] || pos[a[end + 1]] < pos[a[start]])) ||
         (pos[a[end + 1]] > pos[a[end]] && pos[a[end + 1]] < pos[a[start]]))) {
      if (pos[a[end + 1]] <= pos[a[end]]) over = true;
      end++;
    }
    best = max(best, end - start + 1);
    start++;
    if (end < start) {
      over = false;
      while (start < A && pos[a[start]] == -1) start++;
      end = start;
    } else if (pos[a[start]] < pos[a[start - 1]])
      over = false;
  }
  printf("%d\n", best);
  return 0;
}
