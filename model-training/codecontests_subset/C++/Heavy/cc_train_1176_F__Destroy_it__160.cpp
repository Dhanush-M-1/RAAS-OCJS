#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int first = 0;
  cerr << '{';
  for (auto &i : x) cerr << (first++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
void test_case() {
  int a;
  cin >> a;
  vector<vector<vector<int>>> in(a, vector<vector<int>>(3));
  for (int i = 0; i < a; i++) {
    int d;
    cin >> d;
    for (int j = 0; j < d; j++) {
      int x, y;
      cin >> x >> y, x--;
      in[i][x].push_back(y);
    }
  }
  for (int i = 0; i < a; i++) {
    for (int j = 0; j < 3; j++) {
      if (in[i][j].empty()) continue;
      sort(in[i][j].rbegin(), in[i][j].rend());
      if (j == 0) {
        while (in[i][j].size() > 3) in[i][j].pop_back();
      } else {
        while (in[i][j].size() > 1) in[i][j].pop_back();
      }
    }
  }
  vector<vector<long long>> dp(a + 1, vector<long long>(10, -1e18));
  dp[0][0] = 0;
  for (int i = 0; i < a; i++) {
    vector<vector<long long>> dp2(4, vector<long long>(2, -1e18));
    dp2[0][0] = 0;
    vector<pair<long long, int>> can;
    for (int j = 0; j < 3; j++) {
      for (auto &x : in[i][j]) {
        can.push_back({x, j + 1});
      }
    }
    sort(can.begin(), can.end());
    do {
      int cards = 0, used = 0;
      long long mx = 0, sum = 0;
      for (int j = 0; j < (int)can.size(); j++) {
        cards++, used += can[j].second, mx = max(mx, can[j].first),
                                        sum += can[j].first;
        if (used > 3) break;
        dp2[cards][0] = max(dp2[cards][0], sum);
        dp2[cards][1] = max(dp2[cards][1], sum + mx);
      }
    } while (next_permutation(can.begin(), can.end()));
    for (int j = 0; j < 10; j++) {
      for (int k = 0; k < 4; k++) {
        int first = j + k >= 10;
        dp[i + 1][(j + k) % 10] =
            max(dp[i + 1][(j + k) % 10], dp[i][j] + dp2[k][first]);
      }
    }
  }
  cout << *max_element(dp[a].begin(), dp[a].end());
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t = 1;
  for (int i = 1; i <= t; i++) {
    test_case();
  }
}
