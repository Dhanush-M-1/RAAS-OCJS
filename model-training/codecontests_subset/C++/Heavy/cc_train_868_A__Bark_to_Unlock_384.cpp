#include <bits/stdc++.h>
using namespace std;
string DBG_DLM(int& i) { return (i++ == 0 ? "" : ", "); }
template <class T>
ostream& operator<<(ostream& os, vector<T> v);
template <class T>
ostream& operator<<(ostream& os, set<T> v);
template <class T>
ostream& operator<<(ostream& os, queue<T> q);
template <class T>
ostream& operator<<(ostream& os, priority_queue<T> q);
template <class T, class K>
ostream& operator<<(ostream& os, pair<T, K> p);
template <class T, class K>
ostream& operator<<(ostream& os, map<T, K> mp);
template <class T, class K>
ostream& operator<<(ostream& os, unordered_map<T, K> mp);
template <int I, class TPL>
void DBG(ostream& os, TPL t) {}
template <int I, class TPL, class H, class... Ts>
void DBG(ostream& os, TPL t) {
  os << (I == 0 ? "" : ", ") << get<I>(t);
  DBG<I + 1, TPL, Ts...>(os, t);
}
template <class T, class K>
void DBG(ostream& os, pair<T, K> p, string delim) {
  os << "(" << p.first << delim << p.second << ")";
}
template <class... Ts>
ostream& operator<<(ostream& os, tuple<Ts...> t) {
  os << "(";
  DBG<0, tuple<Ts...>, Ts...>(os, t);
  os << ")";
  return os;
}
template <class T, class K>
ostream& operator<<(ostream& os, pair<T, K> p) {
  DBG(os, p, ", ");
  return os;
}
template <class T>
ostream& operator<<(ostream& os, vector<T> v) {
  {
    int i = 0;
    os << "{";
    {
      for (auto&& t : v) {
        os << DBG_DLM(i) << t;
      };
    }
    os << "}";
    return os;
  };
}
template <class T>
ostream& operator<<(ostream& os, set<T> s) {
  {
    int i = 0;
    os << "{";
    {
      for (auto&& t : s) {
        os << DBG_DLM(i) << t;
      };
    }
    os << "}";
    return os;
  };
}
template <class T>
ostream& operator<<(ostream& os, queue<T> q) {
  {
    int i = 0;
    os << "{";
    {
      for (; q.size(); q.pop()) {
        os << DBG_DLM(i) << q.front();
      };
    }
    os << "}";
    return os;
  };
}
template <class T>
ostream& operator<<(ostream& os, priority_queue<T> q) {
  {
    int i = 0;
    os << "{";
    {
      for (; q.size(); q.pop()) {
        os << DBG_DLM(i) << q.top();
      };
    }
    os << "}";
    return os;
  };
}
template <class T, class K>
ostream& operator<<(ostream& os, map<T, K> m) {
  {
    int i = 0;
    os << "{";
    {
      for (auto&& p : m) {
        os << DBG_DLM(i);
        DBG(os, p, "->");
      };
    }
    os << "}";
    return os;
  };
}
template <class T, class K>
ostream& operator<<(ostream& os, unordered_map<T, K> m) {
  {
    int i = 0;
    os << "{";
    {
      for (auto&& p : m) {
        os << DBG_DLM(i);
        DBG(os, p, "->");
      };
    }
    os << "}";
    return os;
  };
}
using ll = long long;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using pil = pair<int, ll>;
using pli = pair<ll, int>;
using vs = vector<string>;
using vvs = vector<vs>;
using vvvs = vector<vvs>;
using vb = vector<bool>;
using vvb = vector<vb>;
using vvvb = vector<vvb>;
using vi = vector<int>;
using vvi = vector<vi>;
using vvvi = vector<vvi>;
using vl = vector<ll>;
using vvl = vector<vl>;
using vvvl = vector<vvl>;
using vd = vector<double>;
using vvd = vector<vd>;
using vvvd = vector<vvd>;
using vpii = vector<pii>;
using vvpii = vector<vpii>;
using vvvpii = vector<vvpii>;
template <class A, class B>
bool amax(A& a, const B& b) {
  return b > a ? a = b, 1 : 0;
}
template <class A, class B>
bool amin(A& a, const B& b) {
  return b < a ? a = b, 1 : 0;
}
ll ri() {
  ll l;
  cin >> l;
  return l;
}
string rs() {
  string s;
  cin >> s;
  return s;
}
void Main() {
  string s = rs();
  int n = ri();
  vs W(n);
  for (int i = int(0); i < int(n); ++i) {
    W[i] = rs();
    if (W[i] == s) {
      cout << "YES" << endl;
      return;
    }
  }
  for (int i = int(0); i < int(n); ++i)
    for (int j = int(0); j < int(n); ++j) {
      if (W[i][1] == s[0] && W[j][0] == s[1]) {
        cout << "YES" << endl;
        return;
      }
    }
  cout << "NO" << endl;
}
signed main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  Main();
  return 0;
}
