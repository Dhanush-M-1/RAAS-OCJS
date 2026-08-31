#include <bits/stdc++.h>
using namespace std;
int n, m;
int p[400006];
int me;
set<int> st[300005];
pair<int, int> pr;
int main() {
  scanf("%d%d", &n, &m);
  vector<int> vec(n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", p + i);
    vec[i - 1] = p[i];
  }
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &pr.first, &pr.second);
    st[pr.first].insert(pr.second);
  }
  me = p[n];
  vec.pop_back();
  for (int i = (int)vec.size() - 1; i >= 0; i--) {
    int now = vec[i];
    for (int j = i + 1; j < vec.size(); j++) {
      if (st[now].count(vec[j])) {
        swap(vec[j], vec[j - 1]);
      } else
        break;
    }
    if (st[vec.back()].count(me)) {
      vec.pop_back();
    }
  }
  cout << n - vec.size() - 1;
  return 0;
}
