#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int arr[n][2], *pt2, (*pt1)[2];
  pt1 = arr;
  pt2 = arr[2];
  for (int i = 0; i < n; i++) {
    pt2 = (int*)pt1;
    scanf("%d", (pt2 + 0));
    printf(" ");
    scanf("%d", (pt2 + 1));
    pt1++;
  }
  pt1 = arr;
  int cnt = 0, tem1 = 0, tem2 = 0;
  int(*pt11)[2];
  pt11 = arr;
  for (int j = 0; j < n - 1; j++) {
    pt2 = (int*)pt1;
    tem1 = *(pt2 + 1);
    pt11 = pt1;
    for (int k = j + 1; k < n; k++) {
      pt11++;
      pt2 = (int*)pt11;
      tem2 = *(pt2 + 0);
      if (tem1 == tem2) {
        cnt++;
      }
    }
    pt1++;
  }
  for (int j = n - 1; j >= 0; j--) {
    pt2 = (int*)pt1;
    tem1 = *(pt2 + 1);
    pt11 = pt1;
    for (int k = j - 1; k >= 0; k--) {
      pt11--;
      pt2 = (int*)pt11;
      tem2 = *(pt2 + 0);
      if (tem1 == tem2) {
        cnt++;
      }
    }
    pt1--;
  }
  printf("%d\n", cnt);
  return 0;
}
