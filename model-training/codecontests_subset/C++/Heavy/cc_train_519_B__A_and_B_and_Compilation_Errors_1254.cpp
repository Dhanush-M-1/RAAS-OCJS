#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:20000000")
string problem_name = "a";
void init() { freopen((problem_name + ".in").c_str(), "rt", stdin); }
int f(char c) {
  if (c == '.') return 0;
  int flag = 0;
  if (isupper(c)) flag = 1;
  c = tolower(c);
  int res = 0;
  if (c == 'q') res = 9;
  if (c == 'r') res = 5;
  if (c == 'b') res = 3;
  if (c == 'n') res = 3;
  if (c == 'p') res = 1;
  if (c == 'k') res = 0;
  if (flag) return res;
  return -res;
}
multiset<int> s, s2;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int t;
    scanf("%d", &t);
    s.insert(t);
    s2.insert(t);
  };
  for (int i = 0; i < n - 1; i++) {
    int t;
    scanf("%d", &t);
    s.erase(s.find(t));
  };
  cout << *s.begin();
  s2.erase(s2.find(*s.begin()));
  cout << endl;
  for (int i = 0; i < n - 2; i++) {
    int t;
    scanf("%d", &t);
    s2.erase(s2.find(t));
  };
  cout << *s2.begin();
  return 0;
}
