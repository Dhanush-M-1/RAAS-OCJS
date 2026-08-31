#include <bits/stdc++.h>
using namespace std;
int n, c, arr[102], mx;
int main() {
  scanf("%d %d", &n, &c);
  for (int i = 0; i < n; i++) {
    scanf("%d", &arr[i]);
  }
  for (int i = 0; i < n - 1; i++) {
    mx = max(arr[i] - arr[i + 1] - c, mx);
  }
  printf("%d\n", mx);
  return 0;
}
