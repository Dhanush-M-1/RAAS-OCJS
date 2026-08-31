#include <bits/stdc++.h>
using lint = long long int;
using pll = std::pair<lint, lint>;
using std::vector;
vector<pll> graph[100100];
vector<lint> bb, aa;
lint ans = 0;
bool check_ans = true;
lint check_val = 1000000000000000000LL;
lint dfs(int cur, int par, lint par_val) {
  lint cur_need = bb[cur - 1] - aa[cur - 1];
  lint cur_val = 1;
  for (int i = 0; i < graph[cur].size(); i++) {
    if (graph[cur][i].first != par) {
      cur_need += dfs(graph[cur][i].first, cur, graph[cur][i].second);
      if (cur_need > check_val) {
        printf("NO");
        exit(0);
      }
    } else {
      cur_val = graph[cur][i].second;
    }
  }
  if (cur_need < 0) {
    if (check_val / par_val < (-cur_need)) {
      printf("NO");
      exit(0);
    }
    return cur_need * par_val;
  } else {
    return cur_need / cur_val;
  }
}
int main(void) {
  int N;
  scanf("%d", &N);
  for (int i = 1; i <= N; i++) {
    lint temp;
    scanf("%lld", &temp);
    bb.push_back(temp);
  }
  for (int i = 1; i <= N; i++) {
    lint temp;
    scanf("%lld", &temp);
    aa.push_back(temp);
  }
  for (int i = 2; i <= N; i++) {
    lint t1, t2;
    scanf("%lld %lld", &t1, &t2);
    graph[t1].push_back(pll(i, t2));
    graph[i].push_back(pll(t1, 1));
  }
  ans = dfs(1, 0, 1);
  if (!check_ans) {
    printf("NO");
  } else if (ans < 0) {
    printf("NO");
  } else {
    printf("YES");
  }
  return 0;
}
