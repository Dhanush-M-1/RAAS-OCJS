#include <bits/stdc++.h>
using namespace std;
char arr[300001];
int main(void) {
  int N;
  scanf("%d", &N);
  scanf("%s", arr);
  int i;
  char _max = 0;
  int idx = -1;
  for (i = 0; i < N; i++) {
    if (_max < arr[i]) {
      _max = arr[i];
      idx = i;
    }
    if (idx != -1 && _max > arr[i]) {
      printf("YES\n");
      printf("%d %d\n", idx + 1, i + 1);
      return 0;
    }
  }
  printf("NO\n");
  return 0;
}
