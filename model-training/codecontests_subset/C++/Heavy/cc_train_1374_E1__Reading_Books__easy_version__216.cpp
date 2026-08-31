#include <bits/stdc++.h>
using namespace std;
int t[200005], a[200005], b[200005];
pair<int, int> aa[200005], bb[200005], ab[200005];
int sumaa[200005], sumbb[200005], sumab[200005];
int BITcnt[10005], BITsum[10005];
int anss[200005], ccc;
vector<int> v[10005];
bool f[200005];
int lowbit(int x) { return x & (-x); }
void updatecnt(int x, int d) {
  while (x <= 10000) {
    BITcnt[x] += d;
    x += lowbit(x);
  }
}
void updatesum(int x, int d) {
  while (x <= 10000) {
    BITsum[x] += d;
    x += lowbit(x);
  }
}
int querycnt(int x) {
  int ret = 0;
  while (x) {
    ret += BITcnt[x];
    x -= lowbit(x);
  }
  return ret;
}
int querysum(int x) {
  int ret = 0;
  while (x) {
    ret += BITsum[x];
    x -= lowbit(x);
  }
  return ret;
}
bool check(int x, int c) { return querycnt(x) < c; }
int binarysearch(int l, int r, int c) {
  if (l == r)
    return l;
  else if (r - l == 1) {
    if (check(r, c)) return r;
    return l;
  }
  int mid = (l + r) / 2;
  if (check(mid, c))
    return binarysearch(mid, r, c);
  else
    return binarysearch(l, mid - 1, c);
}
int main() {
  int n, m, k, cnta, cntb, cntab, ans, now, p, pp, qq, ansi;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= n; i++) scanf("%d%d%d", &t[i], &a[i], &b[i]);
  cnta = 0;
  cntb = 0;
  cntab = 0;
  for (int i = 1; i <= n; i++)
    if (a[i] && b[i])
      ab[++cntab] = make_pair(t[i], i);
    else if (a[i])
      aa[++cnta] = make_pair(t[i], i);
    else if (b[i])
      bb[++cntb] = make_pair(t[i], i);
  sort(ab + 1, ab + cntab + 1);
  sort(aa + 1, aa + cnta + 1);
  sort(bb + 1, bb + cntb + 1);
  for (int i = 1; i <= cntab; i++) sumab[i] = sumab[i - 1] + ab[i].first;
  for (int i = 1; i <= cnta; i++) sumaa[i] = sumaa[i - 1] + aa[i].first;
  for (int i = 1; i <= cntb; i++) sumbb[i] = sumbb[i - 1] + bb[i].first;
  for (int i = 1; i <= cntab; i++) {
    updatecnt(ab[i].first, 1);
    updatesum(ab[i].first, ab[i].first);
  }
  for (int i = k + 1; i <= cnta; i++) {
    updatecnt(aa[i].first, 1);
    updatesum(aa[i].first, aa[i].first);
  }
  for (int i = k + 1; i <= cntb; i++) {
    updatecnt(bb[i].first, 1);
    updatesum(bb[i].first, bb[i].first);
  }
  for (int i = 1; i <= n; i++)
    if (!a[i] && !b[i]) {
      updatecnt(t[i], 1);
      updatesum(t[i], t[i]);
    }
  ans = 0x7fffffff;
  for (int i = 0; i <= cntab; i++) {
    pp = max(0, k - i);
    qq = max(0, k - i);
    if (cnta < k - i || cntb < k - i) {
      if (i < cntab) {
        updatecnt(ab[i + 1].first, -1);
        updatesum(ab[i + 1].first, -ab[i + 1].first);
      }
      if (pp > 0 && pp <= cnta) {
        updatecnt(aa[pp].first, 1);
        updatesum(aa[pp].first, aa[pp].first);
      }
      if (qq > 0 && qq <= cntb) {
        updatecnt(bb[qq].first, 1);
        updatesum(bb[qq].first, bb[qq].first);
      }
      continue;
    }
    if (i + pp + qq > m) {
      if (i < cntab) {
        updatecnt(ab[i + 1].first, -1);
        updatesum(ab[i + 1].first, -ab[i + 1].first);
      }
      if (pp) {
        updatecnt(aa[pp].first, 1);
        updatesum(aa[pp].first, aa[pp].first);
      }
      if (qq) {
        updatecnt(bb[qq].first, 1);
        updatesum(bb[qq].first, bb[qq].first);
      }
      continue;
    }
    if (i + pp + qq == m) {
      if (sumab[i] + sumaa[pp] + sumbb[qq] < ans) {
        ans = sumab[i] + sumaa[pp] + sumbb[qq];
        ansi = i;
      }
    } else {
      p = binarysearch(0, 10000, m - i - pp - qq);
      if (sumab[i] + sumaa[pp] + sumbb[qq] + querysum(p) +
              (m - i - pp - qq - querycnt(p)) * (p + 1) <
          ans) {
        ans = sumab[i] + sumaa[pp] + sumbb[qq] + querysum(p) +
              (m - i - pp - qq - querycnt(p)) * (p + 1);
        ansi = i;
      }
    }
    if (i < cntab) {
      updatecnt(ab[i + 1].first, -1);
      updatesum(ab[i + 1].first, -ab[i + 1].first);
    }
    if (pp) {
      updatecnt(aa[pp].first, 1);
      updatesum(aa[pp].first, aa[pp].first);
    }
    if (qq) {
      updatecnt(bb[qq].first, 1);
      updatesum(bb[qq].first, bb[qq].first);
    }
  }
  if (ans == 0x7fffffff)
    printf("-1\n");
  else {
    printf("%d\n", ans);
    for (int i = 0; i <= 10000; i++) BITcnt[i] = 0;
    for (int i = 0; i <= 10000; i++) BITsum[i] = 0;
    for (int i = 1; i <= ansi; i++) {
      anss[ccc++] = ab[i].second;
      f[ab[i].second] = true;
    }
    for (int i = 1; i <= k - ansi; i++) {
      anss[ccc++] = aa[i].second;
      f[aa[i].second] = true;
    }
    for (int i = 1; i <= k - ansi; i++) {
      anss[ccc++] = bb[i].second;
      f[bb[i].second] = true;
    }
    for (int i = 1; i <= n; i++)
      if (!f[i]) {
        updatecnt(t[i], 1);
        updatesum(t[i], t[i]);
        v[t[i]].push_back(i);
      }
    if (ccc != m) {
      p = binarysearch(0, 10000, m - ccc);
      int tt = m - ccc - querycnt(p);
      for (int i = 1; i <= p; i++)
        for (int j = 0; j < v[i].size(); j++) anss[ccc++] = v[i][j];
      for (int i = 0; i < tt; i++) anss[ccc++] = v[p + 1][i];
    }
    for (int i = 0; i < ccc; i++)
      if (i != ccc - 1)
        printf("%d ", anss[i]);
      else
        printf("%d\n", anss[i]);
  }
  return 0;
}
