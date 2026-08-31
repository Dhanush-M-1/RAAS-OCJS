#include <bits/stdc++.h>
using namespace std;
struct book {
  int val;
  int index;
};
int n, m, k, tim, minTim = 2000000001;
int minIndexVal, xIndex[5];
vector<book> x[4];
int xS[5];
vector<int> books;
int currNum[4], minNum[4];
bool compareVal(book p1, book p2) { return p1.val < p2.val; }
int sizeOfCurrBooks() {
  int sum = 0;
  for (int i = 0; i < 4; i++) sum += currNum[i];
  return sum;
}
void removeMost(int l, int r) {
  int maxIndex = -1, maxVal = -1;
  for (int i = 0; i < 4; i++) {
    if (currNum[i] == 0) continue;
    if ((i == 1 || i == 2) && currNum[i] <= l) continue;
    if (i == 3 && currNum[i] <= r) continue;
    if (x[i][currNum[i] - 1].val > maxVal) {
      maxVal = x[i][currNum[i] - 1].val;
      maxIndex = i;
    }
  }
  tim -= maxVal;
  currNum[maxIndex]--;
}
void addLeast() {
  int minIndex = -1, minVal = 2000000001;
  for (int i = 0; i < 4; i++) {
    if (x[i][currNum[i]].val != 2000000001 && x[i][currNum[i]].val < minVal) {
      minVal = x[i][currNum[i]].val;
      minIndex = i;
    }
  }
  tim += minVal;
  currNum[minIndex]++;
}
void goToPoss(int l, int r) {
  if (currNum[3] >= r) {
    removeMost(l, r);
    removeMost(l, r);
    addLeast();
    addLeast();
  } else {
    tim += x[3][currNum[3]].val;
    currNum[3]++;
    removeMost(l, r);
    removeMost(l, r);
    addLeast();
  }
}
int main() {
  cin >> n >> m >> k;
  int t, a, b;
  for (int i = 0; i < n; i++) {
    cin >> t >> a >> b;
    x[2 * a + b].push_back({t, i});
  }
  for (int i = 0; i < 4; i++) {
    sort(x[i].begin(), x[i].end(), compareVal);
    xS[i] = (int)x[i].size();
    x[i].push_back({2000000001, -1});
  }
  xS[4] = min(xS[1], xS[2]);
  if (xS[3] + xS[4] < k || xS[3] + 2 * (k - xS[3]) > m)
    cout << -1 << endl;
  else {
    currNum[0] = 0;
    currNum[1] = m - k;
    currNum[2] = m - k;
    currNum[3] = 2 * k - m;
    if (xS[4] < m - k) {
      currNum[1] = xS[4];
      currNum[2] = xS[4];
      currNum[3] = k - xS[4];
    }
    while (currNum[3] < 0) {
      currNum[1]--;
      currNum[2]--;
      currNum[3]++;
    }
    int left = currNum[1], right = currNum[3];
    while (sizeOfCurrBooks() < m) {
      addLeast();
    }
    tim = 0;
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < currNum[i]; j++) tim += x[i][j].val;
    minTim = tim;
    for (int i = 0; i < 4; i++) minNum[i] = currNum[i];
    while (left > 0 && right < xS[3]) {
      left--;
      right++;
      goToPoss(left, right);
      if (tim < minTim) {
        minTim = tim;
        for (int i = 0; i < 4; i++) minNum[i] = currNum[i];
      }
    }
    cout << minTim << endl;
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < minNum[i]; j++) cout << x[i][j].index + 1 << " ";
  }
}
