#include <bits/stdc++.h>
using namespace std;
int dx8[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy8[] = {0, 1, 1, 1, 0, -1, -1, -1};
int dx4[] = {1, 0, -1, 0};
int dy4[] = {0, 1, 0, -1};
template <class A, class B>
ostream& operator<<(ostream& out, const pair<A, B>& a) {
  return out << "(" << a.first << "," << a.second << ")";
}
template <class A>
ostream& operator<<(ostream& out, const vector<A>& a) {
  for (const A& it : a) out << it << " ";
  return out;
}
template <class A, class B>
istream& operator>>(istream& in, pair<A, B>& a) {
  return in >> a.first >> a.second;
}
template <class A>
istream& operator>>(istream& in, vector<A>& a) {
  for (A& i : a) in >> i;
  return in;
}
vector<int>* inputG(int n, int m) {
  vector<int>* edges = new vector<int>[n + 1];
  for (int i = 0; i < m; i++) {
    int sv, ev;
    cin >> sv >> ev;
    edges[sv].push_back(ev);
    edges[ev].push_back(sv);
  }
  return edges;
}
void solve() {
  int n;
  cin >> n;
  vector<int>* edges = inputG(n, n - 1);
  for (int i = 1; i <= n; i++) {
    if (edges[i].size() == 2) {
      cout << "NO"
           << "\n";
      ;
      return;
    }
  }
  cout << "YES"
       << "\n";
  ;
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
