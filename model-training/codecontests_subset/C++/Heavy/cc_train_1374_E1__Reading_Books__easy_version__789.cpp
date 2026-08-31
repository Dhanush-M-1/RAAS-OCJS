#include <bits/stdc++.h>
using namespace std;
int t[200005], a[200005], b[200005];
long long sum1[200005], sum2[200005], sum3[200005], sum4[200005];
int val[200005];
int pos[200005];
vector<pair<int, int> > v1, v2, v3, v4, v5;
struct tree {
  long long ft[200005];
  void update(int i, int v) {
    for (; i <= 200000; i += (i & -i)) ft[i] += v;
  }
  long long query(int i) {
    long long res = 0;
    for (; i > 0; i -= (i & -i)) res += ft[i];
    return res;
  }
} f[2];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  v1.emplace_back(make_pair(0, 0));
  v2.emplace_back(make_pair(0, 0));
  v3.emplace_back(make_pair(0, 0));
  v4.emplace_back(make_pair(0, 0));
  int cnt1 = 0, cnt2 = 0;
  vector<pair<int, int> > h;
  for (int i = 1; i <= n; i++) {
    scanf("%d%d%d", &t[i], &a[i], &b[i]);
    if (a[i] == 1 && b[i] == 1)
      v3.emplace_back(make_pair(t[i], i));
    else if (a[i] == 1)
      v1.emplace_back(make_pair(t[i], i)), h.emplace_back(make_pair(t[i], i));
    else if (b[i] == 1)
      v2.emplace_back(make_pair(t[i], i)), h.emplace_back(make_pair(t[i], i));
    else
      v4.emplace_back(make_pair(t[i], i)), h.emplace_back(make_pair(t[i], i));
    if (a[i] == 1) cnt1++;
    if (b[i] == 1) cnt2++;
  }
  if (cnt1 < k || cnt2 < k)
    printf("-1\n");
  else {
    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());
    sort(v3.begin(), v3.end());
    sort(v4.begin(), v4.end());
    sort(h.begin(), h.end());
    for (int i = 0; i < h.size(); i++) {
      val[h[i].second] = i + 1;
      f[0].update(i + 1, 1);
      f[1].update(i + 1, h[i].first);
    }
    for (int i = 1; i < v1.size(); i++) {
      sum1[i] = sum1[i - 1] + v1[i].first;
    }
    for (int i = 1; i < v2.size(); i++) {
      sum2[i] = sum2[i - 1] + v2[i].first;
    }
    for (int i = 1; i < v3.size(); i++) {
      sum3[i] = sum3[i - 1] + v3[i].first;
    }
    for (int i = 1; i < v4.size(); i++) {
      sum4[i] = sum4[i - 1] + v4[i].first;
    }
    long long ans = 1e18, opt = -1;
    int ca = 1, cb = 1;
    for (int i = (int)v3.size() - 1; i >= 0; i--) {
      int a = k - i, b = k - i;
      if (a < 0) {
        a = 0;
        b = 0;
      }
      if (a >= v1.size() || b >= v2.size()) continue;
      while (ca <= a) {
        int p = val[v1[ca].second];
        f[0].update(p, -1);
        f[1].update(p, -v1[ca].first);
        ca++;
      }
      while (cb <= b) {
        int p = val[v2[cb].second];
        f[0].update(p, -1);
        f[1].update(p, -v2[cb].first);
        cb++;
      }
      long long res = sum3[i];
      res += sum1[a];
      res += sum2[b];
      int l = a + b + i;
      if (l > m) continue;
      int lo = 0, hi = (int)h.size(), p = -1;
      while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (f[0].query(mid) >= m - l)
          p = mid, hi = mid - 1;
        else
          lo = mid + 1;
      }
      if (p == -1) continue;
      res += f[1].query(p);
      if (ans > res) {
        ans = res;
        opt = i;
      }
    }
    vector<int> ans2;
    if (ans == 1e18)
      ans = -1;
    else {
      int i = opt;
      int a = k - i, b = k - i;
      if (a < 0) a = 0, b = 0;
      for (int j = 1; j <= i; j++) ans2.emplace_back(v3[j].second);
      for (int j = 1; j <= a; j++) ans2.emplace_back(v1[j].second);
      for (int j = 1; j <= b; j++) ans2.emplace_back(v2[j].second);
      int c = 1;
      int l = i + a + b;
      a++, b++;
      while (l < m) {
        int mn = 2e9;
        int x = 0;
        if (a < v1.size()) {
          if (mn > v1[a].first) {
            mn = v1[a].first;
            x = 1;
          }
        }
        if (b < v2.size()) {
          if (mn > v2[b].first) {
            mn = v2[b].first;
            x = 2;
          }
        }
        if (c < v4.size()) {
          if (mn > v4[c].first) {
            mn = v4[c].first;
            x = 3;
          }
        }
        if (x == 1) {
          ans2.emplace_back(v1[a].second);
          a++;
        } else if (x == 2) {
          ans2.emplace_back(v2[b].second);
          b++;
        } else {
          ans2.emplace_back(v4[c].second);
          c++;
        }
        l++;
      }
    }
    printf("%lld\n", ans);
    if (ans != -1) {
      for (int i = 0; i < m; i++) printf("%d ", ans2[i]);
      printf("\n");
    }
  }
}
