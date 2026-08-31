#include <bits/stdc++.h>
using namespace std;

int n;

void f(string s, int i) {
  if(s.size() == n) {
    cout << s << endl;
    return;
  }
  for(int j = 1; j <= i + 1; j++) {
    string ns = s + (char)('a' + j - 1);
    f(ns, max(i, j));
  }
}

int main() {
  cin >> n;
  f("a", 1);
}