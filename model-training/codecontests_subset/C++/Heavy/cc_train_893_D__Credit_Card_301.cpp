#include <bits/stdc++.h>
constexpr int MAX_N = 100100;
using namespace std;
int n, d;
int arr[MAX_N];
int max_pre[MAX_N];
int main() {
  scanf(" %d %d", &n, &d);
  for (int i = 0; i < n; ++i) {
    scanf(" %d", &arr[i]);
  }
  bool poss = true;
  int cur_min = 0;
  for (int i = 0; i < n; ++i) {
    if (arr[i] == 0) {
      cur_min = max(cur_min, 0);
    } else {
      cur_min += arr[i];
    }
    if (cur_min > d) {
      poss = false;
    }
  }
  if (!poss) {
    printf("-1\n");
  } else {
    for (int i = n - 1; i >= 0; --i) {
      max_pre[i] = max(arr[i], arr[i] + max_pre[i + 1]);
    }
    int ans = 0;
    int cur = 0;
    for (int i = 0; i < n; ++i) {
      if (arr[i] == 0) {
        if (cur < 0) {
          ++ans;
          cur = d - max_pre[i];
        }
      } else {
        cur += arr[i];
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
