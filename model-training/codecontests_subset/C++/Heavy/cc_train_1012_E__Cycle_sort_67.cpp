#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, neg = 1;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') neg = -1;
    c = getchar();
  }
  while (isdigit(c)) x = x * 10 + c - '0', c = getchar();
  return x * neg;
}
inline int qpow(int x, int e, int _MOD) {
  int ans = 1;
  while (e) {
    if (e & 1) ans = ans * x % _MOD;
    x = x * x % _MOD;
    e >>= 1;
  }
  return ans;
}
int n = read(), s = read(), a[200005], b[200005], c[200005], d[200005], num = 0;
vector<int> g[200005], cyc[200005];
int k = 0;
inline void dfs(int x) {
  while (!g[x].empty()) {
    int y = g[x].back();
    g[x].pop_back();
    dfs(a[y]);
    cyc[k].push_back(y);
  }
}
signed main() {
  for (int i = 1; i <= n; i++) a[i] = read(), c[i] = a[i];
  sort(c + 1, c + n + 1);
  for (int i = 1; i <= n; i++)
    if (c[i] != c[i - 1]) d[++num] = c[i];
  for (int i = 1; i <= n; i++)
    a[i] = lower_bound(d + 1, d + num + 1, a[i]) - d, b[i] = a[i];
  sort(b + 1, b + n + 1);
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] != b[i]) {
      cnt++;
      g[b[i]].push_back(i);
    }
  }
  if (!cnt) return puts("0"), 0;
  if (cnt > s) return puts("-1"), 0;
  for (int i = 1; i <= num; i++) {
    if (!g[i].empty()) {
      k++;
      dfs(i);
    }
  }
  for (int i = 1; i <= k; i++) reverse(cyc[i].begin(), cyc[i].end());
  if (k == 1) {
    cout << 1 << endl << cyc[1].size() << endl;
    for (__typeof(cyc[1].begin()) it = cyc[1].begin(); it != cyc[1].end(); it++)
      cout << *it << " ";
    return 0;
  }
  if (cnt <= s - k) {
    cout << 2 << endl;
    cout << cnt << endl;
    for (int i = 1; i <= k; i++) {
      for (__typeof(cyc[i].begin()) it = cyc[i].begin(); it != cyc[i].end();
           it++)
        cout << *it << " ";
    }
    puts("");
    cout << k << endl;
    for (int i = k; i >= 1; i--) cout << cyc[i][0] << " ";
    puts("");
    return 0;
  } else {
    int t = cnt - (s - k);
    if (t == k)
      cout << t << endl;
    else if (t == k - 1)
      cout << t + 1 << endl;
    else
      cout << t + 2 << endl;
    for (int i = 1; i <= t; i++) {
      cout << cyc[i].size() << endl;
      for (__typeof(cyc[i].begin()) it = cyc[i].begin(); it != cyc[i].end();
           it++)
        cout << *it << " ";
      puts("");
    }
    int sum = 0;
    if (t != k) {
      for (int i = t + 1; i <= k; i++) sum += cyc[i].size();
      cout << sum << endl;
      for (int i = t + 1; i <= k; i++)
        for (__typeof(cyc[i].begin()) it = cyc[i].begin(); it != cyc[i].end();
             it++)
          cout << *it << " ";
      if (t != k - 1) {
        puts("");
        cout << k - t << endl;
        for (int i = k; i >= t + 1; i--) cout << cyc[i][0] << " ";
      }
    }
  }
  return 0;
}
