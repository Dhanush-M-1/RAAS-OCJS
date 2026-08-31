#include <bits/stdc++.h>
using namespace std;
const long long mod7 = 1000000007;
int gcd(int a, int b) {
  while (b) {
    a %= b;
    swap(a, b);
  }
  return a;
}
vector<int> gr[1000001];
pair<long long, long long> data[1000001];
bool used1[1000001];
bool used2[1000001];
int dfs(int v) {
  vector<int> ch, ch2;
  used2[v] = true;
  for (int i = 0; i < gr[v].size(); ++i) {
    int m = gr[v][i];
    if (used1[m]) continue;
    used1[m] = true;
    int fr = data[m].first;
    int to = data[m].second;
    if (to == v) swap(fr, to);
    ch2.push_back(to);
  }
  for (int i = 0; i < ch2.size(); ++i) {
    if (!used2[ch2[i]]) {
      int ret = dfs(ch2[i]);
      if (ret) {
        printf("%d %d %d\n", ret, ch2[i], v);
      } else {
        ch.push_back(ch2[i]);
      }
    } else
      ch.push_back(ch2[i]);
  }
  for (int i = 0; i + 1 < ch.size(); i += 2) {
    printf("%d %d %d\n", ch[i], v, ch[i + 1]);
  }
  if (ch.size() & 1) return ch.back();
  return 0;
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  if (m & 1) {
    printf("No solution");
    return 0;
  }
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &data[i].first, &data[i].second);
    gr[data[i].first].push_back(i);
    gr[data[i].second].push_back(i);
  }
  dfs(1);
  return 0;
}
