#include <bits/stdc++.h>
using namespace std;
template <class T1>
void debug(T1 e) {
  cout << e << endl;
}
template <class T1, class T2>
void debug(T1 e1, T2 e2) {
  cout << e1 << "\t" << e2 << endl;
}
template <class T1, class T2, class T3>
void debug(T1 e1, T2 e2, T3 e3) {
  cout << e1 << "\t" << e2 << "\t" << e3 << endl;
}
template <class T1, class T2, class T3, class T4>
void debug(T1 e1, T2 e2, T3 e3, T4 e4) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << endl;
}
template <class T1, class T2, class T3, class T4, class T5>
void debug(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << "\t" << e5 << endl;
}
template <class T1, class T2, class T3, class T4, class T5, class T6>
void debug(T1 e1, T2 e2, T3 e3, T4 e4, T5 e5, T6 e6) {
  cout << e1 << "\t" << e2 << "\t" << e3 << "\t" << e4 << "\t" << e5 << "\t"
       << e6 << endl;
}
template <class T>
void debug(vector<vector<T> > e, int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << " ";
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(vector<basic_string<T> > e, int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j];
    cout << endl;
  }
  cout << endl;
}
template <class T>
void debug(T e[110][110], int row, int col) {
  int i, j;
  for (i = 0; i < row; i++) {
    for (j = 0; j < col; j++) cout << e[i][j] << " ";
    cout << endl;
  }
}
template <class T>
string toString(T n) {
  ostringstream oss;
  oss << n;
  oss.flush();
  return oss.str();
}
int toInt(string s) {
  int r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
bool isVowel(char ch) {
  ch = tolower(ch);
  if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
    return true;
  return false;
}
bool isUpper(char c) { return c >= 'A' && c <= 'Z'; }
bool isLower(char c) { return c >= 'a' && c <= 'z'; }
vector<int> adj[3110];
int n;
int col[3110];
int cyclecolor;
void predfs(int node, int par) {
  col[node] = node + 1;
  int i;
  for (i = 0; i < ((int)adj[node].size()); i++) {
    int tem = adj[node][i];
    if (tem == par) continue;
    if (col[tem]) {
      cyclecolor = col[node] = col[tem];
      continue;
    }
    predfs(tem, node);
    if (col[tem] != (tem + 1)) col[node] = col[tem];
  }
}
bool temcol[3110];
int cyclelength;
double ans;
void dfs(int node, int c, int len) {
  if (temcol[node]) return;
  temcol[node] = true;
  ans += (1.0 / len);
  if (c > 2 && (len + cyclelength - 2 * c + 2) > 0)
    ans += (1.0 * (c - 2)) /
           ((len - c + cyclelength) * (len + cyclelength - 2 * c + 2));
  int i;
  for (i = 0; i < ((int)adj[node].size()); i++) {
    int tem = adj[node][i];
    dfs(tem, c + (cyclecolor == col[tem]), len + 1);
  }
}
int main() {
  while (cin >> n) {
    int i, u, v;
    for (i = 1; i <= n; i++) {
      cin >> u >> v;
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    predfs(0, -1);
    for (i = 0; i < n; i++) cyclelength += (cyclecolor == col[i]);
    for (i = 0; i < n; i++) {
      memset(temcol, false, sizeof(temcol));
      dfs(i, (cyclecolor == col[i]), 1);
    }
    printf("%.12lf\n", ans);
  }
  return 0;
}
