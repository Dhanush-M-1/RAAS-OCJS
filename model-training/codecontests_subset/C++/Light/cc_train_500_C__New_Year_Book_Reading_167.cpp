#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  vector<int> w(n), b(m);
  for (int i = (0); i < (n); ++i) cin >> w[i];
  for (int i = (0); i < (m); ++i) cin >> b[i];
  vector<int> visited(n, false);
  list<int> stack;
  for (auto it : b)
    if (!visited[it - 1]) {
      visited[it - 1] = true;
      stack.push_back(it);
    }
  long long res = 0;
  for (auto it : b) {
    list<int>::iterator jt;
    for (jt = stack.begin(); jt != stack.end(); jt++) {
      if (*jt != it)
        res += w[*jt - 1];
      else
        break;
    }
    stack.erase(jt);
    stack.insert(stack.begin(), it);
  }
  cout << res;
}
