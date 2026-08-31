#include <bits/stdc++.h>
using namespace std;
const int N = 1e4;
int arr[N], sum[N];
void solve() {
  string s;
  cin >> s;
  vector<int> v;
  for (int i = 0; i < s.length(); ++i) {
    if (s[i] != '+') v.push_back(s[i] - '0');
  }
  sort(v.begin(), v.end());
  int n = v.size();
  for (int i = 0; i < n; ++i) {
    cout << to_string(v[i]);
    if (i != n - 1) cout << '+';
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  solve();
}
