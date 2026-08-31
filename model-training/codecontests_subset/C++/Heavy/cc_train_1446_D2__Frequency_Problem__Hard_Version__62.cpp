#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void prn(Arg1&& arg1) {
  cout << arg1 << "\n";
}
template <typename Arg1, typename... Args>
void prn(Arg1&& arg1, Args&&... args) {
  cout << arg1 << " ";
  prn(args...);
}
template <typename Arg1>
void prs(Arg1&& arg1) {
  cout << arg1 << " ";
}
template <typename Arg1, typename... Args>
void prs(Arg1&& arg1, Args&&... args) {
  cout << arg1 << " ";
  prs(args...);
}
template <typename Arg1>
void read(Arg1&& arg1) {
  cin >> arg1;
}
template <typename Arg1, typename... Args>
void read(Arg1&& arg1, Args&&... args) {
  cin >> arg1;
  read(args...);
}
inline void solve();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  for (int tc = 1; tc <= t; ++tc) {
    solve();
  }
  return 0;
}
const int N = 2e5 + 1;
int n, mx;
int f[N], last[3 * N];
vector<int> pos[N];
vector<int> pref, vec;
int cal(vector<pair<int, int> >& vec) {
  (vec);
  int ans = 0, csum = n;
  vector<int> vals;
  int n1 = vec.size();
  for (int i = 0; i < n1; ++i) {
    csum += vec[i].first;
    if (last[csum] != -1) {
      int r = (i + 1 < n1 ? vec[i + 1].second - 1 : n);
      ans = max(ans, r - last[csum]);
    } else {
      last[csum] = vec[i].second;
      vals.push_back(csum);
    }
  }
  for (auto i : vals) {
    last[i] = -1;
  }
  return ans;
}
inline void solve() {
  memset(last, -1, sizeof last);
  read(n);
  last[n] = 0;
  vec.resize(n + 1);
  for (int i = 1; i <= n; ++i) {
    pos[i].push_back(0);
  }
  for (int i = 1; i <= n; ++i) {
    int& x = vec[i];
    read(x);
    ++f[x];
    pos[x].push_back(i);
  }
  for (int i = 1; i <= n; ++i) {
    if (!mx || f[i] > f[mx]) {
      mx = i;
    }
  }
  pref.resize(n + 1);
  for (int i = 1; i <= n; ++i) {
    pref[i] = pref[i - 1] + (vec[i] == mx);
  }
  pref.push_back(pref.back());
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (i == mx) continue;
    pos[i].push_back(n + 1);
    vector<pair<int, int> > tmp;
    int n1 = pos[i].size();
    int myf = n1 - 1;
    for (int j = 1; j < n1; ++j) {
      int cur = pos[i][j], prev = pos[i][j - 1];
      int bet = pref[cur] - pref[prev];
      if (bet <= 2 * myf) {
        for (auto it = upper_bound(pos[mx].begin(), pos[mx].end(), prev); bet;
             ++it, --bet) {
          tmp.emplace_back(1, *it);
        }
      } else {
        int tak = myf;
        for (auto it = upper_bound(pos[mx].begin(), pos[mx].end(), prev); tak;
             ++it, --tak) {
          tmp.emplace_back(1, *it);
        }
        tak = myf;
        for (int idx = (upper_bound(pos[mx].begin(), pos[mx].end(), cur) -
                        pos[mx].begin()) -
                       myf;
             tak; ++idx, --tak) {
          tmp.emplace_back(1, pos[mx][idx]);
        }
      }
      if (cur <= n) {
        tmp.emplace_back(-1, cur);
      }
    }
    int cur = cal(tmp);
    (i, cur);
    ans = max(ans, cur);
  }
  prn(ans);
}
