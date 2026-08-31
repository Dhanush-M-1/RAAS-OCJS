#include <bits/stdc++.h>
using namespace std;
const int maxn = 200050;
vector<int> graf[maxn];
int dp[2][maxn];
vector<int> data[maxn];
int n, root;
vector<int> v;
void bejar(int start) {
  for (int s : graf[start]) {
    if (dp[1][s]) {
      bejar(s);
    }
  }
  v.push_back(start);
  for (int s : graf[start]) {
    if (dp[0][s]) {
      bejar(s);
    }
  }
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int z;
    cin >> z;
    z--;
    if (z >= 0) {
      graf[z].push_back(i);
    } else {
      root = i;
    }
  }
  vector<int> sor;
  vector<int> apa;
  sor.push_back(root);
  int it = 0;
  while (it < sor.size()) {
    int akt = sor[it];
    for (int s : graf[akt]) {
      sor.push_back(s);
    }
    it++;
  }
  reverse(sor.begin(), sor.end());
  for (int i = 0; i < n; i++) {
    int akt = sor[i];
    if (graf[akt].size() == 0) {
      dp[0][akt] = true;
      dp[1][akt] = false;
    } else {
      int with_akt = 0;
      for (int s : graf[akt]) {
        if (dp[0][s]) {
          with_akt++;
        }
      }
      if (with_akt % 2 == 0) {
        dp[0][akt] = true;
        dp[1][akt] = false;
      } else {
        dp[0][akt] = false;
        dp[1][akt] = true;
      }
    }
  }
  if (dp[0][root]) {
    cout << "YES" << endl;
    bejar(root);
    for (int d : v) {
      cout << d + 1 << endl;
    }
    return 0;
  }
  cout << "NO" << endl;
  return 0;
}
