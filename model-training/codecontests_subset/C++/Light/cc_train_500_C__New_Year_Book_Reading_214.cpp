#include <bits/stdc++.h>
using namespace std;
const int MAXM = 1000;
const int MAXN = 500;
int b[MAXM + 10];
int w[MAXN + 10];
bool vis[MAXN + 10];
vector<int> vec;
void printVec(vector<int>& vec) {
  for (int i = 0; i < vec.size(); i++) {
    printf("%d ", vec[i]);
  }
  printf("\n");
  return;
}
int search(int n, vector<int>& vec) {
  vector<int> temp, nvec;
  int ret = 0;
  int i;
  for (i = 0; i < vec.size(); i++) {
    if (vec[i] != n) {
      ret += w[vec[i]];
      temp.push_back(vec[i]);
    } else {
      break;
    }
  }
  nvec.push_back(vec[i]);
  for (int j = 0; j < temp.size(); j++) {
    nvec.push_back(temp[j]);
  }
  for (i = i + 1; i < vec.size(); i++) {
    nvec.push_back(vec[i]);
  }
  vec = nvec;
  return ret;
}
int calc(int m, vector<int>& vec) {
  int ret = 0;
  for (int i = 0; i < m; i++) {
    ret += search(b[i], vec);
  }
  return ret;
}
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &w[i]);
  }
  for (int i = 0; i < m; i++) {
    scanf("%d", &b[i]);
    if (!vis[b[i]]) {
      vec.push_back(b[i]);
      vis[b[i]] = true;
    }
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i] == false) {
      vec.push_back(i);
    }
  }
  int ans = calc(m, vec);
  printf("%d\n", ans);
}
