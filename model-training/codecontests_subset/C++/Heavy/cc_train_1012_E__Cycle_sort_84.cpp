#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:167772160000")
using namespace std;
void redirectIO() {
  ios::sync_with_stdio(false);
  cin.tie(0);
}
int n;
int a[210000];
map<int, vector<int>> numberPositions;
int s;
int sa[210000];
int badPos;
vector<vector<int>> vectors;
bool vis[210000];
int goesTo[210000];
void doVec(int pos) {
  vector<int> curVector;
  int initialNum = a[pos];
  curVector.push_back(pos);
  int need = sa[pos];
  vis[pos] = true;
  while (need != initialNum) {
    auto it = numberPositions.find(need);
    int curNum = it->second.back();
    it->second.pop_back();
    curVector.push_back(curNum);
    vis[curNum] = true;
    need = sa[curNum];
  }
  vectors.push_back(curVector);
  curVector.clear();
}
vector<vector<int>> answer;
void doAnsVec(int pos) {
  int initialPos = pos;
  vis[pos] = true;
  answer.push_back(vector<int>());
  answer.back().push_back(pos);
  pos = goesTo[pos];
  while (!vis[pos]) {
    vis[pos] = true;
    answer.back().push_back(pos);
    pos = goesTo[pos];
  }
}
int par[210000];
int find(int a) {
  if (a == par[a]) return a;
  return par[a] = find(par[a]);
}
void unite(int a, int b) { par[find(a)] = find(b); }
bool FAIL;
int curNum[210000];
void applyCycle(vector<int> a) {
  reverse(a.begin(), a.end());
  int fr = curNum[a[a.size() - 1]];
  for (int i = a.size() - 1; i > 0; i--) {
    curNum[a[i]] = curNum[a[i - 1]];
  }
  curNum[a[0]] = fr;
}
bool isGood() {
  for (int i = 0; i < (n); i++) curNum[i] = a[i];
  for (auto x : answer) applyCycle(x);
  for (int i = 0; i < (n); i++)
    if (curNum[i] != sa[i]) return false;
  return true;
}
void solve() {
  for (int i = 0; i < (n); i++) sa[i] = a[i];
  answer.clear();
  badPos = 0;
  vectors.clear();
  for (int i = 0; i < (n); i++) vis[i] = false;
  FAIL = false;
  sort(sa, sa + n);
  for (int i = 0; i < (n); i++) {
    if (sa[i] != a[i]) {
      badPos++;
      numberPositions[a[i]].push_back(i);
    }
  }
  s -= badPos;
  if (s < 0) {
    FAIL = true;
    return;
  }
  for (int i = 0; i < (n); i++) {
    if (sa[i] != a[i] && !vis[i]) doVec(i);
  }
  for (int i = 0; i < (n); i++) par[i] = i;
  for (int i = 0; i < (n); i++) vis[i] = false;
  for (auto vec : vectors) {
    for (int i = 0; i < (vec.size()); i++) {
      int nxt = i + 1;
      if (i + 1 == vec.size()) nxt = 0;
      nxt = vec[nxt];
      int cur = vec[i];
      goesTo[nxt] = cur;
      unite(cur, nxt);
    }
  }
  numberPositions.clear();
  for (int i = 0; i < (n); i++) {
    if (sa[i] != a[i]) {
      badPos++;
      numberPositions[a[i]].push_back(i);
    }
  }
  for (auto it = numberPositions.begin(); it != numberPositions.end(); it++) {
    for (int i = 0; i < (it->second.size() - 1); i++) {
      int cur = it->second[i];
      int nxt = it->second[i + 1];
      if (find(cur) != find(nxt)) {
        swap(goesTo[cur], goesTo[nxt]);
        unite(cur, nxt);
      }
    }
  }
  for (int i = 0; i < (n); i++) {
    if (a[i] != sa[i] && !vis[i]) doAnsVec(i);
  }
  int taking = min(s, (int)answer.size());
  if (taking < 2) taking = 0;
  if (taking > 0) {
    vector<int> curLong;
    vector<int> curShort;
    while (taking) {
      for (auto x : answer.back()) curLong.push_back(x);
      curShort.push_back(answer.back()[0]);
      answer.pop_back();
      taking--;
    }
    reverse(curShort.begin(), curShort.end());
    answer.push_back(curLong);
    answer.push_back(curShort);
  }
}
int cnt;
void gen() {
  cnt++;
  n = rand() % 8 + 1;
  for (int i = 0; i < (n); i++) a[i] = rand() % 20;
  s = rand() % 5 + n;
  solve();
  if (!isGood()) {
    cout << "AAAAA";
    exit(0);
  }
}
int main() {
  redirectIO();
  cin >> n >> s;
  for (int i = 0; i < (n); i++) {
    cin >> a[i];
  }
  solve();
  if (FAIL) {
    cout << -1;
    return 0;
  }
  cout << answer.size() << endl;
  for (auto vec : answer) {
    cout << vec.size() << "\n";
    for (auto x : vec) cout << x + 1 << " ";
    cout << "\n";
  }
  return 0;
}
