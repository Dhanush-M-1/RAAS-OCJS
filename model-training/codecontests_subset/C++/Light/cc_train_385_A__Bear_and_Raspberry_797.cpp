#include <bits/stdc++.h>
using namespace std;
int main() {
  int d, m;
  int maxP = 0;
  scanf("%d%d", &d, &m);
  vector<int> days(d, 0);
  for (int i = 0; i < d; i++) {
    scanf("%d", &days[i]);
  }
  for (int i = 0; i < (d - 1); i++) {
    if (days[i] - days[i + 1] - m > maxP) {
      maxP = days[i] - days[i + 1] - m;
    }
  }
  printf("%d", maxP);
  return 0;
}
