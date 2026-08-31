#include <bits/stdc++.h>
using namespace std;
int arr[1009];
bool check1(int num, int sum, int n) {
  int tsum = 0;
  for (int i = 0; i < n; ++i) {
    if (arr[i] > num) return false;
    tsum = tsum + (num - arr[i]);
  }
  if (tsum > sum)
    return true;
  else
    return false;
}
int main() {
  int n, i, sum = 0;
  scanf("%d", &n);
  for (i = 0; i < n; ++i) scanf("%d", &arr[i]);
  for (i = 0; i < n; ++i) sum += arr[i];
  sort(arr, arr + n);
  int ml = 2 * arr[n - 1] + 1;
  int ms = arr[0];
  int ans = -1;
  for (i = ms; i <= ml; ++i) {
    if (check1(i, sum, n)) {
      ans = i;
      break;
    }
  }
  printf("%d", ans);
  return 0;
}
