#include <bits/stdc++.h>
const int MAXN = 110;
using namespace std;
int arr[MAXN];
int main() {
  int n, c;
  cin >> n >> c;
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }
  int ans = 0;
  for (int i = 0; i < n - 1; i++) {
    ans = max(ans, arr[i] - arr[i + 1] - c);
  }
  printf("%d\n", ans);
  return 0;
}
