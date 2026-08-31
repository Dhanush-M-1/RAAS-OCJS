#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("Ofast")
#pragma GCC target("avx")
bool RELAXED = false;
template <int, typename T>
struct MINMAX {
  T val;
  MINMAX(T val) : val(val) {}
};
template <typename T>
MINMAX<1, T> MAX(T val) {
  return MINMAX<1, T>(val);
};
template <typename T>
MINMAX<2, T> MIN(T val) {
  return MINMAX<2, T>(val);
};
template <typename T, typename U>
inline T& operator|=(T& lhs, MINMAX<1, U> rhs) {
  return lhs = (rhs.val > lhs ? (RELAXED = true, rhs.val)
                              : (RELAXED = false, lhs));
}
template <typename T, typename U>
inline T& operator|=(T& lhs, MINMAX<2, U> rhs) {
  return lhs = (rhs.val < lhs ? (RELAXED = true, rhs.val)
                              : (RELAXED = false, lhs));
}
template <typename T, typename U>
istream& operator>>(istream& in, pair<T, U>& p) {
  in >> p.first >> p.second;
  return in;
}
template <typename T>
inline vector<T> READ(int n) {
  vector<T> vec(n);
  for (int i = 0; i < int(n); i++) cin >> vec[i];
  return vec;
}
template <typename T>
using min_heap = priority_queue<T, vector<T>, greater<T> >;
const int MAXN = 1e5 + 5;
signed long long int dp[MAXN][80];
signed long long int bt[MAXN][80];
vector<pair<int, int> > minion;
int n, k;
map<pair<int, int>, vector<int> > ids;
int get_id(pair<int, int> minion) {
  int id = ids[minion].back();
  ids[minion].pop_back();
  return id;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout << fixed << setprecision(12);
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> k;
    minion.clear();
    minion.resize(n);
    memset(dp, 0x80, sizeof dp);
    memset(bt, 0, sizeof bt);
    ids.clear();
    for (int i = 0; i < int(n); i++) {
      int a, b;
      cin >> a >> b;
      minion[i] = {a, b};
      ids[{a, b}].push_back(i + 1);
    }
    sort((minion).begin(), (minion).end(),
         [&](pair<int, int> a, pair<int, int> b) {
           return a.second < b.second;
         });
    42;
    dp[0][0] = 0;
    for (int i = 0; i < int(n); i++) {
      for (int j = 0; j < int(k + 1); j++) {
        dp[i + 1][j] = dp[i][j] + (k - 1) * minion[i].second;
        bt[i + 1][j] = false;
      }
      for (int j = 0; j < int(k); j++) {
        dp[i + 1][j + 1] |=
            MAX(dp[i][j] + minion[i].first + j * minion[i].second);
        if (RELAXED) bt[i + 1][j + 1] = true;
      }
    }
    vector<int> keep;
    int lk = k;
    for (int i = int(n); i >= int(0); --i) {
      if (bt[i][lk]) {
        keep.push_back(i - 1);
        lk--;
      }
      if (lk < 0) break;
    }
    reverse((keep).begin(), (keep).end());
    vector<int> actions;
    for (int i = 0; i < int(k - 1); i++) {
      pair<int, int> mi = minion[keep[i]];
      actions.push_back(get_id(mi));
    }
    for (int i = 0; i < int(n); i++) {
      pair<int, int> mi = minion[i];
      if (count((keep).begin(), (keep).end(), i)) continue;
      int id = get_id(mi);
      actions.push_back(id);
      actions.push_back(-id);
    }
    {
      pair<int, int> mi = minion[keep.back()];
      actions.push_back(get_id(mi));
    }
    42;
    cout << actions.size() << endl;
    for (auto x : actions) cout << x << ' ';
    cout << endl;
  }
}
