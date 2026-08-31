#include <bits/stdc++.h>
using namespace std;
int N;
string s;
int main() {
  scanf("%d", &N);
  cin >> s;
  int temp = -1;
  for (int i = 1; s[i]; i++) {
    if (s[i] < s[i - 1]) {
      temp = i;
      break;
    }
  }
  if (temp == -1)
    printf("NO\n");
  else {
    printf("YES\n");
    temp += 1;
    printf("%d %d\n", temp - 1, temp);
  }
  return 0;
}
