#include <bits/stdc++.h>
using namespace std;
int main() {
  string cad;
  cin >> cad;
  vector<char> ns;
  for (int i = 0; i < (int)cad.size(); i++) {
    if (isdigit(cad[i])) ns.push_back(cad[i]);
  }
  sort(ns.begin(), ns.end());
  for (int i = 0; i < (int)ns.size(); i++) {
    cout << ns[i] << (i + 1 < (int)ns.size() ? "+" : "\n");
  }
  return 0;
}
