#include <bits/stdc++.h>
using namespace std;
void decreaseKey(set<pair<int, int> > &pairs, map<int, set<int> > &data,
                 int decKey, int remVert) {
  pair<int, int> removePair;
  removePair.first = data[decKey].size();
  removePair.second = decKey;
  pairs.erase(removePair);
  data[decKey].erase(remVert);
  pair<int, int> newPair;
  newPair.first = data[decKey].size();
  newPair.second = decKey;
  if (newPair.first != 0) {
    pairs.insert(newPair);
  }
}
void deleteUnusedPairs(set<pair<int, int> > &pairs, map<int, set<int> > &data,
                       pair<int, int> &cheker) {
  vector<int> rem;
  rem.clear();
  vector<pair<int, int> > delet;
  delet.clear();
  for (set<pair<int, int> >::iterator iter = pairs.begin();
       iter != pairs.lower_bound(cheker); iter++) {
    pair<int, int> curr = *iter;
    rem.push_back(curr.second);
    delet.push_back(*iter);
  }
  for (int i = 0; i < delet.size(); i++) {
    pairs.erase(delet[i]);
  }
  for (int j = 0; j < rem.size(); j++) {
    for (set<int>::iterator iter = data[rem[j]].begin();
         iter != data[rem[j]].end(); iter++) {
      decreaseKey(pairs, data, *iter, rem[j]);
    }
    data.erase(rem[j]);
  }
}
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  map<int, set<int> > data;
  set<pair<int, int> > pairs;
  vector<int> pairsArr;
  vector<int> result;
  int x, y;
  for (int i = 1; i <= m; i++) {
    cin >> x >> y;
    data[x].insert(y);
    data[y].insert(x);
    pairsArr.push_back(x);
    pairsArr.push_back(y);
  }
  for (int i = 1; i <= n; i++) {
    if (data.count(i) > 0) {
      pair<int, int> p;
      p.first = data[i].size();
      p.second = i;
      pairs.insert(p);
    }
  }
  for (int i = 1; i <= m; i++) {
    pair<int, int> cheker;
    cheker.first = k;
    cheker.second = -20;
    while (pairs.size() != 0 && (*(pairs.begin())).first < k) {
      deleteUnusedPairs(pairs, data, cheker);
    }
    result.push_back(pairs.size());
    int currX = pairsArr.back();
    pairsArr.pop_back();
    int currY = pairsArr.back();
    pairsArr.pop_back();
    decreaseKey(pairs, data, currX, currY);
    decreaseKey(pairs, data, currY, currX);
  }
  for (int i = result.size() - 1; i >= 0; i--) {
    printf("%d\n", result[i]);
  }
  return 0;
}
