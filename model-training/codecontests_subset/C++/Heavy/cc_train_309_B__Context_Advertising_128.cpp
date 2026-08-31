#include <bits/stdc++.h>
using namespace std;
int fit[1000002][19];
vector<string> words;
int main() {
  long long n, r, c;
  cin >> n >> r >> c;
  vector<string> words(n);
  for (int i = 0; i < n; i++) cin >> words[i];
  int lp = 0;
  int rp = 0;
  int numchars = -1;
  while (lp < n) {
    while (rp < n && numchars + words[rp].size() + 1 <= c) {
      numchars += words[rp].size() + 1;
      rp++;
    }
    fit[lp][0] = rp;
    numchars -= words[lp].size() + 1;
    lp++;
    if (rp < lp) {
      numchars = -1;
      rp = lp;
    }
  }
  int logr = 0;
  while ((1 << logr) <= r) logr++;
  logr--;
  for (int j = 0; j <= logr; j++) fit[n][j] = n;
  for (int j = 1; j <= logr; j++) {
    for (int i = 0; i < n; i++) {
      fit[i][j] = fit[fit[i][j - 1]][j - 1];
    }
  }
  int bestidx = -1;
  int bestcnt = -1;
  for (int i = 0; i < n; i++) {
    int curridx = i;
    int tmpr = r;
    for (int j = logr; j >= 0; j--) {
      if ((1 << j) <= tmpr) {
        curridx = fit[curridx][j];
        tmpr -= (1 << j);
        if (curridx == n) break;
      }
    }
    if (curridx - i > bestcnt) {
      bestcnt = curridx - i;
      bestidx = i;
    }
  }
  numchars = -1;
  for (int i = bestidx; i < bestidx + bestcnt; i++) {
    if (numchars + words[i].size() + 1 > c) {
      cout << "\n";
      numchars = -1;
    }
    if (numchars != -1) cout << " ";
    cout << words[i];
    numchars += words[i].size() + 1;
  }
  return 0;
}
