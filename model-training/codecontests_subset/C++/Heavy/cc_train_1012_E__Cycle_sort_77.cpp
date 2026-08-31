#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1 << 20;
int arr[MAXN], srt[MAXN];
bool bio[MAXN];
vector<pair<int, int>> edges[MAXN];
vector<vector<int>> cyc;
void euler(int i) {
  bio[i] = true;
  while (!edges[i].empty()) {
    auto x = edges[i].back();
    edges[i].pop_back();
    euler(x.first);
    cyc.back().push_back(x.second);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n, s, m, i, j;
  unordered_map<int, int> cpr;
  cin >> n >> s;
  for (i = 0; i < n; ++i) {
    cin >> arr[i];
    srt[i] = arr[i];
  }
  sort(srt, srt + n);
  for (i = j = 0; i < n; ++i) {
    if (i && srt[i - 1] != srt[i]) {
      ++j;
      cpr[srt[i]] = j;
    }
  }
  m = j + 1;
  for (i = 0; i < n; ++i) {
    arr[i] = cpr[arr[i]];
    srt[i] = cpr[srt[i]];
  }
  for (i = 0; i < n; ++i)
    if (arr[i] != srt[i]) edges[arr[i]].push_back({srt[i], i});
  for (i = 0; i < m; ++i)
    if (!bio[i]) {
      cyc.emplace_back();
      euler(i);
      if (cyc.back().empty())
        cyc.pop_back();
      else
        s -= cyc.back().size();
    }
  if (s < 0) {
    cout << "-1\n";
    return 0;
  }
  if (s <= 2 || cyc.size() <= 2) {
    cout << cyc.size() << '\n';
    for (const auto& x : cyc) {
      cout << x.size() << '\n';
      for (int y : x) cout << y + 1 << ' ';
      cout << '\n';
    }
    return 0;
  }
  if (s > cyc.size()) s = cyc.size();
  cout << cyc.size() - s + 2 << '\n';
  m = 0;
  for (i = 0; i < s; ++i) {
    m += cyc[i].size();
  }
  cout << m << '\n';
  for (i = 0; i < s; ++i) {
    for (int y : cyc[i]) cout << y + 1 << ' ';
  }
  cout << s << '\n';
  for (i = s - 1; i >= 0; --i) {
    cout << cyc[i].front() + 1 << ' ';
  }
  cout << '\n';
  for (i = s; i < cyc.size(); ++i) {
    cout << cyc[i].size() << '\n';
    for (int y : cyc[i]) cout << y + 1 << ' ';
    cout << '\n';
  }
}
