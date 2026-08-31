#include <bits/stdc++.h>
using namespace std;
string text[1000001];
int range[1000001], lines[1000001];
vector<int> followers[1000001];
int n, r, c;
int maxMax(-1), maxInd(0);
void setMaxNums(void) {
  int total(0), j(-1);
  for (int i = 0; i < n; ++i) {
    if (j < i) total = text[j = i].size();
    while (j < n - 1 && text[j + 1].size() + 1 + total <= (unsigned int)c) {
      total += text[j + 1].size() + 1;
      ++j;
    }
    lines[i] = range[i] = total <= c ? j - i + 1 : -1;
    total -= text[i].size() + 1;
  }
}
void oneThatFollows(void) {
  for (int i = 0; i < n; ++i) followers[i + range[i]].push_back(i);
}
void findLines(int dest) {
  vector<int> stInd, path;
  stInd.push_back(-1);
  stInd.push_back(dest);
  path.push_back(0);
  while (!stInd.empty()) {
    int tmp = stInd.back();
    stInd.pop_back();
    if (tmp == -1) {
      path.pop_back();
      continue;
    }
    stInd.push_back(-1);
    path.push_back(path.back() + range[tmp]);
    while (!followers[tmp].empty()) {
      stInd.push_back(followers[tmp].back());
      followers[tmp].pop_back();
    }
    int pre((int)(path.size()) - r - 1);
    lines[tmp] = path.back() - (pre < 0 ? 0 : path[pre]);
  }
}
void endAllEnders(void) {
  for (int i = n - 1; i >= 0; --i)
    if (!followers[i].empty()) findLines(i);
}
void findMax(void) {
  for (int i = 0; i < n; ++i)
    if (maxMax < lines[i]) {
      maxMax = lines[i];
      maxInd = i;
    }
}
void printOne(int i) {
  if (range[i] == -1) return;
  cout << text[i];
  for (int j = 1; j < range[i]; ++j) cout << " " << text[i + j];
  cout << '\n';
}
void printRight(void) {
  int tmpInd(maxInd);
  for (int i = 0; i < r; ++i) {
    if (tmpInd >= n || range[tmpInd] == -1) break;
    printOne(tmpInd);
    tmpInd += range[tmpInd];
  }
}
int main(void) {
  cin >> n >> r >> c;
  for (int i = 0; i < n; ++i) cin >> text[i];
  setMaxNums();
  oneThatFollows();
  endAllEnders();
  findMax();
  printRight();
  return 0;
}
