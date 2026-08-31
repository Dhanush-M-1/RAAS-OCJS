#include <bits/stdc++.h>
using namespace std;
using namespace rel_ops;
using ll = int64_t;
using Pii = pair<int, int>;
using ull = uint64_t;
using Vi = vector<int>;
void run();
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout << fixed << setprecision(10);
  run();
  return 0;
}
vector<vector<Pii>> G;
vector<Vi> cycles;
void dfs(int v) {
  while (!G[v].empty()) {
    Pii e = G[v].back();
    G[v].pop_back();
    dfs(e.first);
    cycles.back().push_back(e.second);
  }
}
void run() {
  int n, upper;
  cin >> n >> upper;
  Vi elems(n);
  for (auto& e : (elems)) cin >> e;
  Vi sorted(n);
  iota((sorted).begin(), (sorted).end(), 0);
  sort((sorted).begin(), (sorted).end(),
       [&](int l, int r) { return elems[l] < elems[r]; });
  int last = elems[sorted[0]], k = 0;
  for (int i = (0); i < (n); i++) {
    int e = sorted[i];
    if (elems[e] != last) k++;
    last = elems[e];
    elems[e] = k;
  }
  k++;
  G.resize(k);
  for (int i = (0); i < (n); i++)
    if (elems[i] != elems[sorted[i]]) {
      G[elems[i]].push_back({elems[sorted[i]], i});
    }
  int len = 0;
  for (int i = (0); i < (k); i++)
    if (!G[i].empty()) {
      cycles.emplace_back();
      dfs(i);
      len += int((cycles.back()).size());
    }
  if (len > upper) {
    cout << "-1\n";
    return;
  }
  int toMerge = min(int((cycles).size()), upper - len);
  if (toMerge > 2) {
    Vi one, two;
    for (int i = (0); i < (toMerge); i++) {
      one.insert(one.end(), (cycles.back()).begin(), (cycles.back()).end());
      two.push_back(cycles.back()[0]);
      cycles.pop_back();
    }
    reverse((two).begin(), (two).end());
    cycles.push_back(move(one));
    cycles.push_back(move(two));
  }
  cout << int((cycles).size()) << '\n';
  for (auto& c : (cycles)) {
    cout << int((c).size()) << '\n';
    for (auto& first : (c)) cout << first + 1 << ' ';
    cout << '\n';
  }
}
