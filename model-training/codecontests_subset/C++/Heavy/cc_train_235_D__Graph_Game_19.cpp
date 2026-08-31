#include <bits/stdc++.h>
using namespace std;
template <class t>
ostream &operator<<(ostream &tout, const vector<t> &s) {
  tout << '[';
  for (int i = 0; i < s.size(); i++)
    if (i + 1 == s.size())
      tout << s[i];
    else
      tout << s[i] << ',';
  tout << ']';
  return (tout);
}
template <class a, class b>
ostream &operator<<(ostream &tout, const pair<a, b> &c) {
  return (tout << '(' << c.first << ',' << c.second << ')');
}
template <class T>
struct __set__print {
  __set__print(ostream &out) : tout(out), count(0) {}
  void operator()(T x) {
    if (count > 0) tout << ',';
    tout << x;
    ++count;
  }
  ostream &tout;
  int count;
};
template <class T>
ostream &operator<<(ostream &tout, const set<T> &s) {
  tout << '{';
  for_each(s.begin(), s.end(), __set__print<T>(tout));
  return (tout << '}');
}
template <class T, class Q>
struct print_map {
  print_map(ostream &out) : tout(out), count(0) {}
  void operator()(const pair<T, Q> &x) {
    if (count > 0) tout << ',';
    tout << '(' << x.first << " => " << x.second << ')';
    ++count;
  }
  ostream &tout;
  int count;
};
template <class T, class Q>
ostream &operator<<(ostream &tout, map<T, Q> s) {
  tout << '{';
  for_each(s.begin(), s.end(), print_map<T, Q>(tout));
  return (tout << '}');
}
template <class T>
string to_string(T s) {
  stringstream tin;
  tin << s;
  string res;
  getline(tin, res);
  return (res);
}
template <class T>
vector<T> to_vector(T *s, int n) {
  vector<T> result;
  for (int i = 0; i < n; i++) result.push_back(s[i]);
  return (result);
}
const int MAX_N = 3000 + 20;
int n;
vector<int> e[MAX_N];
set<pair<int, int> > cycle;
int dep[MAX_N];
bool mark[MAX_N];
int find_depth(int s, int t) {
  dep[s] = t;
  int v = 0;
  for (int i = 0; i < e[s].size(); i++)
    if (dep[e[s][i]]) {
      if (dep[e[s][i]] < t - 1) {
        v = e[s][i];
        cycle.insert(pair<int, int>(s, e[s][i]));
        cycle.insert(pair<int, int>(e[s][i], s));
      }
    } else {
      int q = find_depth(e[s][i], t + 1);
      if (q) {
        cycle.insert(pair<int, int>(s, e[s][i]));
        cycle.insert(pair<int, int>(e[s][i], s));
      }
      if (q && q != s) v = q;
    }
  return (v);
}
double ans = 0;
double f(pair<int, int> s) {
  if (s.second == 0)
    return (1.0 / (s.first + 1));
  else {
    int nw = cycle.size() / 2 - s.second - 1;
    int q = s.first + cycle.size() / 2 - s.second * 2;
    return (1.0 / (s.first + 1) + 1.0 / (q + 1) - 1.0 / (s.first + nw + 1));
  }
}
void dfs(int s, pair<int, int> t) {
  mark[s] = true;
  ans += f(t);
  for (int i = 0; i < e[s].size(); i++)
    if (!mark[e[s][i]]) {
      pair<int, int> q(t.first + 1, t.second);
      if (cycle.find(pair<int, int>(s, e[s][i])) != cycle.end()) q.second++;
      dfs(e[s][i], q);
    }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int a, b;
    cin >> a >> b;
    a++;
    b++;
    e[a].push_back(b);
    e[b].push_back(a);
  }
  find_depth(1, 3);
  ans = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) mark[j] = false;
    dfs(i, pair<int, int>(0, 0));
  }
  cout << fixed;
  cout.precision(12);
  cout << ans << endl;
}
