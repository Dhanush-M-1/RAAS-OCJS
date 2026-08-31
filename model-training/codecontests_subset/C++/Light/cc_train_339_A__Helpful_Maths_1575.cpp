#include <bits/stdc++.h>
using namespace std;
int main() {
  string x;
  cin >> x;
  vector<int> v;
  for (auto i : x) {
    if (i - '0' >= 0 && i - '0' <= 9) {
      v.push_back(i - '0');
    }
  }
  sort(v.begin(), v.end());
  for (register int i = 0; i < (int)v.size() - 1; i++) printf("%d+", v[i]);
  printf("%d\n", v[v.size() - 1]);
  return 0;
}
