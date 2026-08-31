#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch;
  int sum;
  int p = 1, m = 0;
  vector<bool> signs;
  signs.push_back(1);
  while (cin >> ch)
    if (ch == '+') {
      signs.push_back(1);
      p++;
    } else if (ch == '-') {
      signs.push_back(0);
      m++;
    } else if (ch == '=') {
      cin >> sum;
      break;
    }
  if (sum * p - m < sum || p - m * sum > sum) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n", sum);
  int need_p = max(sum + m - p, 0);
  int need_m = max(need_p + p - m - sum, 0);
  for (int i = 0; i < signs.size(); ++i) {
    if (signs[i]) {
      int toPut = 1;
      if (need_p != 0) {
        toPut += need_p;
        if (toPut > sum) toPut = sum;
        need_p -= (toPut - 1);
      }
      if (i) printf(" + ");
      printf("%d", toPut);
    } else {
      int toPut = 1;
      if (need_m != 0) {
        toPut += need_m;
        if (toPut > sum) toPut = sum;
        need_m -= (toPut - 1);
      }
      printf(" - %d", toPut);
    }
  }
  printf(" = %d\n", sum);
  return 0;
}
