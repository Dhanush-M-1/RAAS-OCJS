#include <bits/stdc++.h>
using namespace std;
const int max_n = 100005;
int n;
int a[max_n];
int ln[3] = {0, 4, 7};
vector<int> M[55];
map<long long, int> ML, visited;
bool func(long long N) {
  if (N == 0) return 1;
  if (!visited[N]) {
    visited[N] = 1;
    int d = N % 10;
    for (int i = 0; i <= 4; i++)
      if (M[10 * i + d].size() == 6)
        if (func((N / 10) - i)) {
          ML[N] = i + 1;
          return 1;
        }
    return 0;
  }
  return ML[N];
}
void cal(vector<int> x) {
  if (x.size() == 6) {
    int sum = 0;
    for (int i = 0; i < 6; i++) sum += x[i];
    M[sum] = x;
    return;
  }
  for (int i = 0; i < 3; i++) {
    vector<int> y = x;
    y.push_back(ln[i]);
    cal(y);
  }
}
void construct(long long N, vector<int> res[]) {
  if (N == 0) {
    for (int i = 0; i < 6; i++) {
      reverse(res[i].begin(), res[i].end());
      int nr = res[i].size();
      int j = 0;
      while (j < nr - 1 and res[i][j] == 0) j++;
      for (; j < nr; j++) printf("%d", res[i][j]);
      printf(" ");
    }
    return;
  }
  int v = ML[N] - 1;
  for (int i = 0; i < 6; i++) res[i].push_back(M[10 * v + N % 10][i]);
  construct((N / 10) - v, res);
}
int main() {
  vector<int> x;
  cal(x);
  long long N;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    cin >> N;
    if (func(N)) {
      vector<int> res[6];
      construct(N, res);
      printf("\n");
    } else
      printf("-1\n");
  }
  return 0;
}
