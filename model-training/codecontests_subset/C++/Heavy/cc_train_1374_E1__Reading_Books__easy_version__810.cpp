#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1000000007;
const long long int inf = 0x3f3f3f3f3f3f3f3fLL;
long long int i, j, k;
void solve(void);
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(10);
  int t = 1;
  while (t--) solve();
  return 0;
}
void solve() {
  long long int n, m, k;
  cin >> n >> m >> k;
  vector<long long int> a, b, both, c;
  map<long long int, vector<int> > ma, mb, mboth, mc;
  for (i = (1); i <= (n); ++i) {
    long long int t, x, y;
    cin >> t >> x >> y;
    if (x == 1 && y == 1)
      both.emplace_back(t), mboth[t].emplace_back(i);
    else if (x == 1)
      a.emplace_back(t), ma[t].emplace_back(i);
    else if (y == 1)
      b.emplace_back(t), mb[t].emplace_back(i);
    else
      c.emplace_back(t), mc[t].emplace_back(i);
  }
  int sizboth = (long long)both.size(), siza = (long long)a.size(),
      sizb = (long long)b.size(), sizc = (long long)c.size();
  both.emplace_back(0);
  a.emplace_back(0);
  b.emplace_back(0);
  c.emplace_back(0);
  sort(both.begin(), both.end());
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  vector<long long int> pboth, pa, emplace_back, pc;
  pboth.emplace_back(0);
  pa.emplace_back(0);
  emplace_back.emplace_back(0);
  pc.emplace_back(0);
  for (i = (1); i <= ((long long)both.size() - 1); ++i)
    pboth.emplace_back(both[i] + pboth.back());
  for (i = (1); i <= ((long long)a.size() - 1); ++i)
    pa.emplace_back(a[i] + pa.back());
  for (i = (1); i <= ((long long)b.size() - 1); ++i)
    emplace_back.emplace_back(b[i] + emplace_back.back());
  for (i = (1); i <= ((long long)c.size() - 1); ++i)
    pc.emplace_back(c[i] + pc.back());
  {};
  {};
  {};
  {};
  long long int min = inf, X = -1, Y = -1, Z = -1, W = -1, U = -1;
  int idx1 = -1, idx2 = -1, idx3 = -1;
  for (i = (0); i <= (m); ++i)
    if (i <= k) {
      if (i > sizboth) continue;
      if (k - i > siza || k - i > sizb) continue;
      int val = m - (2 * k - i);
      if (val > siza + sizb + sizc - 2 * (k - i) || val < 0) continue;
      long long int sum = pboth[i] + pa[k - i] + emplace_back[k - i];
      long long int lo = 0, hi = inf, mid, ans = -1;
      while (lo <= hi) {
        mid = (lo + hi) >> 1;
        int id1 = upper_bound(a.begin(), a.end(), mid) - a.begin() - 1;
        int id2 = upper_bound(b.begin(), b.end(), mid) - b.begin() - 1;
        int id3 = upper_bound(c.begin(), c.end(), mid) - c.begin() - 1;
        int x = ((0) > (id1 - (k - i)) ? (0) : (id1 - (k - i)));
        int y = ((0) > (id2 - (k - i)) ? (0) : (id2 - (k - i)));
        int z = ((0) > (id3) ? (0) : (id3));
        if (x + y + z >= val) {
          ans = mid;
          hi = mid - 1;
        } else
          lo = mid + 1;
      }
      if (ans == -1) continue;
      int id1 = lower_bound(a.begin(), a.end(), ans) - a.begin() - 1;
      int id2 = lower_bound(b.begin(), b.end(), ans) - b.begin() - 1;
      int id3 = lower_bound(c.begin(), c.end(), ans) - c.begin() - 1;
      int x = ((0) > (id1 - (k - i)) ? (0) : (id1 - (k - i)));
      int y = ((0) > (id2 - (k - i)) ? (0) : (id2 - (k - i)));
      int z = ((0) > (id3) ? (0) : (id3));
      val -= (x + y + z);
      sum += pa[k - i + x] - pa[k - i];
      sum += emplace_back[k - i + y] - emplace_back[k - i];
      sum += pc[z];
      sum += (val * ans);
      if (min > sum) {
        min = sum;
        {};
        X = i, Y = k - i + x, Z = k - i + y, W = z, U = ans;
      }
    } else {
      if (i > sizboth) continue;
      long long int sum = pboth[i];
      long long int val = m - i;
      if (siza + sizb + sizc < val) continue;
      long long int lo = 0, hi = inf, mid, ans = -1;
      while (lo <= hi) {
        mid = (lo + hi) >> 1;
        int id1 = upper_bound(a.begin(), a.end(), mid) - a.begin() - 1;
        int id2 = upper_bound(b.begin(), b.end(), mid) - b.begin() - 1;
        int id3 = upper_bound(c.begin(), c.end(), mid) - c.begin() - 1;
        if (id1 + id2 + id3 >= val) {
          ans = mid;
          hi = mid - 1;
        } else
          lo = mid + 1;
      }
      if (ans == -1) continue;
      int id1 = lower_bound(a.begin(), a.end(), ans) - a.begin() - 1;
      int id2 = lower_bound(b.begin(), b.end(), ans) - b.begin() - 1;
      int id3 = lower_bound(c.begin(), c.end(), ans) - c.begin() - 1;
      int x = ((0) > (id1) ? (0) : (id1)), y = ((0) > (id2) ? (0) : (id2)),
          z = ((0) > (id3) ? (0) : (id3));
      sum += pa[x] + emplace_back[y] + pc[z];
      val -= (x + y + z);
      sum += val * ans;
      if (min > sum) {
        min = sum;
        {};
        X = i, Y = x, Z = y, W = z, U = ans;
      }
    }
  if (min == inf) {
    cout << "-1\n";
    return;
  }
  cout << min << '\n';
  vector<int> index;
  for (i = (1); i <= (X); ++i) {
    int id = mboth[both[i]].back();
    mboth[both[i]].pop_back();
    index.emplace_back(id);
  }
  for (i = (1); i <= (Y); ++i) {
    int id = ma[a[i]].back();
    ma[a[i]].pop_back();
    index.emplace_back(id);
  }
  for (i = (1); i <= (Z); ++i) {
    int id = mb[b[i]].back();
    mb[b[i]].pop_back();
    index.emplace_back(id);
  }
  for (i = (1); i <= (W); ++i) {
    int id = mc[c[i]].back();
    mc[c[i]].pop_back();
    index.emplace_back(id);
  }
  m -= X + Y + Z + W;
  while (m > 0 && (long long)mboth[U].size() > 0) {
    int id = mboth[U].back();
    mboth[U].pop_back();
    index.emplace_back(id);
    m--;
  }
  while (m > 0 && (long long)ma[U].size() > 0) {
    int id = ma[U].back();
    ma[U].pop_back();
    index.emplace_back(id);
    m--;
  }
  while (m > 0 && (long long)mb[U].size() > 0) {
    int id = mb[U].back();
    mb[U].pop_back();
    index.emplace_back(id);
    m--;
  }
  while (m > 0 && (long long)mc[U].size() > 0) {
    int id = mc[U].back();
    mc[U].pop_back();
    index.emplace_back(id);
    m--;
  }
  for (auto it : index) cout << it << " ";
  cout << '\n';
}
