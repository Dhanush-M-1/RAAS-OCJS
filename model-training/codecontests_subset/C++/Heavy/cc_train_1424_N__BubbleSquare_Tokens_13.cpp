#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 100;
int x[N], y[N], w[N], s[N], v[N];
bool in[N * 2];
vector<pair<int, int> > e[N];
vector<int> res;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = (1); i <= (m); i++) {
    scanf("%d%d", x + i, y + i);
    w[i] = 1;
    s[x[i]]++;
    s[y[i]]++;
    e[max(x[i], y[i])].push_back(make_pair(min(x[i], y[i]), i));
  }
  for (int i = (1); i <= (n); i++) {
    for (auto it : e[i]) {
      if (!v[it.first]) {
        v[it.first] = 1;
        w[it.second] = 0;
        s[i]--;
      }
      in[s[it.first]] = 1;
    }
    for (auto it : e[i]) {
      if (!in[s[i]]) break;
      s[i]++;
      v[it.first] = 0;
      w[it.second]++;
    }
    for (auto it : e[i]) in[s[it.first]] = 0;
  }
  for (int i = (1); i <= (n); i++)
    if (v[i]) res.push_back(i);
  printf("%d\n", int(res.size()));
  for (auto it : res) printf("%d ", it);
  puts("");
  for (int i = (1); i <= (m); i++) printf("%d %d %d\n", x[i], y[i], w[i]);
  return 0;
}
