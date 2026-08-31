#include <bits/stdc++.h>
int main() {
  int tombol, lampu, lamp[105], pencet, index, tampung = 0;
  scanf("%d %d", &tombol, &lampu);
  for (int i = 1; i <= lampu; i++) {
    lamp[i] = 0;
  }
  for (int i = 1; i <= tombol; i++) {
    scanf("%d", &pencet);
    for (int j = 1; j <= pencet; j++) {
      scanf("%d", &index);
      if (lamp[index] == 0) {
        tampung++;
        lamp[index] = 1;
      }
    }
  }
  if (tampung == lampu)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
