#include <bits/stdc++.h>
using namespace std;
const int e = 5e5 + 100;
int n, m, a[e], ton1[e], cnt[e], cnx[e], b[e], s[e], mm[e * 2];
int main() {
  cin >> n;
  int maxn = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    ton1[a[i]]++;
    maxn = ((maxn) > (ton1[a[i]]) ? (maxn) : (ton1[a[i]]));
  }
  int pd = 0;
  for (int i = 1; i <= n; i++) {
    if (pd != 0 and ton1[i] == maxn) {
      cout << n;
      return 0;
    }
    if (ton1[i] == maxn) {
      pd = i;
    }
  }
  int k = sqrt(n), ans = 0;
  for (int i = 1, lim = ((k) < (ton1[pd]) ? (k) : (ton1[pd])); i <= lim; i++) {
    int l = 0, r = 0, mxcn = 0;
    memset(cnx, 0, sizeof(cnx));
    memset(cnt, 0, sizeof(cnt));
    cnx[0] = n;
    while (r <= n) {
      for (; cnt[pd] <= i and r <= n;) {
        if (cnx[mxcn] > 1) ans = ((ans) > (r - l) ? (ans) : (r - l));
        r++;
        cnx[cnt[a[r]]]--;
        cnt[a[r]]++;
        mxcn = ((mxcn) > (cnt[a[r]]) ? (mxcn) : (cnt[a[r]]));
        cnx[cnt[a[r]]]++;
      }
      for (; cnt[pd] > i and l <= r;) {
        ++l;
        cnx[cnt[a[l]]]--;
        if (cnt[a[l]] == mxcn and cnx[cnt[a[l]]] == 0) mxcn--;
        cnt[a[l]]--;
        cnx[cnt[a[l]]]++;
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (i == pd) continue;
    if (ton1[i] > k) {
      memset(mm, 0x3f, sizeof(mm));
      mm[e] = 0;
      for (int j = 1; j <= n; j++) {
        if (a[j] == i) {
          b[j] = -1;
        } else if (a[j] == pd) {
          b[j] = 1;
        } else
          b[j] = 0;
        s[j] = s[j - 1] + b[j];
        mm[s[j] + e] = ((mm[s[j] + e]) < (j) ? (mm[s[j] + e]) : (j));
        ans = ((ans) > (j - mm[s[j] + e]) ? (ans) : (j - mm[s[j] + e]));
      }
    }
  }
  cout << ans;
  return 0;
}
