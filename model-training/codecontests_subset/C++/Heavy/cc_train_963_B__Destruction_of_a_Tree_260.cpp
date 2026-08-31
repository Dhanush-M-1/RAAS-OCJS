#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
template <class T, class U>
inline void add_self(T &a, U b) {
  a += b;
  if (a >= mod) a -= mod;
  if (a < 0) a += mod;
}
template <class T, class U>
inline void min_self(T &x, U y) {
  if (y < x) x = y;
}
template <class T, class U>
inline void max_self(T &x, U y) {
  if (y > x) x = y;
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  cout << t;
  ;
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
template <class T, class U>
void print_m(const map<T, U> &m, int w = 3) {
  if (m.empty()) {
    cout << "Empty" << endl;
    return;
  }
  for (auto x : m) cout << "(" << x.first << ": " << x.second << ")," << endl;
  cout << endl;
}
template <class T, class U>
void debp(const pair<T, U> &pr, bool end_line = 1) {
  cout << "{" << pr.first << " " << pr.second << "}";
  cout << (end_line ? "\n" : ", ");
}
template <class T>
void print_vp(const T &vp, int sep_line = 0) {
  if (vp.empty()) {
    cout << "Empty" << endl;
    return;
  }
  if (!sep_line) cout << "{ ";
  for (auto x : vp) debp(x, sep_line);
  if (!sep_line) cout << "}\n";
  cout << endl;
}
template <typename T>
void print(const T &v, bool show_index = false) {
  int w = 2;
  if (show_index) {
    for (int i = 0; i < int((v).size()); i++) cout << setw(w) << i << " ";
    cout << endl;
  }
  for (auto &el : v) cout << setw(w) << el << " ";
  cout << endl;
}
template <typename T>
void print_vv(const T &vv) {
  if (int((vv).size()) == 0) {
    cout << "Empty" << endl;
    return;
  }
  int w = 3;
  cout << setw(w) << " ";
  for (int j = 0; j < int((*vv.begin()).size()); j++)
    cout << setw(w) << j << " ";
  cout << endl;
  int i = 0;
  for (auto &v : vv) {
    cout << i++ << " {";
    for (auto &el : v) cout << setw(w) << el << " ";
    cout << "},\n";
  }
  cout << endl;
}
template <typename T>
ostream &operator<<(ostream &os, const vector<T> &v) {
  print(v);
  return os;
};
template <typename T>
ostream &operator<<(ostream &os, const vector<vector<T>> &vv) {
  print_vv(vv);
  return os;
};
template <class T, class U>
ostream &operator<<(ostream &os, const map<T, U> &m) {
  print_m(m);
  return os;
};
template <class T, class U>
ostream &operator<<(ostream &os, const pair<T, U> &pr) {
  debp(pr);
  return os;
};
template <class T, class U>
ostream &operator<<(ostream &os, const vector<pair<T, U>> &vp) {
  print_vp(vp);
  return os;
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  while (cin >> n) {
    vector<vector<int>> adj(n + 1);
    int root = 0;
    for (int i = int(1); i < int(n + 1); i++) {
      int p;
      cin >> p;
      if (p) {
        adj[i].push_back(p);
        adj[p].push_back(i);
      } else {
        root = i;
      }
    }
    if (n % 2 == 0) {
      cout << "NO\n";
      continue;
    } else {
      cout << "YES\n";
    }
    vector<int> order;
    vector<bool> used(n + 1);
    vector<int> cnt(n + 1);
    for (int i = int(1); i < int(n + 1); i++) {
      cnt[i] = int((adj[i]).size());
    }
    function<void(int, int)> dfs = [&](int node, int p) {
      for (auto ad : adj[node]) {
        if (ad == p) continue;
        dfs(ad, node);
      }
      if (cnt[node] % 2 == 0) {
        queue<int> q;
        q.push(node);
        while (!q.empty()) {
          auto top = q.front();
          q.pop();
          assert(cnt[top] % 2 == 0);
          order.push_back(top);
          used[top] = 1;
          for (auto ad : adj[top]) {
            if (ad == p || used[ad]) continue;
            cnt[ad]--;
            q.push(ad);
          }
        }
        cnt[p]--;
      }
    };
    dfs(root, 0);
    print(order);
  }
  return 0;
}
