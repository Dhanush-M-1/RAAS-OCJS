#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  string str;
  scanf("%d", &n);
  getchar();
  getline(cin, str);
  for (int i = 1; i < str.length(); i++) {
    if (str[i] < str[i - 1]) {
      printf("YES\n");
      printf("%d %d", i, i + 1);
      return 0;
    }
  }
  printf("NO");
  return 0;
}
