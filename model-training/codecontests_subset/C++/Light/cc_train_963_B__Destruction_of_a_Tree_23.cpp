#include <bits/stdc++.h>
using namespace std;
int p[200002], d[200002];
vector<int> ch[200002];
vector<int> ans, buf;
void bfs(int pos) {
  for (int c : ch[pos]) bfs(c);
  if (d[pos] & 1) {
    buf.push_back(pos);
  } else {
    ans.push_back(pos);
    d[p[pos]]--;
  }
}
int main() {
  int n;
  cin >> n;
  int root = 0;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
    if (p[i] == 0) {
      root = i;
    } else {
      ch[p[i]].push_back(i);
    }
    d[i]++;
    d[p[i]]++;
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  bfs(root);
  for (int a : ans) cout << a << endl;
  reverse(buf.begin(), buf.end());
  for (int b : buf) cout << b << endl;
  return 0;
}
