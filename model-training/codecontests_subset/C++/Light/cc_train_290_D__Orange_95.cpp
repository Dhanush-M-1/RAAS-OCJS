#include <bits/stdc++.h>
using namespace std;
int main() {
  char s[55];
  int N, M;
  string ret;
  scanf("%s", s);
  scanf("%d", &N);
  M = strlen(s);
  for (int i = 0; i < M; i++) s[i] = tolower(s[i]);
  for (int i = 0; i < M; i++) {
    if (s[i] < N + 97)
      ret += toupper(s[i]);
    else
      ret += tolower(s[i]);
  }
  printf("%s\n", ret.c_str());
}
