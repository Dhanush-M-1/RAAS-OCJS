#include <bits/stdc++.h>
using namespace std;
int main() {
  int arr[3][100005];
  int n;
  scanf("%d", &n);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < n - i; j++) scanf("%d", &arr[i][j]);
    sort(arr[i], arr[i] + n - i);
  }
  for (int i = 0; i < n; i++) {
    if (arr[0][i] != arr[1][i]) {
      printf("%d\n", arr[0][i]);
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (arr[1][i] != arr[2][i]) {
      printf("%d\n", arr[1][i]);
      break;
    }
  }
}
