#include <bits/stdc++.h>
using namespace std;
int n, x, a[1000], ai[1000];
bool pos[1000];
vector<int> lens;
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> x, --x;
  memset(ai, -1, sizeof ai);
  memset(pos, false, sizeof pos);
  for (int i = 0; i < n; ++i) cin >> a[i], --a[i], ai[a[i]] = i;
  for (int i = 0; i < n; ++i)
    if (ai[i] == -1) {
      int curlen = 0, j = i, smart = -1;
      do {
        ++curlen;
        if (j == x) smart = curlen;
      } while ((j = a[j]) != -1);
      if (smart != -1)
        pos[curlen - smart] = true;
      else
        lens.push_back(curlen);
    }
  for (int i = 0; i < lens.size(); ++i)
    for (int j = n - 1; j >= lens[i]; --j) pos[j] |= pos[j - lens[i]];
  for (int i = 0; i < n; ++i)
    if (pos[i]) cout << (i + 1) << endl;
}
