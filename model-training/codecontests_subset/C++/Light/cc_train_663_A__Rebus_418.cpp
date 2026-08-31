#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:134217728")
using namespace std;
char buf[2];
vector<int> sign;
int n;
int main() {
  sign.push_back(1);
  scanf("%s", buf);
  while (1) {
    scanf("%s", buf);
    if (buf[0] == '=') break;
    sign.push_back(buf[0] == '+' ? 1 : -1);
    scanf("%s", buf);
  }
  scanf("%d", &n);
  int MIN = 0;
  int MAX = 0;
  vector<int> res;
  for (int i = 0; i < sign.size(); ++i) {
    if (sign[i] == 1) {
      MIN++;
      MAX += n;
      res.push_back(n);
    } else {
      MIN -= n;
      MAX--;
      res.push_back(1);
    }
  }
  if (MIN <= n && n <= MAX) {
    printf("Possible\n");
    int need = MAX - n;
    for (int i = 0; i < res.size(); ++i) {
      if (sign[i] == 1) {
        int d = min(need, res[i] - 1);
        res[i] -= d;
        need -= d;
      } else {
        int d = min(need, n - res[i]);
        res[i] += d;
        need -= d;
      }
    }
    printf("%d", res[0]);
    for (int i = 1; i < res.size(); ++i) {
      if (sign[i] == 1)
        printf(" + ");
      else
        printf(" - ");
      printf("%d", res[i]);
    }
    printf(" = %d\n", n);
  } else
    printf("Impossible\n");
  return 0;
}
