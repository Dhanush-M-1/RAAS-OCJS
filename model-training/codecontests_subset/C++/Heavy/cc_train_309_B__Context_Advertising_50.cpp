#include <bits/stdc++.h>
using namespace std;
struct node {
  int wordct;
  int nxtidx;
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, r1, c;
  cin >> n >> r1 >> c;
  vector<string> words;
  vector<int> len;
  for (int q = 0; q < n; q++) {
    string s;
    cin >> s;
    words.push_back(s);
    len.push_back(s.size() + 1);
  }
  vector<node> blocks(n + 1);
  blocks[n].wordct = 0;
  blocks[n].nxtidx = n;
  int l = 0, r = 0, curlen = 0, curwords = 0;
  while (l < n) {
    while (r < n && curlen + len[r] <= c + 1) {
      curlen += len[r];
      curwords++;
      r++;
    }
    if (l == r) {
      blocks[l].wordct = 0;
      blocks[l].nxtidx = l;
      l++;
      r++;
      curlen = 0;
      curwords = 0;
    } else {
      blocks[l].wordct = curwords;
      blocks[l].nxtidx = r;
      curlen -= len[l];
      curwords--;
      l++;
    }
  }
  vector<vector<pair<int, int>>> binlift(n + 1, vector<pair<int, int>>(21));
  for (int q = 0; q < n + 1; q++) {
    binlift[q][0].first = blocks[q].nxtidx;
    binlift[q][0].second = blocks[q].wordct;
  }
  for (int q = 1; q < 21; q++) {
    for (int w = 0; w < n + 1; w++) {
      binlift[w][q].first = binlift[binlift[w][q - 1].first][q - 1].first;
      binlift[w][q].second = binlift[w][q - 1].second +
                             binlift[binlift[w][q - 1].first][q - 1].second;
    }
  }
  int best = -1;
  int bestidx = -1;
  for (int q = 0; q < n; q++) {
    int cur = q;
    int tot = 0;
    for (int w = 20; w >= 0; w--) {
      if ((r1 >> w) & 1) {
        tot += binlift[cur][w].second;
        cur = binlift[cur][w].first;
      }
    }
    if (tot > best) {
      bestidx = q;
      best = tot;
    }
  }
  for (int q = 0; q < r1; q++) {
    for (int w = bestidx; w < blocks[bestidx].nxtidx; w++) {
      cout << words[w];
      if (w != blocks[bestidx].nxtidx - 1) {
        cout << " ";
      }
    }
    cout << "\n";
    bestidx = blocks[bestidx].nxtidx;
  }
  return 0;
}
