#include <bits/stdc++.h>
using namespace std;
template <class T>
using minheap = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
void setmax(T& a, T b) {
  a = max(a, b);
};
template <typename T>
void setmin(T& a, T b) {
  a = min(a, b);
};
template <typename T>
bool in(T v, T lo, T hi) {
  return lo <= v && v <= hi;
};
const int N = 2e5 + 10;
int n;
long long fena[N], fenb[N];
void add(long long* first, int i, long long delta) {
  for (int j = i; j < N; j += j & -j) {
    first[j] += delta;
  }
}
long long sum(long long* first, int i) {
  long long res = 0;
  for (int j = i; j; j -= j & -j) {
    res += first[j];
  }
  return res;
}
struct FastCoordinateCompression {
  vector<int> a;
  void add(int x) { a.push_back(x); }
  void compress() {
    sort(a.begin(), a.end());
    a.resize(unique(a.begin(), a.end()) - a.begin());
  }
  int operator[](int x) {
    return lower_bound(a.begin(), a.end(), x) - a.begin() + 1;
  }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  vector<pair<int, int>> xv(n);
  for (auto& [x, v] : xv) {
    cin >> x;
  }
  for (auto& [x, v] : xv) {
    cin >> v;
  }
  FastCoordinateCompression compr;
  for (auto& [x, v] : xv) {
    compr.add(x);
  }
  compr.compress();
  sort(xv.begin(), xv.end(), [&](pair<int, int>& a, pair<int, int>& b) {
    if (a.second != b.second) return a.second < b.second;
    return a.first < b.first;
  });
  long long ans = 0;
  for (auto& [x, v] : xv) {
    long long num = sum(fena, compr[x]);
    long long tot = sum(fenb, compr[x]);
    ans += x * num - tot;
    add(fena, compr[x], 1);
    add(fenb, compr[x], x);
  }
  cout << ans << '\n';
  return 0;
}
