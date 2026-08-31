#include <bits/stdc++.h>
using namespace std;
bool cmp(int a, int b) { return a > b; }
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n, m;
  cin >> n;
  vector<int> a(n), a_f(n);
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    a_f[i] = a[i];
  }
  sort(a_f.begin(), a_f.end(), cmp);
  cin >> m;
  for (int i = 0; i < m; i++) {
    int k, pos;
    cin >> k >> pos;
    multiset<int> A;
    for (int j = 0; j < k; j++) {
      A.insert(a_f[j]);
    }
    vector<bool> used(n);
    int now = 0;
    for (int now = 0; now < n; now++) {
      if (A.find(a[now]) != A.end()) {
        A.erase(A.find(a[now]));
        used[now] = true;
      }
    }
    vector<int> ans1;
    for (int j = 0; j < n; j++) {
      if (used[j]) {
        ans1.push_back(a[j]);
      }
    }
    cout << ans1[pos - 1] << endl;
  }
}
