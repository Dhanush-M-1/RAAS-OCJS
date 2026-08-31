#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b;
  cin >> n;
  map<pair<int, int>, bool> m;
  vector<int> x[100009];
  vector<int> y[100009];
  for (int f = 0; f < n; f++) {
    scanf("%d %d", &a, &b);
    x[b].push_back(a);
    y[a].push_back(b);
    m[make_pair(a, b)] = 1;
  }
  for (int f = 0; f < 100009; f++) sort(y[f].begin(), y[f].end());
  for (int f = 0; f < 100009; f++) sort(x[f].begin(), x[f].end());
  long long ans = 0, sq = 314;
  for (int f = 0; f < 100009; f++) {
    if (x[f].size() > sq) {
      for (int f1 = 0; f1 < x[f].size(); f1++) {
        for (int f2 = 0; f2 < y[x[f][f1]].size() && y[x[f][f1]][f2] < f; f2++) {
          if (x[f][f1] + f - y[x[f][f1]][f2] >= 0 &&
              x[f][f1] + f - y[x[f][f1]][f2] < 100009 &&
              binary_search(y[x[f][f1] + f - y[x[f][f1]][f2]].begin(),
                            y[x[f][f1] + f - y[x[f][f1]][f2]].end(), f) &&
              x[f][f1] + f - y[x[f][f1]][f2] >= 0 &&
              x[f][f1] + f - y[x[f][f1]][f2] < 100009 &&
              binary_search(y[x[f][f1] + f - y[x[f][f1]][f2]].begin(),
                            y[x[f][f1] + f - y[x[f][f1]][f2]].end(),
                            y[x[f][f1]][f2]))
            ans++;
        }
      }
    } else {
      for (int f1 = 0; f1 < x[f].size(); f1++) {
        for (int f2 = f1 + 1; f2 < x[f].size(); f2++) {
          if (x[f][f1] >= 0 && x[f][f1] < 100009 &&
              binary_search(y[x[f][f1]].begin(), y[x[f][f1]].end(),
                            f - x[f][f2] + x[f][f1]) &&
              x[f][f2] >= 0 && x[f][f2] < 100009 &&
              binary_search(y[x[f][f2]].begin(), y[x[f][f2]].end(),
                            f - x[f][f2] + x[f][f1]))
            ans++;
        }
      }
    }
  }
  cout << ans << endl;
  return 0;
}
