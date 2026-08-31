#include <bits/stdc++.h>
using namespace std;
using namespace std;
long long st[800001], st2[800001];
vector<long long> vx[200001], idxs[200001];
long long getMid(long long s, long long e) { return s + (e - s) / 2; }
long long SumUtil(long long* st, long long ss, long long se, long long l,
                  long long r, long long node) {
  if (l <= ss && r >= se) return st[node];
  if (se < l || ss > r) return 0ll;
  long long mid = getMid(ss, se);
  return SumUtil(st, ss, mid, l, r, 2 * node + 1) +
         SumUtil(st, mid + 1, se, l, r, 2 * node + 2);
}
void updateValue(long long* st, long long ss, long long se, long long index,
                 long long value, long long node) {
  if (ss == se) {
    st[node] += value;
  } else {
    long long mid = getMid(ss, se);
    if (index >= ss && index <= mid)
      updateValue(st, ss, mid, index, value, 2 * node + 1);
    else
      updateValue(st, mid + 1, se, index, value, 2 * node + 2);
    st[node] = st[2 * node + 1] + st[2 * node + 2];
  }
  return;
}
long long getSum(long long* st, long long n, long long l, long long r) {
  if (l < 0 || r > n - 1 || l > r) {
    return 0;
  }
  return SumUtil(st, 0, n - 1, l, r, 0);
}
void solve() {
  set<long long> stt;
  stt.clear();
  long long n, i, j, k, x[200001], v[200001];
  for (i = 0; i < 800001; i++) st[i] = st2[i] = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x[i];
  }
  for (i = 0; i < n; i++) {
    cin >> v[i];
    stt.insert(v[i]);
  }
  vector<long long> temp_vec;
  temp_vec.clear();
  for (auto xx : stt) temp_vec.push_back(xx);
  long long velos = temp_vec.size();
  for (i = 0; i < velos; i++) {
    vx[i].clear();
    idxs[i].clear();
  }
  for (i = 0; i < n; i++) {
    long long sta = 0, ed = velos - 1, md;
    while (sta <= ed) {
      md = sta + (ed - sta) / 2;
      if (temp_vec[md] == v[i]) break;
      if (temp_vec[md] < v[i])
        sta = md + 1;
      else
        ed = md - 1;
    }
    vx[md].push_back(x[i]);
  }
  for (i = 0; i < velos; i++) sort(vx[i].begin(), vx[i].end());
  vector<pair<long long, long long> > temp_vec_2;
  temp_vec_2.clear();
  for (i = 0; i < velos; i++) {
    for (auto xx : vx[i]) {
      temp_vec_2.push_back({xx, i});
    }
  }
  sort(temp_vec_2.begin(), temp_vec_2.end());
  i = 0;
  for (auto xx : temp_vec_2) {
    idxs[xx.second].push_back(i);
    i++;
  }
  long long ans = 0;
  for (i = 0; i < velos; i++) {
    for (auto xx : vx[i]) {
      long long sta = 0, ed = temp_vec_2.size(), md;
      ed--;
      while (sta <= ed) {
        md = ed + (sta - ed) / 2;
        if (temp_vec_2[md].first == xx) break;
        if (temp_vec_2[md].first < xx)
          sta = md + 1;
        else
          ed = md - 1;
      }
      ans += (getSum(st2, n, 0, md)) * xx - getSum(st, n, 0, md);
    }
    for (auto xx : idxs[i]) {
      updateValue(st, 0, n - 1, xx, temp_vec_2[xx].first, 0);
      updateValue(st2, 0, n - 1, xx, 1, 0);
    }
  }
  for (i = 0; i < velos; i++) {
    long long p = 0, m = vx[i].size();
    m--;
    for (auto xx : vx[i]) {
      ans += (p - m) * xx;
      p++;
      m--;
    }
  }
  cout << ans << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) solve();
}
