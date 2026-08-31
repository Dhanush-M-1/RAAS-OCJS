#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) { return a == 0 ? b : gcd(b % a, a); }
int rev(int x) {
  int res = 0;
  for (; x; res = res * 10 + x % 10, x /= 10)
    ;
  return res;
}
int ma, mb, w;
map<pair<int, int>, int> id;
int getID(const pair<int, int>& f) {
  if (id.find(f) == id.end()) {
    int sz = id.size();
    id[f] = sz;
  }
  return id[f];
}
int a[100010];
int b[100010];
int aa[110010];
int bb[110010];
bool findans(long long cum, int& x, int& y) {
  memset(aa, 0, sizeof(aa));
  memset(bb, 0, sizeof(bb));
  x = min(cum, (long long)ma);
  y = cum / x;
  long long acc = 0;
  for (int i = 1; i <= x; i++) aa[a[i]]++;
  for (int j = 1; j <= y; j++) {
    bb[b[j]]++;
    acc += aa[b[j]];
  }
  if (acc >= w) return true;
  while (1) {
    if (x == 1) break;
    aa[a[x]]--;
    acc -= bb[a[x]];
    x--;
    long long tary = cum / x;
    if (tary > mb) break;
    while (y < tary) {
      y++;
      bb[b[y]]++;
      acc += aa[b[y]];
    }
    if (acc >= w) return true;
  }
  return false;
}
int main() {
  id.clear();
  scanf("%d%d%d", &ma, &mb, &w);
  for (int i = 1; i <= ma; i++) {
    int k = i;
    int rk = rev(k);
    int d = gcd(k, rk);
    k /= d, rk /= d;
    a[i] = getID(make_pair(k, rk));
  }
  for (int i = 1; i <= mb; i++) {
    int k = i;
    int rk = rev(k);
    int d = gcd(k, rk);
    k /= d, rk /= d;
    b[i] = getID(make_pair(rk, k));
  }
  long long l = 1, r = (long long)ma * mb;
  long long ans = -1;
  while (l <= r) {
    long long mid = (l + r) / 2;
    int x, y;
    if (findans(mid, x, y)) {
      r = mid - 1;
      ans = mid;
    } else
      l = mid + 1;
  }
  if (ans == -1)
    printf("-1\n");
  else {
    int x, y;
    findans(ans, x, y);
    printf("%d %d\n", x, y);
  }
  return 0;
}
