#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200100;
int arr[MAXN], tmp[MAXN];
vector<int> ve[MAXN];
map<pair<int, int>, vector<int> > mapa;
int ind[MAXN];
vector<int> out[MAXN];
int sol = 0;
vector<int> t1, t2;
vector<int> comp;
map<int, int> aaa;
void tour(int x, int i) {
  while (ind[x] < ve[x].size()) {
    int y = ve[x][ind[x]++];
    int ind = mapa[{x, y}].back();
    mapa[{x, y}].pop_back();
    tour(y, ind);
  }
  out[sol].push_back(i);
  return;
}
int main() {
  ios_base::sync_with_stdio(false);
  int n, s;
  cin >> n >> s;
  for (int i = (0); i < (n); i++) {
    cin >> arr[i];
    comp.push_back(arr[i]);
  }
  sort(comp.begin(), comp.end());
  comp.resize(unique(comp.begin(), comp.end()) - comp.begin());
  for (int i = (0); i < (comp.size()); i++) {
    aaa[comp[i]] = i;
  }
  for (int i = (0); i < (n); i++) {
    arr[i] = aaa[arr[i]];
    tmp[i] = arr[i];
  }
  sort(tmp, tmp + n);
  for (int i = (0); i < (n); i++) {
    if (arr[i] != tmp[i]) {
      mapa[{tmp[i], arr[i]}].push_back(i);
      ve[tmp[i]].push_back(arr[i]);
    }
  }
  int uk = 0;
  for (int i = (0); i < (n); i++) {
    tour(tmp[i], i);
    out[sol].pop_back();
    if (out[sol].size()) {
      reverse(out[sol].begin(), out[sol].end());
      uk += out[sol].size();
      sol++;
    }
  }
  if (uk > s) {
    cout << "-1\n";
    return 0;
  }
  int m = min(sol, s - uk);
  for (int i = (0); i < (m); i++) {
    sol--;
    for (int x : out[sol]) t1.push_back(x);
    t2.push_back(out[sol][0]);
  }
  if (m == 1) sol++;
  if (m <= 1) {
    cout << sol << endl;
    for (int i = (0); i < (sol); i++) {
      cout << out[i].size() << "\n";
      for (int x : out[i]) cout << x + 1 << " ";
      cout << "\n";
    }
  } else {
    reverse(t2.begin(), t2.end());
    cout << sol + 2 << endl;
    cout << t1.size() << endl;
    for (int x : t1) cout << x + 1 << " ";
    cout << endl;
    cout << t2.size() << endl;
    for (int x : t2) cout << x + 1 << " ";
    cout << endl;
    for (int i = (0); i < (sol); i++) {
      cout << out[i].size() << "\n";
      for (int x : out[i]) cout << x + 1 << " ";
      cout << "\n";
    }
  }
  return 0;
}
