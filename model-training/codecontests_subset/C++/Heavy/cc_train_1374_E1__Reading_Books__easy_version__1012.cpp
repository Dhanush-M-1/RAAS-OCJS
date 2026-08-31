#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e16;
class segTree {
 public:
  vector<long long> t;
  int n;
  segTree(int n) {
    t.resize(n * 2 + 5, 0);
    this->n = n;
  }
  void build() {
    for (int i = n - 1; i > 0; --i) t[i] = t[i << 1] + t[i << 1 | 1];
  }
  void update(int p, long long value) {
    for (t[p += n] += value; p > 1; p >>= 1) t[p >> 1] = t[p] + t[p ^ 1];
  }
  long long query(int l, int r) {
    long long ret = 0;
    r++;
    for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
      if (l & 1) ret += t[l++];
      if (r & 1) ret += t[--r];
    }
    return ret;
  }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<pair<long long, long long>> a, b, c, d;
  for (long long i = 0; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    if (y == 0 && z == 0) {
      d.push_back({x, i});
      continue;
    }
    if (y && z)
      a.push_back({x, i});
    else if (y && !z)
      b.push_back({x, i});
    else
      c.push_back({x, i});
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  sort(d.begin(), d.end());
  vector<long long> sumA(a.size() + 1, 0), sumB(b.size() + 1, 0),
      sumC(c.size() + 1, 0), sumD(d.size() + 1, 0);
  for (long long i = 0; i < a.size(); i++) {
    sumA[i + 1] = sumA[i] + a[i].first;
  }
  for (long long i = 0; i < b.size(); i++) {
    sumB[i + 1] = sumB[i] + b[i].first;
  }
  for (long long i = 0; i < c.size(); i++) {
    sumC[i + 1] = sumC[i] + c[i].first;
  }
  for (long long i = 0; i < d.size(); i++) {
    sumD[i + 1] = sumD[i] + d[i].first;
  }
  vector<unordered_set<long long>> curr(1e4 + 5);
  segTree *T1 = new segTree(1e4 + 5), *T2 = new segTree(1e4 + 5);
  for (long long i = 0; i < d.size(); i++) {
    T1->update(d[i].first, 1);
    T2->update(d[i].first, d[i].first);
    curr[d[i].first].insert(d[i].second);
  }
  for (long long i = 0; i < b.size(); i++) {
    T1->update(b[i].first, 1);
    T2->update(b[i].first, b[i].first);
    curr[b[i].first].insert(b[i].second);
  }
  for (long long i = 0; i < c.size(); i++) {
    T1->update(c[i].first, 1);
    T2->update(c[i].first, c[i].first);
    curr[c[i].first].insert(c[i].second);
  }
  long long ret = INF, pos = -1, pos2 = -1, pos3 = -1;
  long long posA = a.size(), posB = 0, posC = 0;
  for (long long i = k; i >= 0; i--) {
    if (i > a.size()) continue;
    if ((k - i) > min(b.size(), c.size())) continue;
    if (i + 2 * (k - i) > m) continue;
    for (long long j = i; j < posA; j++) {
      T1->update(a[j].first, 1);
      T2->update(a[j].first, a[j].first);
      curr[a[j].first].insert(a[j].second);
    }
    posA = i;
    long long need = m - i - 2 * (k - i);
    for (long long j = posB; j < k - i; j++) {
      T1->update(b[j].first, -1);
      T2->update(b[j].first, -b[j].first);
      curr[b[j].first].erase(b[j].second);
    }
    for (long long j = posB; j < k - i; j++) {
      T1->update(c[j].first, -1);
      T2->update(c[j].first, -c[j].first);
      curr[c[j].first].erase(c[j].second);
    }
    posB = k - i, posC = k - i;
    if (T1->query(0, 1e4) < need) continue;
    long long l = 1, r = 1e4;
    long long minn = 1e4;
    while (l <= r) {
      long long mid = (l + r) / 2;
      if (T1->query(0, mid) >= need) {
        minn = min(minn, mid);
        r = mid - 1;
      } else
        l = mid + 1;
    }
    long long tot = sumA[i] + sumB[k - i] + sumC[k - i];
    long long have = T1->query(0, minn);
    tot += T2->query(0, minn) - (have - need) * minn;
    if (tot < ret) {
      ret = tot;
      pos = i;
    }
  }
  if (pos == -1) cout << -1 << "\n", exit(0);
  cout << ret << "\n";
  for (long long i = 0; i < pos; i++) cout << a[i].second + 1 << " ";
  for (long long i = 0; i < k - pos; i++)
    cout << b[i].second + 1 << " " << c[i].second + 1 << " ";
  T1 = new segTree(1e4 + 5), T2 = new segTree(1e4 + 5);
  curr.assign(1e4 + 5, {});
  for (long long i = 0; i < d.size(); i++) {
    T1->update(d[i].first, 1);
    T2->update(d[i].first, d[i].first);
    curr[d[i].first].insert(d[i].second);
  }
  for (long long i = 0; i < b.size(); i++) {
    T1->update(b[i].first, 1);
    T2->update(b[i].first, b[i].first);
    curr[b[i].first].insert(b[i].second);
  }
  for (long long i = 0; i < c.size(); i++) {
    T1->update(c[i].first, 1);
    T2->update(c[i].first, c[i].first);
    curr[c[i].first].insert(c[i].second);
  }
  posA = a.size(), posB = 0, posC = 0;
  for (long long i = k; i >= 0; i--) {
    if (i > a.size()) continue;
    if ((k - i) > min(b.size(), c.size())) continue;
    if (i + 2 * (k - i) > m) continue;
    for (long long j = i; j < posA; j++) {
      T1->update(a[j].first, 1);
      T2->update(a[j].first, a[j].first);
      curr[a[j].first].insert(a[j].second);
    }
    posA = i;
    long long need = m - i - 2 * (k - i);
    for (long long j = posB; j < k - i; j++) {
      T1->update(b[j].first, -1);
      T2->update(b[j].first, -b[j].first);
      curr[b[j].first].erase(b[j].second);
    }
    for (long long j = posB; j < k - i; j++) {
      T1->update(c[j].first, -1);
      T2->update(c[j].first, -c[j].first);
      curr[c[j].first].erase(c[j].second);
    }
    posB = k - i, posC = k - i;
    if (T1->query(0, 1e4) < need) continue;
    long long l = 1, r = 1e4;
    long long minn = 1e4;
    while (l <= r) {
      long long mid = (l + r) / 2;
      if (T1->query(0, mid) >= need) {
        minn = min(minn, mid);
        r = mid - 1;
      } else
        l = mid + 1;
    }
    if (i == pos) {
      for (long long j = 1; j < minn; j++) {
        for (auto it : curr[j]) cout << it + 1 << " ", need--;
      }
      long long ct = 0;
      for (auto it : curr[minn]) {
        if (ct == need) break;
        cout << it + 1 << " ";
        ct++;
      }
      cout << "\n";
      exit(0);
    }
  }
  return 0;
}
