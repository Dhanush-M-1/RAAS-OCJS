#include <bits/stdc++.h>
using namespace std;
template <class A>
void read(vector<A>& v);
template <class T>
void read(T& x) {
  cin >> x;
}
void read(double& d) {
  string t;
  read(t);
  d = stod(t);
}
void read(long double& d) {
  string t;
  read(t);
  d = stold(t);
}
template <class H, class... T>
void read(H& h, T&... t) {
  read(h);
  read(t...);
}
template <class A>
void read(vector<A>& x) {
  for (auto& a : x) read(a);
}
string to_string(char c) { return string(1, c); }
string to_string(bool b) { return b ? "true" : "false"; }
string to_string(const char* s) { return string(s); }
string to_string(string s) { return string(s); }
string to_string(vector<bool> v) {
  string res;
  for (int i = 0; i < (int)(v).size(); i++) {
    res += char('0' + v[i]);
  }
  return res;
}
template <class T>
string to_string(T v) {
  bool f = 1;
  string res;
  for (auto& x : v) {
    if (!f) res += ' ';
    f = 0;
    res += to_string(x);
  }
  return res;
}
template <class A>
void write(A x) {
  cout << to_string(x);
}
template <class H, class... T>
void write(const H& h, const T&... t) {
  write(h);
  write(t...);
}
void print() { write("\n"); }
template <class H, class... T>
void print(const H& h, const T&... t) {
  write(h);
  if (sizeof...(t)) write(' ');
  print(t...);
}
void pre() {}
void solve() {
  int n;
  read(n);
  vector<string> s(n);
  for (int i = 0; i < n; i++) {
    read(s[i]);
  }
  vector<pair<int, int>> ans;
  int tot = 0;
  if (s[0][1] == '1') {
    tot++;
    ans.push_back({0, 1});
  }
  if (s[1][0] == '1') {
    tot++;
    ans.push_back({1, 0});
  }
  if (s[2][0] == '0') {
    tot++;
    ans.push_back({2, 0});
  }
  if (s[1][1] == '0') {
    tot++;
    ans.push_back({1, 1});
  }
  if (s[0][2] == '0') {
    tot++;
    ans.push_back({0, 2});
  }
  if (tot <= 2) {
    print(tot);
    for (auto itr : ans) {
      cout << itr.first + 1 << " " << itr.second + 1 << "\n";
    }
    return;
  }
  tot = 0;
  ans.clear();
  if (s[0][1] == '0') {
    tot++;
    ans.push_back({0, 1});
  }
  if (s[1][0] == '0') {
    tot++;
    ans.push_back({1, 0});
  }
  if (s[2][0] == '1') {
    tot++;
    ans.push_back({2, 0});
  }
  if (s[1][1] == '1') {
    tot++;
    ans.push_back({1, 1});
  }
  if (s[0][2] == '1') {
    tot++;
    ans.push_back({0, 2});
  }
  if (tot <= 2) {
    print(tot);
    for (auto itr : ans) {
      cout << itr.first + 1 << " " << itr.second + 1 << "\n";
    }
    return;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  pre();
  int t = 1;
  read(t);
  for (int i = 0; i < t; i++) solve();
  return 0;
}
