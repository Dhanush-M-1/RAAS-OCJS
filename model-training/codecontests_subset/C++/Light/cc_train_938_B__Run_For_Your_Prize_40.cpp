#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int n, arr[100001], a, b, t;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &arr[i]);
  }
  int pos1 = 1, pos2 = 1e6;
  int i = 0;
  while (i < n && arr[i] - pos1 <= pos2 - arr[i]) {
    a = i;
    i++;
  }
  if (i == n) {
    printf("%d\n", arr[i - 1] - 1);
    return 0;
  }
  i--;
  printf("%d\n", max(arr[i] - 1, (max(0, pos2 - arr[i + 1]))));
  return 0;
}
