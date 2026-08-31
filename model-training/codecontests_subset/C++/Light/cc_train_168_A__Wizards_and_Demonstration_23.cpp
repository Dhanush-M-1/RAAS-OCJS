#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int citizens, wizards, percentage, result;
  scanf("%d %d %d", &citizens, &wizards, &percentage);
  result = ceil((percentage * citizens) / 100.0);
  result = max(result - wizards, 0);
  printf("%d\n", result);
  return 0;
}
