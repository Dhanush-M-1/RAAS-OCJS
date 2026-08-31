#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e4 + 9;
int tree[(MAX << 2)][2], val, idx;
void upd(int low, int high, int pos) {
  if (low == high) {
    tree[pos][1] += val;
    tree[pos][0] += val * low;
    return;
  }
  int mid = ((low + high) >> 1);
  idx <= mid ? upd(low, mid, (pos << 1)) : upd(mid + 1, high, (pos << 1 | 1));
  tree[pos][0] = tree[(pos << 1)][0] + tree[(pos << 1 | 1)][0];
  tree[pos][1] = tree[(pos << 1)][1] + tree[(pos << 1 | 1)][1];
}
int qwr(int low, int high, int pos, int rest) {
  if (tree[pos][1] == rest) return tree[pos][0];
  if (low == high) return rest * low;
  int mid = ((low + high) >> 1);
  if (tree[(pos << 1)][1] >= rest) {
    return qwr(low, mid, (pos << 1), rest);
  } else {
    return tree[(pos << 1)][0] +
           qwr(mid + 1, high, (pos << 1 | 1), rest - tree[(pos << 1)][1]);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m, k;
  cin >> n >> m >> k;
  vector<pair<int, int> > a, b;
  vector<pair<pair<int, int>, long long> > both;
  vector<pair<int, int> > non;
  for (int i = 1; i <= n; ++i) {
    int t, x, y;
    cin >> t >> x >> y;
    if (x && !y) {
      val = 1, idx = t;
      upd(1, MAX - 1, 1);
      a.push_back({t, i});
    } else if (!x && y) {
      val = 1, idx = t;
      upd(1, MAX - 1, 1);
      b.push_back({t, i});
    } else if (x && y) {
      both.push_back({{t, i}, t});
    } else {
      non.push_back({t, i});
      val = 1, idx = t;
      upd(1, MAX - 1, 1);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(both.begin(), both.end());
  vector<pair<pair<int, int>, long long> > tempBoth = both;
  while (both.size() > k) {
    val = 1, idx = both.back().first.first;
    both.pop_back();
    upd(1, MAX - 1, 1);
  }
  for (int i = 1; i < both.size(); ++i) {
    both[i].second += both[i - 1].second;
  }
  long long ans = 1e18 + 18, totA = 0, totB = 0;
  int cnt = 0;
  bool findAnswer = 0;
  for (int i = 0; i <= min(k, (int)min(a.size(), b.size())); ++i) {
    if (i) {
      val = -1, idx = a[i - 1].first;
      upd(1, MAX - 1, 1);
      totA += a[i - 1].first;
      val = -1, idx = b[i - 1].first;
      upd(1, MAX - 1, 1);
      totB += b[i - 1].first;
    }
    int needK = k - i;
    int rest = m - i * 2 - needK;
    if (needK > both.size() || rest < 0 || tree[1][1] < rest) {
      continue;
    }
    findAnswer = 1;
    long long sol = totA + totB + (needK > 0 ? both[needK - 1].second : 0) +
                    (rest ? qwr(1, MAX - 1, 1, rest) : 0);
    if (sol < ans) {
      ans = sol;
      cnt = i;
    }
    if (!both.empty()) {
      val = -1, idx = both.back().first.first;
      both.pop_back();
      upd(1, MAX - 1, 1);
    }
  }
  if (!findAnswer) {
    cout << -1;
    return 0;
  }
  cout << ans << "\n";
  for (int i = 0; i < cnt; ++i) {
    cout << a[i].second << " " << b[i].second << " ";
  }
  int needK = k - cnt;
  for (int i = 0; i < needK; ++i) {
    cout << tempBoth[i].first.second << " ";
  }
  set<pair<int, int> > s;
  for (int i = cnt; i < a.size(); ++i) s.insert(a[i]);
  for (int i = cnt; i < b.size(); ++i) s.insert(b[i]);
  for (int i = needK; i < tempBoth.size(); ++i) s.insert(tempBoth[i].first);
  for (int i = 0; i < non.size(); ++i) s.insert(non[i]);
  int rest = m - 2 * cnt - needK;
  while (rest--) {
    cout << s.begin()->second << " ";
    s.erase(s.begin());
  }
  return 0;
}
