#include <bits/stdc++.h>
using namespace std;
const long long Mod = 1000000007;
int arr[105];
int main() {
  int n, k;
  scanf("%d %d", &n, &k);
  for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
  sort(arr, arr + n);
  for (int i = n - 1; i >= 0; i--) {
    if (k % arr[i] == 0) {
      printf("%d\n", k / arr[i]);
      return 0;
    }
  }
  return 0;
}
