#include <bits/stdc++.h>
using namespace std;
vector<string> split(const string& s, const string& delim = " ") {
  vector<string> res;
  string t;
  for (int i = 0; i != s.size(); i++) {
    if (delim.find(s[i]) != string::npos) {
      if (!t.empty()) {
        res.push_back(t);
        t = "";
      }
    } else {
      t += s[i];
    }
  }
  if (!t.empty()) {
    res.push_back(t);
  }
  return res;
}
vector<int> splitInt(const string& s, const string& delim = " ") {
  vector<string> tok = split(s, delim);
  vector<int> res;
  for (int i = 0; i != tok.size(); i++) res.push_back(atoi(tok[i].c_str()));
  return res;
}
template <typename T>
void print(T a) {
  cerr << a;
}
static void print(long long a) { cerr << a << "L"; }
static void print(string a) { cerr << '"' << a << '"'; }
template <typename T>
void print(vector<T> a) {
  cerr << "{";
  for (int i = 0; i != a.size(); i++) {
    if (i != 0) cerr << ", ";
    print(a[i]);
  }
  cerr << "}" << endl;
}
int r1, r2, c1, c2, d1, d2;
bool valid(vector<int>& x) {
  bool can = true;
  can &= (x[0] + x[1] == r1);
  can &= (x[2] + x[3] == r2);
  can &= (x[0] + x[2] == c1);
  can &= (x[1] + x[3] == c2);
  can &= (x[0] + x[3] == d1);
  can &= (x[1] + x[2] == d2);
  return can;
}
int main() {
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    vector<int> p;
    for (int i = 0, _n = (5); i < _n; i++) p.push_back(0);
    for (int i = 0, _n = (4); i < _n; i++) p.push_back(1);
    vector<int> res;
    bool found = 0;
    do {
      vector<int> temp;
      for (int i = 0, _n = (p.size()); i < _n; i++)
        if (p[i]) temp.push_back(i + 1);
      do {
        if (valid(temp)) {
          res = temp;
          found = 1;
          break;
        }
      } while (next_permutation(temp.begin(), temp.end()));
    } while (!found && next_permutation(p.begin(), p.end()));
    if (!found)
      cout << -1 << endl;
    else {
      cout << res[0] << " " << res[1] << endl;
      cout << res[2] << " " << res[3] << endl;
    }
  }
  return 0;
}
