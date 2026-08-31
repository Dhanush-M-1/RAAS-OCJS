#include <bits/stdc++.h>
using namespace std;
const long long t = 9000000000000000000;
int n, m, k;
bool block[10000000];
int cnt[10000000];
int a[10000000];
long long res = t;
int main() {
  cin >> n >> k >> m;
  for (int i = 0; i < k; i++) {
    int tem;
    scanf("%d", &tem);
    block[tem] = true;
  }
  if (block[0]) {
    cout << "-1" << endl;
    return 0;
  }
  for (int i = 1; i <= m; i++) {
    scanf("%d", &a[i]);
  }
  int max_block = 0;
  for (int i = 0; i < n; i++) {
    if (block[i]) cnt[i] = cnt[i - 1] + 1;
    max_block = max(max_block, cnt[i]);
  }
  for (int i = max_block + 1; i <= m; i++) {
    long long count = 0;
    int cur = 0;
    while (cur < n) {
      if (block[cur])
        cur -= cnt[cur];
      else {
        count += a[i];
        cur += i;
      }
    }
    res = min(res, count);
  }
  if (res >= t)
    printf("-1\n");
  else
    cout << res << endl;
  return 0;
}
