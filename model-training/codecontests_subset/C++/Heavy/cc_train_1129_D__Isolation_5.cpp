#include <bits/stdc++.h>
using namespace std;
struct bucket {
  int sz, szq, ptr, lz;
  pair<int, int> u[250 + 5];
  pair<int, int> el[250 + 5];
} B[100005 / 250 + 5];
int n, k, tot;
int a[100005], dp[100005], lnk[100005];
int add(int x, int y) {
  x += y;
  if (x >= 998244353) x -= 998244353;
  if (x < 0) x += 998244353;
  return x;
}
void lzit(int l, int r, int sg) {
  for (int i = l; i <= r; i++) {
    pair<int, int>* u = B[i].u;
    int& szq = B[i].szq;
    int& ptr = B[i].ptr;
    int& lz = B[i].lz;
    lz += sg;
    if (sg == 1) {
      while (ptr && u[ptr].first + lz > k) {
        tot = add(tot, -u[ptr--].second);
      }
    } else {
      while (ptr < szq && u[ptr + 1].first + lz <= k) {
        tot = add(tot, u[++ptr].second);
      }
    }
  }
}
void pure(int buc, int l, int r, int sg) {
  vector<pair<int, int> > a, b;
  pair<int, int>* el = B[buc].el;
  pair<int, int>* u = B[buc].u;
  int& sz = B[buc].sz;
  int& szq = B[buc].szq;
  int& ptr = B[buc].ptr;
  int& lz = B[buc].lz;
  for (int i = 1; i <= sz; i++) {
    if (el[i].second >= l && el[i].second <= r)
      b.push_back(el[i]);
    else
      a.push_back(el[i]);
  }
  for (int i = 1; i <= ptr; i++) {
    tot = add(tot, -u[i].second);
  }
  ptr = 0;
  for (pair<int, int>& x : b) x.first += sg;
  int ca = 0, cb = 0;
  sz = szq = 0;
  while (ca < ((int)a.size()) || cb < ((int)b.size())) {
    if (cb == ((int)b.size()) ||
        (ca != ((int)a.size()) && a[ca].first < b[cb].first)) {
      el[++sz] = a[ca++];
    } else {
      el[++sz] = b[cb++];
    }
  }
  for (int i = 1; i <= sz; i++) {
    int sum = 0;
    while (i + 1 <= sz && el[i].first == el[i + 1].first) {
      sum = add(sum, dp[el[i++].second - 1]);
    }
    sum = add(sum, dp[el[i].second - 1]);
    u[++szq] = {el[i].first, sum};
    if (el[i].first + lz <= k) ptr = szq, tot = add(tot, sum);
  }
}
void chng(int l, int r, int sg) {
  int bl = (l + 250 - 1) / 250;
  int br = (r + 250 - 1) / 250;
  if (bl == br)
    pure(bl, l, r, sg);
  else {
    pure(bl, l, bl * 250, sg);
    pure(br, (br - 1) * 250 + 1, r, sg);
    lzit(bl + 1, br - 1, sg);
  }
}
int main(int argc, char* argv[]) {
  for (int i = 1; i < 100005 / 250 + 5; i++) B[i].sz = B[i].ptr = B[i].lz;
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
  }
  map<int, int> prv;
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    int pr = prv[a[i]];
    if (pr) chng(lnk[pr] + 1, pr, -1);
    chng(pr + 1, i, 1);
    lnk[i] = pr;
    prv[a[i]] = i;
    B[(i + 250 - 1) / 250].el[++B[(i + 250 - 1) / 250].sz] = {0, i};
    chng(i, i, 1);
    dp[i] = tot;
  }
  printf("%d", dp[n]);
}
