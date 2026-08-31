#include <bits/stdc++.h>
using namespace std;
const int tmax = (int)1e5 + 100;
char str[100];
int main() {
  scanf("%s", str);
  int sz = strlen(str);
  int N;
  scanf("%d", &N);
  string now = "";
  for (int i = 0; i < sz; i++) {
    char c = str[i];
    if (tolower(c) < ('a' + N))
      now += toupper(c);
    else
      now += tolower(c);
  }
  printf("%s\n", now.c_str());
  return 0;
}
