#include <bits/stdc++.h>
using namespace std;
long long st[100000 + 1][25 + 1];
long long lg[100000 + 1];
long long maxinrange(long long L, long long R) {
  int j = lg[R - L + 1];
  int minimum = max(st[L][j], st[R - (1 << j) + 1][j]);
  return minimum;
}
int main() {
  lg[1] = 0;
  for (int i = 2; i <= 100000; i++) lg[i] = lg[i / 2] + 1;
  long long n, d;
  scanf("%lld %lld", &n, &d);
  long long arr[n + 1];
  for (long long i = 1; i <= n; i++) scanf("%lld", &arr[i]);
  long long csum[n + 1];
  csum[0] = 0;
  for (long long i = 1; i <= n; i++) csum[i] = csum[i - 1] + arr[i];
  for (int i = 1; i <= n; i++) st[i][0] = csum[i];
  for (int j = 1; j <= 25; j++)
    for (int i = 1; i + (1 << j) <= n + 1; i++)
      st[i][j] = max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
  vector<long long> idx;
  for (long long i = 1; i <= n; i++)
    if (csum[i] < 0 && arr[i] == 0) idx.push_back(i);
  if (idx.size() == 0) {
    if (maxinrange(1, n) > d)
      cout << -1;
    else
      cout << 0;
    exit(0);
  }
  vector<long long> maxgaps;
  if (idx[0] == 0)
    maxgaps.push_back(-1000000000000000);
  else
    maxgaps.push_back(maxinrange(0, idx[0] - 1));
  int curr = 1;
  while (curr != (long long)(idx).size()) {
    if (idx[curr] - idx[curr - 1] == 1)
      maxgaps.push_back(-1000000000000000);
    else {
      long long val = maxinrange(idx[curr - 1] + 1, idx[curr - 1] - 1);
      maxgaps.push_back(val);
    }
    curr++;
  }
  if (n == idx[curr - 1])
    maxgaps.push_back(-1000000000000000);
  else
    maxgaps.push_back(maxinrange(idx[curr - 1] + 1, n));
  if (maxgaps[0] > d) {
    cout << -1;
    exit(0);
  }
  long long upd = 0;
  long long minc[(long long)(idx).size()];
  minc[(long long)(idx).size() - 1] = csum[idx[(long long)(idx).size() - 1]];
  for (int i = (long long)(idx).size() - 2; i >= 0; --i)
    minc[i] = min(minc[i + 1], csum[idx[i]]);
  long long minupd[(long long)(maxgaps).size()];
  minupd[(long long)(maxgaps).size() - 1] =
      d - maxgaps[(long long)(maxgaps).size() - 1];
  for (int i = (long long)(maxgaps).size() - 2; i >= 0; i--)
    minupd[i] = min(minupd[i + 1], d - maxgaps[i]);
  curr = 0;
  int ans = 0;
  while (curr != (long long)(idx).size()) {
    if (csum[idx[curr]] + upd >= 0) {
      curr++;
      continue;
    }
    long long maxupdate = 0;
    maxupdate = minc[curr] + upd;
    maxupdate = -maxupdate;
    long long lowestgap = 1000000000000000;
    lowestgap = minupd[curr + 1] - upd;
    maxupdate = min(maxupdate, lowestgap);
    if (csum[idx[curr]] + upd + maxupdate < 0) {
      cout << -1;
      exit(0);
    }
    upd += maxupdate;
    curr++;
    ans++;
  }
  cout << ans;
  return 0;
}
