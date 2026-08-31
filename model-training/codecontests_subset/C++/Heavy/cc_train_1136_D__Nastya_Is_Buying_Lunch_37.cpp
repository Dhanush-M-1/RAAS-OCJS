#include <bits/stdc++.h>
using namespace std;
vector<int> arr;
vector<unordered_set<int> > gr;
int solve(int pos) {
  int ans = 0;
  for (int i = pos - 1; i >= 0; --i)
    if (gr[arr[i]].count(arr[pos])) {
      bool ok = true;
      for (int j = i + 1; j < pos; ++j)
        if (!gr[arr[i]].count(arr[j])) {
          ok = false;
          break;
        }
      if (ok) {
        ++ans;
        swap(arr[i], arr[pos - 1]);
        swap(arr[pos], arr[pos - 1]);
        --pos;
      }
    }
  return ans;
}
int main() {
  int n, m;
  cin >> n >> m;
  arr.resize(n);
  gr.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> arr[i];
    --arr[i];
  }
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    gr[a - 1].insert(b - 1);
  }
  cout << solve(n - 1) << endl;
  return 0;
}
