#include <bits/stdc++.h>
using namespace std;
int main() {
  string c;
  cin >> c;
  vector<char> v;
  for (int i = 0; i < c.size(); i++) {
    if (c[i] == '+') continue;
    v.push_back(c[i]);
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < v.size() - 1; i++) printf("%d+", v[i] - 48);
  printf("%d\n", v[v.size() - 1] - 48);
}
