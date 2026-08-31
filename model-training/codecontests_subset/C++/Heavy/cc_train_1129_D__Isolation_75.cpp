#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int a[100010], dp[100010];
pair<int, int> b[100010];
vector<int> lst_ind[100010];
int ind[100010];
vector<pair<int, int> > cnt[400];
int acc[400];
int opm[400];
int p = 998244353;
int getBlock(int x) { return x / m; }
int getIndexInBlock(int x) { return x % m; }
void bruteForceUpdate(int bl) {
  int st = bl * m;
  int ed = min(n - 1, (bl + 1) * m - 1);
  int getMin = 1e9 + 1, getMax = -1e9 - 1;
  for (int i = st; i <= ed; i++) {
    b[i].first += acc[bl];
    getMin = min(b[i].first, getMin);
    getMax = max(b[i].first, getMax);
  }
  acc[bl] = 0;
  cnt[bl].clear();
  for (int i = 0; i < getMax - getMin + 1; i++)
    cnt[bl].push_back(pair<int, int>(getMin + i, 0));
  for (int i = st; i <= ed; i++) {
    cnt[bl][b[i].first - getMin].second += b[i].second;
    cnt[bl][b[i].first - getMin].second %= p;
  }
  for (int i = 1; i < cnt[bl].size(); i++) {
    cnt[bl][i].second += cnt[bl][i - 1].second;
    cnt[bl][i].second %= p;
  }
  opm[bl] = -1;
  for (int i = 0; i < cnt[bl].size(); i++) {
    if (cnt[bl][i].first <= k) {
      opm[bl] = i;
    }
  }
}
void update(int l, int r, int v) {
  int l_id = getBlock(l);
  int r_id = getBlock(r);
  for (int i = l_id + 1; i <= r_id - 1; i++) {
    acc[i] += v;
    if (opm[i] >= 0 && cnt[i][opm[i]].first + acc[i] > k) opm[i]--;
    if (opm[i] + 1 < cnt[i].size() && cnt[i][opm[i] + 1].first + acc[i] <= k)
      opm[i]++;
  }
  for (int i = l; i <= min(r, (l_id + 1) * m - 1); i++) {
    b[i].first += v;
  }
  bruteForceUpdate(l_id);
  if (l_id != r_id) {
    for (int i = r_id * m; i <= r; i++) {
      b[i].first += v;
    }
    bruteForceUpdate(r_id);
  }
}
int getAns(int l, int r) {
  int ans = 0;
  int l_id = getBlock(l);
  int r_id = getBlock(r);
  for (int i = l_id + 1; i <= r_id - 1; i++) {
    int indx = opm[i];
    if (indx < 0) continue;
    ans = (ans + cnt[i][indx].second) % p;
  }
  for (int i = l; i <= min(r, (l_id + 1) * m - 1); i++) {
    if (b[i].first + acc[l_id] <= k) ans = (ans + b[i].second) % p;
  }
  if (l_id != r_id) {
    for (int i = r_id * m; i <= r; i++) {
      if (b[i].first + acc[r_id] <= k) ans = (ans + b[i].second) % p;
    }
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    lst_ind[a[i]].push_back(i);
    ind[i] = lst_ind[a[i]].size() - 1;
  }
  m = sqrt(n);
  b[0].second = 1;
  for (int i = 0; i < n; i++) {
    int val = a[i];
    int id = ind[i];
    if (id == 0) {
      update(0, i, 1);
    }
    if (id > 0) {
      int preID = lst_ind[val][id - 1];
      update(preID + 1, i, 1);
      if (id > 1) {
        int preID2 = lst_ind[val][id - 2];
        update(preID2 + 1, preID, -1);
      } else {
        update(0, preID, -1);
      }
    }
    dp[i] = getAns(0, i);
    b[i + 1].second = dp[i];
  }
  cout << dp[n - 1] << "\n";
}
