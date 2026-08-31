#include <bits/stdc++.h>
using namespace std;
int N, LST[26];
char S[300005];
int main() {
  scanf("%d", &N);
  scanf("%s", S);
  for (int i = 0; i < 26; i++) LST[i] = -1;
  for (int i = 0; i < N; i++) {
    LST[S[i] - 'a'] = i;
    for (int j = S[i] - 'a' + 1; j < 26; j++) {
      if (LST[j] != -1) {
        printf("YES\n%d %d\n", LST[j] + 1, i + 1);
        return 0;
      }
    }
  }
  printf("NO\n");
  return 0;
}
