#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
void addSelf(long long& x, long long y) {
  x += y;
  if (x >= mod) x -= mod;
}
void subSelf(long long& x, long long y) {
  x -= y;
  if (x < 0) x += mod;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, m;
  cin >> n >> m;
  vector<int> weight(n);
  for (int i = 0; i < n; ++i) {
    cin >> weight[i];
  }
  vector<int> read(m);
  for (int i = 0; i < m; ++i) {
    cin >> read[i];
    read[i]--;
  }
  vector<int> seen(n, false);
  vector<int> initialStack;
  for (int i = 0; i < m; ++i) {
    if (!seen[read[i]]) {
      seen[read[i]] = true;
      initialStack.push_back(read[i]);
    }
  }
  long long sumi = 0;
  for (int i = 0; i < m; ++i) {
    int breaking = 0;
    for (int j = 0; j < n; ++j) {
      if (initialStack[j] == read[i]) {
        breaking = j;
        break;
      }
      sumi += weight[initialStack[j]];
    }
    int temp = initialStack[breaking];
    for (int j = breaking; j > 0; --j) {
      initialStack[j] = initialStack[j - 1];
    }
    initialStack[0] = temp;
  }
  cout << sumi;
}
