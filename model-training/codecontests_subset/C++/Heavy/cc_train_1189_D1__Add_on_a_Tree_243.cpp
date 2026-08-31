#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  std::cerr << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  std::cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
const int fx[] = {+1, -1, +0, +0};
const int fy[] = {+0, +0, +1, -1};
int ans = 0;
void nishantwrp(int cas) {
  int n;
  cin >> n;
  vector<int> nodes[n + 1];
  for (int i = 0; i < n - 1; i++) {
    int a, b;
    cin >> a >> b;
    nodes[a].push_back(b);
    nodes[b].push_back(a);
  }
  for (int i = 0; i < n; i++) {
    if ((int)nodes[i + 1].size() == 2) {
      cout << "NO";
      return;
    }
  }
  cout << "YES";
}
signed main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  int cas = 1;
  while (cas <= t) {
    nishantwrp(cas);
    cas++;
  }
  return 0;
}
