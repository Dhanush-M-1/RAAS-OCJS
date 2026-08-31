#include <bits/stdc++.h>
using namespace std;
const int MAXN = 202020;
int N, S, val[MAXN], sorted[MAXN], begin_idx[MAXN], incl[MAXN], c = 0;
map<int, int> compress;
vector<int> adj[MAXN], cycle;
map<pair<int, int>, vector<int>> locs;
void recur(int n) {
  ;
  while (adj[n].size() > 0) {
    int nex = adj[n].back();
    adj[n].pop_back();
    recur(nex);
  };
  cycle.push_back(n);
}
vector<int> reconstruct(vector<int>& cycle) {
  ;
  vector<int> result;
  for (int i = 0; i < cycle.size(); ++i) {
    int nex = (i + 1) % cycle.size();
    pair<int, int> key = {cycle[i], cycle[nex]};
    vector<int>& opts = locs[key];
    ;
    assert(opts.size() > 0);
    result.push_back(opts.back());
    opts.pop_back();
  }
  return result;
}
int main() {
  scanf("%d %d", &N, &S);
  for (int i = 1; i <= N; ++i) {
    scanf("%d", &val[i]);
  }
  for (int i = 1; i <= N; ++i) {
    sorted[i] = val[i];
  }
  sort(sorted + 1, sorted + N + 1);
  for (int i = 1; i <= N; ++i) {
    if (compress.find(sorted[i]) == compress.end()) {
      compress[sorted[i]] = c++;
    }
  }
  for (int i = 1; i <= N; ++i) {
    val[i] = compress[val[i]];
    sorted[i] = val[i];
  }
  int nswaps = 0;
  sort(sorted + 1, sorted + N + 1);
  for (int i = 1; i <= N; ++i) {
    if (val[i] != sorted[i]) {
      adj[sorted[i]].push_back(val[i]);
      nswaps++;
    } else {
      incl[i] = 1;
    }
  }
  if (nswaps > S) {
    printf("-1\n");
    return 0;
  }
  for (int i = 1; i <= N; ++i) {
    if (begin_idx[sorted[i]] == 0) {
      begin_idx[sorted[i]] = i;
    }
  }
  for (int i = 1; i <= N; ++i) {
    ;
    if (locs.find({sorted[i], val[i]}) == locs.end()) {
      locs[{sorted[i], val[i]}] = vector<int>(1, i);
    } else {
      locs[{sorted[i], val[i]}].push_back(i);
    }
  };
  vector<vector<int>> cycles;
  for (int i = 0; i < c; ++i) {
    cycle.clear();
    ;
    recur(i);
    reverse(cycle.begin(), cycle.end());
    cycle.pop_back();
    if (cycle.size() > 0) {
      cycle = reconstruct(cycle);
      cycles.push_back(cycle);
    }
  };
  int to_merge = min(S - nswaps, (int)cycles.size());
  if (to_merge > 1) {
    vector<int> cycle1, cycle2;
    for (int i = 0; i < to_merge; ++i) {
      for (int j = 0; j < cycles.back().size(); ++j) {
        cycle1.push_back(cycles.back()[j]);
      }
      cycle2.push_back(cycles.back()[0]);
      cycles.pop_back();
    }
    reverse(cycle2.begin(), cycle2.end());
    cycles.push_back(cycle1);
    cycles.push_back(cycle2);
  };
  printf("%d\n", (int)cycles.size());
  for (int i = 0; i < cycles.size(); ++i) {
    printf("%d\n", (int)cycles[i].size());
    for (int j = 0; j < cycles[i].size(); ++j) {
      printf("%d", cycles[i][j]);
      if (j == cycles[i].size() - 1)
        printf("\n");
      else
        printf(" ");
    }
  }
  return 0;
}
