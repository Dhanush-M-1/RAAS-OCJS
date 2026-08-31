#include <bits/stdc++.h>
int main() {
  int countData, countDataInSecond, countSecond;
  scanf("%d%d%d", &countData, &countDataInSecond, &countSecond);
  float t = countData - countDataInSecond;
  int waiting = ceil((countSecond * t) / countDataInSecond);
  printf("%d", waiting);
}
