#include <bits/stdc++.h>
using namespace std;
long long inf = 2147483647;
const long long ll = 9223372036854775807, ninf = 1000000000;
const double eps = 1e-6;
const long long nll = 1000000000000000000;
vector<int> node[200005];
vector<int> num;
int deg[200005] = {};
void dfs(int x) {
  for (int i = 0; i < node[x].size(); i++) {
    dfs(node[x][i]);
  }
  num.push_back(x);
}
int A[200005] = {};
int main() {
  int a;
  while (cin >> a) {
    int r = 1;
    for (int i = 1; i <= a; i++) {
      cin >> A[i];
      deg[A[i]]++;
      if (A[i]) {
        deg[i]++;
        node[A[i]].push_back(i);
      } else {
        r = i;
      }
    }
    if (a % 2 == 0) {
      cout << "NO" << '\n';
      continue;
    }
    dfs(r);
    vector<int> ans1, ans2;
    cout << "YES" << '\n';
    for (int i = 0; i < num.size(); i++) {
      int now = num[i];
      if (deg[now] % 2 == 0) {
        ans2.push_back(now);
        deg[A[now]]--;
      } else {
        ans1.push_back(now);
      }
    }
    for (int i = 0; i < ans2.size(); i++) {
      cout << ans2[i] << '\n';
    }
    reverse(ans1.begin(), ans1.end());
    for (int i = 0; i < ans1.size(); i++) {
      cout << ans1[i] << '\n';
    }
  }
  return 0;
}
