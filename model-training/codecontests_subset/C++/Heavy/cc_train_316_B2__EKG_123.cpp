#include <bits/stdc++.h>
using namespace std;
const int nmax = 1002;
int n, X;
int t[nmax];
bool use[nmax];
bool sum[nmax];
vector<int> links;
int main() {
  cin >> n >> X;
  for (int i = 1; i <= n; ++i) {
    cin >> t[i];
    use[t[i]] = 1;
  }
  int smartTop = -1;
  for (int i = 1; i <= n; ++i) {
    if (!use[i]) {
      int qSize = 0;
      bool smartB = false;
      int j = i;
      while (j != 0) {
        qSize++;
        if (j == X) {
          smartB = true;
        }
        use[j] = true;
        j = t[j];
      }
      if (smartB) {
        smartTop = i;
      } else {
        links.push_back(qSize);
      }
    }
  }
  int smartSize = 0, smartPos = 0;
  while (smartTop != 0) {
    smartSize++;
    if (smartTop == X) {
      smartPos = smartSize;
    }
    smartTop = t[smartTop];
  }
  sort(links.begin(), links.end());
  sum[0] = true;
  for (int i = 0; i < (int)links.size(); ++i) {
    for (int j = n - smartSize; j >= links[i]; --j) {
      sum[j] |= sum[j - links[i]];
    }
  }
  smartPos = smartSize - smartPos + 1;
  for (int j = 0; j <= n - smartSize; ++j) {
    if (sum[j]) {
      cout << j + smartPos << "\n";
    }
  }
  return 0;
}
