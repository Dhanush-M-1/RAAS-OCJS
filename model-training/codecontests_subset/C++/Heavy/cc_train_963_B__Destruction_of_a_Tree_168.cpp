#include <bits/stdc++.h>
using namespace std;
int inf = pow(10, 9);
long long int modulo = pow(10, 9) + 9;
long double eps = 1e-15;
ifstream in;
ofstream out;
vector<int> g[200100];
vector<int> taken;
vector<int>* dsu[200100];
int depth[200100];
bool J(int& a, int& b) { return depth[a] < depth[b]; }
void add(vector<int>*& a, vector<int>*& b) {
  if ((*b).size() > (*a).size()) {
    vector<int>* temp = a;
    a = b;
    b = temp;
  }
  for (int j = 0; j < (*b).size(); j++) (*a).push_back((*b)[j]);
}
bool dfs(int hd, int pr, int dep) {
  dsu[hd] = new vector<int>();
  depth[hd] = dep;
  int nece = 0;
  for (long long int i = 0; i < g[hd].size(); i++) {
    int hr = g[hd][i];
    if (hr == pr) continue;
    bool ans = dfs(hr, hd, dep + 1);
    nece += !ans;
    add(dsu[hd], dsu[hr]);
  }
  if (hd) {
    if (nece & 1) {
      sort((*dsu[hd]).begin(), (*dsu[hd]).end(), J);
      taken.push_back(hd);
      for (int j = 0; j < (*dsu[hd]).size(); j++)
        taken.push_back((*dsu[hd])[j]);
      (*dsu[hd]).clear();
      return 1;
    }
    (*dsu[hd]).push_back(hd);
    return 0;
  } else {
    if (nece & 1) return 0;
    taken.push_back(hd);
    sort((*dsu[hd]).begin(), (*dsu[hd]).end(), J);
    for (int j = 0; j < (*dsu[hd]).size(); j++) taken.push_back((*dsu[hd])[j]);
    (*dsu[hd]).clear();
    return 1;
  }
}
void deal() {
  int n;
  cin >> n;
  for (long long int i = 0; i < n; i++) {
    int pr;
    cin >> pr;
    --pr;
    if (pr > -1) g[pr].push_back(i), g[i].push_back(pr);
  }
  if (dfs(0, -1, 0)) {
    cout << "YES\n";
    for (int j = 0; j < taken.size(); j++) cout << taken[j] + 1 << '\n';
  } else
    cout << "NO\n";
}
int main() { deal(); }
