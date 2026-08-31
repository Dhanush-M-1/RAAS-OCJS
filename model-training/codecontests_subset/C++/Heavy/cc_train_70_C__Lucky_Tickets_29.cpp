#include <bits/stdc++.h>
using namespace std;
int rev(int a) {
  int res = 0;
  while (a > 0) {
    res *= 10;
    res += a % 10;
    a /= 10;
  }
  return res;
}
pair<int, int> rev(pair<int, int> a) { return make_pair(a.second, a.first); }
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int A, B, W, M, co[100100], rco[100100], x[200100], y[200100];
pair<int, int> frac[100100];
pair<int, int> check(long long P) {
  memset(x, 0, sizeof(int) * M);
  memset(y, 0, sizeof(int) * M);
  int cur = min(P, (long long)B);
  for (int i = (1); i < (cur + 1); ++i) ++y[rco[i]];
  int lim = min(P, (long long)A);
  long long ile = 0;
  for (int i = (1); i < (lim + 1); ++i) {
    while ((long long)cur * i > P) {
      --y[rco[cur]];
      ile -= x[rco[cur]];
      --cur;
    }
    ++x[co[i]];
    ile += y[co[i]];
    if (ile >= W) return make_pair(i, cur);
  }
  return make_pair(-1, -1);
}
int main(void) {
  scanf("%d%d%d", &A, &B, &W);
  vector<pair<int, int> > all;
  for (int i = (1); i < (max(A, B) + 1); ++i) {
    int d = gcd(i, rev(i));
    frac[i] = make_pair(i / d, rev(i) / d);
    all.push_back(frac[i]);
    all.push_back(rev(frac[i]));
  }
  M = ((int)((all).size()));
  sort((all).begin(), (all).end());
  for (int i = (1); i < (max(A, B) + 1); ++i) {
    co[i] = lower_bound((all).begin(), (all).end(), frac[i]) - all.begin();
    rco[i] =
        lower_bound((all).begin(), (all).end(), rev(frac[i])) - all.begin();
  }
  long long l = 1, r = (long long)A * B, mid;
  pair<int, int> best = make_pair(-1, -1);
  while (l <= r) {
    mid = (l + r) / 2;
    pair<int, int> z = check(mid);
    if (z.first == -1)
      l = mid + 1;
    else {
      best = z;
      r = mid - 1;
    }
  }
  if (best.first == -1)
    puts("-1");
  else
    printf("%d %d\n", best.first, best.second);
  return 0;
}
