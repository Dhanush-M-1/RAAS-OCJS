#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 100;
const int sq = 320;
int n, answer;
set<int> satr[MAXN], sot[MAXN];
set<pair<int, int>> ssatr, ssot;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x, y;
    cin >> x >> y;
    satr[x].insert(y);
    sot[y].insert(x);
  }
  for (int i = 0; i < MAXN; i++) {
    if (satr[i].size()) {
      ssatr.insert({satr[i].size(), i});
    }
  }
  for (int i = 0; i < MAXN; i++) {
    if (sot[i].size()) {
      ssot.insert({sot[i].size(), i});
    }
  }
  while (ssatr.size()) {
    if (ssatr.begin()->first <= sq) {
      int ind = ssatr.begin()->second;
      ssatr.erase(ssatr.begin());
      for (auto i : satr[ind]) {
        for (auto j : satr[ind]) {
          if (j >= i) {
            break;
          }
          int num = i - j;
          if ((num + ind) < MAXN && satr[num + ind].count(i) &&
              satr[num + ind].count(j)) {
            answer++;
          }
          if ((ind - num) >= 0 && satr[ind - num].count(i) &&
              satr[ind - num].count(j)) {
            answer++;
          }
        }
      }
      for (auto i : satr[ind]) {
        pair<int, int> me = {sot[i].size(), i};
        ssot.erase(me);
        me.first--;
        if (me.first > 0) {
          ssot.insert(me);
        }
        sot[i].erase(ind);
      }
      satr[ind].clear();
    } else {
      int ind = ssot.begin()->second;
      ssot.erase(ssot.begin());
      for (auto i : sot[ind]) {
        for (auto j : sot[ind]) {
          if (j >= i) {
            break;
          }
          int num = i - j;
          if ((num + ind) < MAXN && sot[num + ind].count(i) &&
              sot[num + ind].count(j)) {
            answer++;
          }
          if ((ind - num) >= 0 && sot[ind - num].count(i) &&
              sot[ind - num].count(j)) {
            answer++;
          }
        }
      }
      for (auto i : sot[ind]) {
        pair<int, int> me = {satr[i].size(), i};
        ssatr.erase(me);
        me.first--;
        if (me.first > 0) {
          ssatr.insert(me);
        }
        satr[i].erase(ind);
      }
      sot[ind].clear();
    }
  }
  cout << answer << endl;
  return 0;
}
