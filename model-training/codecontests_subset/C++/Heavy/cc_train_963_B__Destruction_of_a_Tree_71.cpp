#include <bits/stdc++.h>
using namespace std;
int A[300002];
vector<int> ans;
vector<int> v[300002];
vector<int> lv[300002];
int papa[300002];
int done[300002];
int n;
int last = 0;
map<pair<int, int>, int> imap;
void dfs(int root, int par, int p) {
  papa[root] = par;
  if (A[root] % 2 == 0) {
    lv[p].push_back(root);
  }
  last = max(last, p);
  for (int i = 0; i < v[root].size(); i++) {
    int num = v[root][i];
    if (num != par) {
      dfs(num, root, p + 1);
    }
  }
}
bool checkis(int root, int par) {
  for (int i = 0; i < v[root].size(); i++) {
    int num = v[root][i];
    if (imap[make_pair(root, num)] == 0) {
      return 1;
    }
    if (num != par) {
      checkis(num, root);
    }
  }
  return 0;
}
bool check(int root) {
  for (int i = last; i >= 0; i--) {
    for (int j = 0; j < lv[i].size(); j++) {
      int num = lv[i][j];
      if (A[num] % 2 == 1 || done[num] == 1) {
        continue;
      }
      int pop = papa[num];
      ans.push_back(num);
      done[num] = 1;
      for (int k = 0; k < v[num].size(); k++) {
        int y = v[num][k];
        imap[make_pair(num, y)] = 1;
        imap[make_pair(y, num)] = 1;
        A[y] -= 1;
        if (A[y] % 2 == 0 && A[y] != 0) {
          if (y == pop) {
            lv[i - 1].push_back(y);
          } else {
            lv[i + 1].push_back(y);
          }
        }
      }
    }
  }
  for (int i = 0; i <= last; i++) {
    for (int j = 0; j < lv[i].size(); j++) {
      int num = lv[i][j];
      if (A[num] % 2 == 1 || done[num] == 1) {
        continue;
      }
      ans.push_back(num);
      done[num] = 1;
      for (int k = 0; k < v[num].size(); k++) {
        int y = v[num][k];
        A[y] -= 1;
        if (A[y] % 2 == 0 && A[y] != 0) {
          lv[i + 1].push_back(y);
        }
        imap[make_pair(num, y)] = 1;
        imap[make_pair(y, num)] = 1;
      }
    }
  }
  if (!checkis(root, 0)) {
    return 1;
  }
  return 0;
}
void solve(int root) {
  dfs(root, 0, 0);
  if (check(root)) {
    cout << "YES" << endl;
    for (int i = 0; i < ans.size(); i++) {
      cout << ans[i] << " ";
    }
    for (int i = 1; i <= n; i++) {
      if (done[i] == 0) {
        cout << i << " ";
      }
    }
    cout << endl;
  } else {
    cout << "NO" << endl;
  }
}
int main() {
  scanf("%d", &n);
  int root;
  for (int i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    if (p != 0) {
      A[p] += 1;
      A[i] += 1;
      v[i].push_back(p);
      v[p].push_back(i);
    } else {
      root = i;
    }
  }
  int cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (A[i] != 0) {
      if (A[i] % 2 == 0) {
        cnt++;
      }
    }
  }
  solve(root);
}
