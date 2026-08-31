#include <bits/stdc++.h>
using namespace std;
const int N = 200009;
int g_a[N];
int g_cnt[N];
int g_tmp[N];
int Large(int x, int y, int n) {
  for (int i = 1; i <= n; i++) {
    g_tmp[i] = -1;
  }
  g_tmp[g_cnt[x]] = 0;
  int t = g_cnt[x];
  int ret = 0;
  for (int i = 1; i <= n; i++) {
    if (g_a[i] == x) {
      t--;
    } else if (g_a[i] == y) {
      t++;
    }
    if (g_tmp[t] == -1) {
      g_tmp[t] = i;
    } else {
      ret = max(ret, i - g_tmp[t]);
    }
  }
  return ret;
}
int Small(int x, int n) {
  for (int i = 1; i <= n; i++) {
    g_tmp[i] = 0;
  }
  int num = 0;
  int ret = 0;
  int l = 1;
  for (int i = 1; i <= n; i++) {
    g_tmp[g_a[i]]++;
    if (g_tmp[g_a[i]] == x) {
      num++;
    }
    if (g_tmp[g_a[i]] == x + 1) {
      num--;
    }
    while (g_tmp[g_a[i]] > x && l <= i) {
      if (g_tmp[g_a[l]] == x + 1) {
        num++;
      }
      if (g_tmp[g_a[l]] == x) {
        num--;
      }
      g_tmp[g_a[l]]--;
      l++;
    }
    if (num > 1) {
      ret = max(ret, i - l + 1);
    }
  }
  return ret;
}
int main() {
  int n;
  scanf("%d", &n);
  int maxp = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &g_a[i]);
    g_cnt[g_a[i]]++;
    if (g_cnt[g_a[i]] > g_cnt[maxp]) {
      maxp = g_a[i];
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (maxp != i) {
      if (g_cnt[i] == g_cnt[maxp]) {
        cout << n << endl;
        return 0;
      } else {
        if (g_cnt[i] * g_cnt[i] >= n) {
          ans = max(ans, Large(i, maxp, n));
        }
      }
    }
  }
  for (int i = 1; i * i <= n; i++) {
    ans = max(ans, Small(i, n));
  }
  cout << ans;
  return 0;
}
