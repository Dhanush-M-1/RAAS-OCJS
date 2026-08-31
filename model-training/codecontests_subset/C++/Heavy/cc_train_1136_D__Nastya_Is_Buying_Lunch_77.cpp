#include <bits/stdc++.h>
using namespace std;
template <class T>
bool uin(T& a, T b) {
  return a > b ? (a = b, true) : false;
}
template <class T>
bool uax(T& a, T b) {
  return a < b ? (a = b, true) : false;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int N, M;
  cin >> N >> M;
  vector<int> cnt(N + 1);
  vector<int> loc(N + 1);
  vector<int> g[N + 1];
  for (int i = 1; i <= N; ++i) {
    int p;
    cin >> p;
    loc[p] = i;
  }
  for (int i = 1; i <= M; ++i) {
    int a, b;
    cin >> a >> b;
    a = loc[a];
    b = loc[b];
    if (b > a) {
      g[b].push_back(a);
      ++cnt[a];
    }
  }
  int goal = N;
  for (int i = N - 1; i >= 1; --i) {
    if (cnt[i] + i == goal) {
      --goal;
      for (int j : g[i]) --cnt[j];
    }
  }
  cout << N - goal << '\n';
}
