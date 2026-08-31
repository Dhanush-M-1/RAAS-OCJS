#include <bits/stdc++.h>
using namespace std;
char s[200001];
int main() {
  int N;
  while (~scanf("%d", &N)) {
    scanf("%s", s);
    int counter = 0;
    for (int i = 0; i < N; i++) {
      if (s[i] == 'I') counter++;
    }
    if (counter > 1) {
      printf("0\n");
    } else if (counter == 1) {
      printf("1\n");
    } else {
      int result = 0;
      for (int i = 0; i < N; i++) {
        if (s[i] == 'A') result++;
      }
      printf("%d\n", result);
    }
  }
  return 0;
}
