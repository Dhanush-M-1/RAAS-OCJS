#include <bits/stdc++.h>
using namespace std;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};
int dddx[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dddy[] = {0, 0, 1, -1, 1, -1, 1, -1};
struct FenwickTree {
  vector<long long int> bit;
  int n;
  FenwickTree(int n) {
    this->n = n;
    bit.assign(n, 0);
  }
  long long int sum(int r) {
    long long int ret = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) ret += bit[r];
    return ret;
  }
  long long int sum(int l, int r) { return sum(r) - sum(l - 1); }
  void add(int idx, int delta) {
    for (; idx < n; idx = idx | (idx + 1)) bit[idx] += delta;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<pair<int, int> > vec(n + 1);
  vector<int> aux;
  vec.resize(n);
  for (int i = 0; i < n; i++) cin >> vec[i].first;
  for (int i = 0; i < n; i++) cin >> vec[i].second;
  sort(vec.begin(), vec.end());
  FenwickTree cnt(n), soma(n);
  for (auto i : vec) aux.push_back(i.second);
  sort(aux.begin(), aux.end());
  long long int ans = 0;
  for (auto i : vec) {
    int pos = lower_bound(aux.begin(), aux.end(), i.second) - aux.begin();
    ans += (cnt.sum(pos) * i.first) - soma.sum(pos);
    cnt.add(pos, 1);
    soma.add(pos, i.first);
  }
  cout << ans << "\n";
  return 0;
}
