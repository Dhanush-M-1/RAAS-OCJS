#include <bits/stdc++.h>
using namespace std;
vector<vector<long long> > mtree, msum, mpos;
void merge_sort(vector<pair<long long, long long> >& arr, long long l,
                long long h, long long id) {
  long long m = (l + h) / 2;
  if (l == h) {
    mtree[id].push_back(arr[l].second);
    msum[id].push_back(arr[l].first);
    mpos[id].push_back(l);
    return;
  }
  merge_sort(arr, l, m, 2 * id);
  merge_sort(arr, m + 1, h, 2 * id + 1);
  long long i = 0, j = 0;
  while (i < mtree[2 * id].size() && j < mtree[2 * id + 1].size()) {
    if (mtree[2 * id][i] < mtree[2 * id + 1][j]) {
      mtree[id].push_back(mtree[2 * id][i]);
      mpos[id].push_back(mpos[2 * id][i]);
      if (!msum[id].empty())
        msum[id].push_back(msum[id].back() + arr[mpos[2 * id][i]].first);
      else
        msum[id].push_back(arr[mpos[2 * id][i]].first);
      i++;
    } else {
      mtree[id].push_back(mtree[2 * id + 1][j]);
      mpos[id].push_back(mpos[2 * id + 1][j]);
      if (!msum[id].empty())
        msum[id].push_back(msum[id].back() + arr[mpos[2 * id + 1][j]].first);
      else
        msum[id].push_back(arr[mpos[2 * id + 1][j]].first);
      j++;
    }
  }
  while (i < mtree[2 * id].size()) {
    mtree[id].push_back(mtree[2 * id][i]);
    mpos[id].push_back(mpos[2 * id][i]);
    if (!msum[id].empty())
      msum[id].push_back(msum[id].back() + arr[mpos[2 * id][i]].first);
    else
      msum[id].push_back(arr[mpos[2 * id][i]].first);
    i++;
  }
  while (j < mtree[2 * id + 1].size()) {
    mtree[id].push_back(mtree[2 * id + 1][j]);
    mpos[id].push_back(mpos[2 * id + 1][j]);
    if (!msum[id].empty())
      msum[id].push_back(msum[id].back() + arr[mpos[2 * id + 1][j]].first);
    else
      msum[id].push_back(arr[mpos[2 * id + 1][j]].first);
    j++;
  }
}
long long solve(long long s, long long e, long long l, long long h,
                long long id, long long x, long long v) {
  long long m = (s + e) / 2;
  if (s == l && e == h) {
    long long p =
        lower_bound(mtree[id].begin(), mtree[id].end(), v) - mtree[id].begin();
    long long a = msum[id].back();
    if (p != 0) a -= msum[id][p - 1];
    return a - x * (mtree[id].size() - p);
  } else if (l > h)
    return 0;
  long long r1 = solve(s, m, l, min(h, m), 2 * id, x, v);
  long long r2 = solve(m + 1, e, max(m + 1, l), h, 2 * id + 1, x, v);
  return r1 + r2;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n;
  cin >> n;
  mtree.resize(4 * n);
  msum.resize(4 * n);
  mpos.resize(4 * n);
  vector<pair<long long, long long> > arr(n);
  for (long long i = 0; i < n; i++) cin >> arr[i].first;
  for (long long i = 0; i < n; i++) cin >> arr[i].second;
  sort(arr.begin(), arr.end());
  merge_sort(arr, 0, n - 1, 1);
  long long ans = 0;
  for (long long i = 0; i < n - 1; i++)
    ans += solve(0, n - 1, i + 1, n - 1, 1, arr[i].first, arr[i].second);
  cout << ans << "\n";
}
