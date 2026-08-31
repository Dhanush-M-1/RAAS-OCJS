#include <bits/stdc++.h>
using namespace std;
using lint = long long int;
struct fast_io {
  fast_io() {
    cout << fixed << setprecision(20);
    ios_base::sync_with_stdio(0);
    cin.tie(nullptr);
    cout.tie(nullptr);
  }
} _fast_io;
void run_case() {
  int n, k;
  cin >> n >> k;
  int ret = INT_MAX;
  vector<int> type01;
  vector<int> type10;
  vector<int> type11;
  for (int i = 0; i < n; ++i) {
    int t, a, b;
    cin >> t >> a >> b;
    if (a == 1 && b == 0) {
      type10.push_back(t);
    } else if (a == 1 && b == 1) {
      type11.push_back(t);
    } else if (a == 0 && b == 1) {
      type01.push_back(t);
    }
  }
  vector<int> t01((int)type01.size() + 1, 0);
  vector<int> t10((int)type10.size() + 1, 0);
  vector<int> t11((int)type11.size() + 1, 0);
  if ((int)type01.size()) sort(type01.begin(), type01.end());
  if ((int)type10.size()) sort(type10.begin(), type10.end());
  if ((int)type11.size()) sort(type11.begin(), type11.end());
  for (int i = 0; i < (int)type01.size(); ++i) {
    t01[i + 1] += t01[i] + type01[i];
  }
  for (int i = 0; i < (int)type10.size(); ++i) {
    t10[i + 1] += t10[i] + type10[i];
  }
  for (int i = 0; i < (int)type11.size(); ++i) {
    t11[i + 1] += t11[i] + type11[i];
  }
  for (int cnt = 0; cnt <= min(k, (int)t11.size() - 1); ++cnt) {
    if (k - cnt <= (int)t01.size() - 1 && k - cnt <= (int)t10.size() - 1) {
      int op = t11[cnt] + t10[k - cnt] + t01[k - cnt];
      ret = min(ret, op);
    }
  }
  if (ret == INT_MAX) {
    cout << -1 << '\n';
  } else {
    cout << ret << '\n';
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int tests = 1;
  for (int i = 1; i <= tests; ++i) {
    run_case();
  }
  return 0;
}
